package rsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AttaqueDeElGamal {
	
	Calculs calc;
	
	public AttaqueDeElGamal()
	{
		this.calc = new Calculs();
	}
	
	public int AttaqueDeElGamalcalcul(int p,int s, int alpha, int C1, int C2)
	{
		int P = calc.calculC(alpha, s, p);
		int puissance = p-1-s;
		
		C1 = calc.calculC(C1,puissance,p);
		if(C1 == 0)
		{
			return 0;
		}
		
		int result = C1*C2;
		while(result>p)
		{
			result = result - p;
		}

		return result;
	}
	
	public List<String> AttaqueDeElGamalAvecSolution(int p,int s, int alpha, int C1, int C2)
	{
		ArrayList<String> retour = new ArrayList<>();
		int puissance = p-1-s;
		retour.add("Pas le même méthode que celle utiliser dans le cours !!! ");
		retour.add("Pour calculer M, il faut utiliser la formule M = C1^(p-1-k)*C2");
		retour.add("On commence par calculer p-1-k = "+p+"-1-"+s+" = "+puissance);
		retour.addAll(calc.calculCavecSolution(C1,puissance,p));
		C1 = calc.calculC(C1,puissance,p);
		retour.add("On a donc C1 = "+ C1);
		int result = C1*C2;
		while(result>p)
		{
			result = result - p;
		}
		retour.add("On fait ensuite C1*C2 = "+C1+" * "+C2+" = "+result+" modulo "+p);
		retour.add("M est donc égal a "+result);

		return retour;
	}
	
	public List<String> AttaqueDeElGamalAvecSolutionPlusDur(int p,int s, int alpha, int C1, int C2, int k)
	{
		ArrayList<String> retour = new ArrayList<>();
		int puissance = p-1-s;
		retour.add("Pas le même méthode que celle utiliser dans le cours !!! ");
		retour.add("Pour calculer M, il faut utiliser la formule M = C1^(p-1-k)*C2");
		retour.add("Or, nous n'avons pas k");
		retour.add("Il faut calculer k = log"+alpha+"("+calc.calculC(alpha, s, p)+") = "+s);
		retour.add("On calcule ensuite p-1-k = "+p+"-1-"+s+" = "+puissance);
		retour.addAll(calc.calculCavecSolution(C1,puissance,p));
		C1 = calc.calculC(C1,puissance,p);
		retour.add("On a donc C1 = "+ C1);
		int result = C1*C2;
		while(result>p)
		{
			result = result - p;
		}
		retour.add("On fait ensuite C1*C2 = "+C1+" * "+C2+" = "+result+" modulo "+p);
		retour.add("M est donc égal a "+result);

		return retour;
	}
	
	public List<String> coderMavecSolution(int p, int s, int alpha, int M, int k, boolean calcP)
	{
		ArrayList<String> retour = new ArrayList<>();
		retour.add("M = (C1,C2) = (g^r , M*h^r)");
		int P = 0;
		if(calcP)
		{
			P = calc.calculC(alpha, s, p);
			retour.add("Il faut commencer par calculer h qui est égal a g^k = "+alpha+"^"+s+" = "+P);
		}
		else
		{
			P = s;
		}
		
		retour.add("On commence par calculer C1 = g^r = "+alpha+"^"+k);
		retour.addAll(calc.calculCavecSolution(alpha, k, p));
		retour.add("C1 est donc égal a "+calc.calculC(alpha, k, p));
		retour.add("On calcule maintenant C2 avec C2 = M*h^r = "+M+"*"+P+"^"+k);
		retour.add("On commence par calculer "+P+"^"+k);
		retour.addAll(calc.calculCavecSolution(P, k, p));
		retour.add("Ensuite on multiplie M avec le résultat donc C2 = "+M+"*"+calc.calculC(P, k, p));
		int result = M*calc.calculC(P, k, p);
		while(result > p)
		{
			result = result - p;
		}
		retour.add("C2 est donc égal a "+result);
		retour.add("M est donc égal à ("+calc.calculC(alpha, k, p)+","+result+")");
		return retour;
	}
	
	public int[] coderM(int p, int s,int alpha, int M, int k, boolean calcP)
	{
		int[] retour = new int[2];
		int P = 0;
		if(calcP)
		{
			P = calc.calculC(alpha, s, p);
		}
		else
		{
			P = s;
		}
		retour[0] = calc.calculC(alpha, k, p);
		int result = M*calc.calculC(P, k, p);
		while(result > p)
		{
			result = result - p;
		}
		retour[1] = result;
		return retour;
	}
	
	public List<String> AttaqueDeElGamalLaVraiAvecSolution(int p, int alpha, int P, int c, int c2)
	{
		ArrayList<String> retour = new ArrayList<>();
		HashMap<Integer,Integer> s = new HashMap<>();
		int nb = 5;
		boolean ok = false;
		int q = 0;
		int r = 0;
		retour.add("Pour trouver m, il faut d'abord trouver s qui est égal q*m+r");
		int m = (int) Math.sqrt(p-1);
		retour.add("On calcule d'abord m = rac(p-1) = rac("+(p-1)+") = "+m);
		retour.add("Je ne fais pas la démonstration mais faut calculer d'abord alpha^m = "+alpha+" ^ "+m+" = "+calc.calculC(alpha, m, p));
		int pet = calc.calculC(alpha, (int) Math.sqrt(p-1), p);
		retour.add("On calcule ensuite alpha^(p-2) ="+alpha+"^"+(p-2)+" qui est égal à "+calc.calculC(alpha, p-2, p));
		int pet2 = calc.calculC(alpha, p-2, p);
		retour.add("On a donc une formule "+pet+"^q="+pet2+"^r*"+P);
		retour.add("On crée donc une liste 1 de S=("+pet+"^q,q) en avec q+1 a chaque fois et une liste 2 de T=("+pet2+"^r*"+P+") avec r entre 0 et 5");
		
		retour.add("Je calcules maintenant les T avec r de 0 à 5");
		for(int i = 0; i<=5;i++)
		{
			int res = calc.calculC(pet2,i,p) * P;
			while(res > p)
			{
				res = res - p;
			}
			retour.add("T"+i+" = ("+pet2+"^"+i+"*"+P+","+i+") = "+res+","+i+")");
			s.put(i,res);
		}
		retour.add("Je calcule donc S jusqu'a trouver un même numéro que T");
		do {
			for(int i = 1;i<=nb;i++)
			{
				retour.add("S"+i+" = ("+pet+"^"+i+","+i+") = "+calc.calculC(pet,i,p)+","+i+")");
				int result = calc.calculC(pet,i,p);
				for(int j = 0; j!=s.size();j++)
				{
					if(s.get(j)==result)
					{
						retour.add("Ici on remarque que "+result+" = "+s.get(j)+" la "+j+"ème valeur de S");
						q = i;
						r = j;
						ok = true;
					}
				}
			}
			nb = nb + 5;
		}while(!ok);
		
		retour.add("Ducoup q = "+q+" et r ="+r);
		int resultat = q*m+r;
		while(resultat > p)
		{
			resultat = resultat - p;
		}
		retour.add("On peut retrouver s avec la formule s=q*m+r = "+q+"*"+m+"+"+r+" = "+resultat);
		retour.addAll(AttaqueDeElGamalAvecSolution(p,resultat,alpha,c,c2));
		return retour;
	}
	
	public int AttaqueDeElGamalLaVrai(int p, int alpha, int P, int c, int c2)
	{
		HashMap<Integer,Integer> s = new HashMap<>();
		int nb = 5;
		boolean ok = false;
		int q = 0;
		int r = 0;
		int m = (int) Math.sqrt(p-1);
		int pet = calc.calculC(alpha, (int) Math.sqrt(p-1), p);
		int pet2 = calc.calculC(alpha, p-2, p);
		for(int i = 0; i<=5;i++)
		{
			int res = calc.calculC(pet2,i,p) * P;
			while(res > p)
			{
				res = res - p;
			}
			s.put(i,res);
		}
		do {
			for(int i = 1;i<=nb;i++)
			{
				int result = calc.calculC(pet,i,p);
				for(int j = 0; j!=s.size();j++)
				{
					if(s.get(j)==result)
					{
						q = i;
						r = j;
						ok = true;
					}
				}
			}
			nb = nb + 5;
		}while(!ok);
		
		int resultat = q*m+r;
		while(resultat > p)
		{
			resultat = resultat - p;
		}
		return AttaqueDeElGamalcalcul(p,resultat,alpha,c,c2);
	}

}
