package rsa;

import java.util.ArrayList;
import java.util.List;

public class AttaqueDeWeiner {
	
	private int p;
	private int q;
	private Rsa a;
	private Calculs calc;
	
	public AttaqueDeWeiner(int p, int q, Rsa a)
	{
		this.p = p;
		this.q = q;
		this.a = a;
		this.calc = new Calculs();
	}
	
	public boolean AttaqueDeWeinerResult(int e, int n, int C, int M)
	{
		List<Integer> p = new ArrayList<Integer>();
		List<Integer> q = new ArrayList<Integer>();
		List<Integer> fraction = new ArrayList<Integer>();
		fraction = calc.fractioncontinue(e,n);
		
		p = a.fractionreduitesP(fraction);
		q = a.fractionreduitesQ(fraction);
		
		int i = 1;
		int premierC = C;
		while(i<q.size() && C!=M)
		{
			for(int puissance = i; puissance<q.get(i);puissance++)
			{
				C = C * premierC;
				while(C>n)
				{
					C = C-n;
				}
			}
			i++;
		}
		
		if(C==M)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public List<String> AttaqueDeWeineravecSolution(int e, int n, int C, int M)
	{
		List<Integer> p = new ArrayList<Integer>();
		List<Integer> q = new ArrayList<Integer>();
		List<Integer> fraction = new ArrayList<Integer>();
		fraction = calc.fractioncontinue(e,n);
		
		p = a.fractionreduitesP(fraction);
		q = a.fractionreduitesQ(fraction);
		
		List<String> retour = new ArrayList<>();
		retour.add("Tout d'abord nous avons en fractions continue :");
		String frac = "[";
		for(int i : fraction)
		{
			frac += i+",";
		}
		frac+="]";
		retour.add(frac);
		
		retour.add("Pour trouver d avec C il faut faire C^tous les denominateurs des fractions continue jusqu'à trouver M :");
		
		int i = 1;
		int premierC = C;
		int ps = 1;
		int puissance = 1;
		while(i<q.size() && C!=M)
		{
			if(q.get(i)!=1)
			{
				do
				{
					C = C * premierC;
					while(C>n)
					{
						C = C-n;
					}
					ps++;
					puissance++;
				}while(puissance<q.get(i));
			}
			retour.add("C"+i+" = C^"+(q.get(i))+" = "+C);
			i++;
		}
		retour.add("Ici C"+(i-1)+"=M donc d = la puissance = "+ps);
		
		return retour;
	}


}
