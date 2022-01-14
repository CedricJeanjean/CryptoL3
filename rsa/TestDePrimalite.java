package rsa;

import java.util.ArrayList;
import java.util.List;

public class TestDePrimalite {
	
	private Calculs calc;
	
	public TestDePrimalite()
	{
		this.calc = new Calculs();
	}

	public boolean premier(int nb, int ensmax)
	{
		int a = 2;
		int result = 0;
		do {
			result = calc.calculC(a, nb-1, nb);
			a++;
		}while(result != 1 && a<5);
		if(result != 1)
		{
			return false;
		}
		
		List<Integer> decom = new ArrayList<>();
		decom.addAll(calc.decompositionennbpremiers(nb-1));
		if(decom.get(decom.size()-1) > ensmax)
		{
			return false;
		}
		
		for(int i = 0; i<decom.size(); i++)
		{
			a = 2;
			do {
				result = calc.calculC(a, decom.get(i), nb);
				a++;
			}while(result == 1 && a<10);
			if(result == 1)
			{
				return false;
			}
		}
		return true;
	}
	
	public List<String> premierAvecSolution(int nb, int ensmax)
	{
		int a = 2;
		int result = 0;
		List<String> retour = new ArrayList<String>();
		retour.add("On a "+nb+" donc on prends "+nb+"-1 = "+(nb-1));
		retour.add("On prend a1 = 2");
		do {
			result = calc.calculC(a, nb-1, nb);
			retour.add("a = "+a+"^"+(nb-1)+" = "+result);
			if(result != 1)
			{
				retour.add("Ici le resultat != 1 donc on fait a+1 et on continue");
			}
			a++;
		}while(result != 1 && a<5);
		
		retour.add("On a le resultat = 1");
		retour.add("On decompose maitenant "+(nb-1)+" en nombres premiers");
		List<Integer> decom = new ArrayList<>();
		decom.addAll(calc.decompositionennbpremiers(nb-1));
		
		for(int i = 0; i<decom.size(); i++)
		{
			retour.add("Nombre premier "+(i+1)+" = "+decom.get(i));
			a = 2;
			do {
				result = calc.calculC(a, decom.get(i), nb);
				retour.add("a = "+a+"^"+decom.get(i)+" = "+result);
				a++;
			}while(result == 1 && a<5);
			if(result == 1)
			{
				retour.add("On a le resultat qui est egal a 1 donc le nombre n'est pas premier");
				return retour;
			}
		}
		retour.add("Aucun des resultat est egal a 1 donc le nombre est premier");
		return retour;
	}
}
