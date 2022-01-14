package rsa;

import java.util.ArrayList;
import java.util.List;

public class AttaqueDeSimonsEtNoris {
	
	private Calculs calc;
	
	public AttaqueDeSimonsEtNoris()
	{
		this.calc = new Calculs();
	}
	
	public int AttaqueDeSimonsEtNorisResult(int C, int e, int n)
	{
		int i = 0;
		ArrayList<Integer> result = new ArrayList<>();
		result.add(C);
		do
		{
			i++;
			result.add(calc.calculC(result.get(i-1), e, n));
		}while(result.get(i) != C && i<11);
		
		if(result.get(i) == C)
		{
			return result.get(i-1);
		}
		else
		{
			return 0;
		}
			
	}
	
	public List<String> AttaqueDeSimonsEtNorisAvecSolution(int C, int e, int n)
	{
		List<String> retour = new ArrayList<>();
		retour.add("Pour faire l'attaque de Simmons et Noris il faut faire C^e mod n en remplaçant C à chaque itération jusqu'a que l'on retrouve le premier C");
		retour.add("On commence donc par calculer "+C+"^"+e+" (Faut le calculer avec les puissances en binaire tout ça normalement ici tu sait le faire hein?)");
		int i = 0;
		ArrayList<Integer> result = new ArrayList<>();
		result.add(C);
		do
		{
			i++;
			result.add(calc.calculC(result.get(i-1), e, n));
			retour.add("C^"+i+"="+result.get(i-1)+"^"+e+"="+result.get(i)+" mod "+n);
		}while(result.get(i) != C && i<11);
		
		retour.add("On trouve donc C^"+i+" = "+result.get(i)+" qui est égal au premier C donc M est le resultat d'avant donc "+result.get(i-1));
		return retour;
			
	}

}
