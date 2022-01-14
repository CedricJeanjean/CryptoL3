package rsa;

import java.util.ArrayList;
import java.util.List;

public class AttaqueDePollard {
	
	private Calculs calc;
	private int p;
	private int q;
	
	public AttaqueDePollard() {
		this.calc = new Calculs();
	}
	
	public boolean AttaqueDePollard3Result(int n , int x1)
	{
		List<Integer> nbpremiers = new ArrayList<>();
 		int result = 0;
		int i = 2;
		int p = 0;
		int q = 0;
		
		while((p == 0 && q == 0) || i<10)
		{
			if(i>=4)
			{
				result = calc.calculC(result, i, n);
			}
			else {
				result = (int) Math.pow(x1,i);
			}
			
			while(result>n)
			{
				result = result - n;
			}
			nbpremiers = calc.decompositionennbpremiers(result-1);
			for(int k = 0; k<nbpremiers.size(); k++)
			{
				if(calc.pgcd(nbpremiers.get(k), n) != 1)
				{
					p = nbpremiers.get(k);
					q = n/p;
					return true;
				}
			}

		i++;
		x1 = result;
		}
		return false;
	}
	
	public boolean AttaqueDePollard2Result(int n , int x, int b)
	{
		int y=x;
		int result = 0;
		int j = 0;
		
		do
		{
			x = (int) (Math.pow(x,2) + b);
			while(x>n)
			{
				x = x -n;
			}
			
			for(int i=0; i<2; i++)
			{
				y = (int) (Math.pow(y, 2) + b);
				while(y>n)
				{
					y = y -n;
				}
			}
			
			result = x-y;
			while(result<0)
			{
				result = result + n;
			}
			j++;
		}while(calc.pgcd(result, n) == 1 && j<10 && calc.pgcd(result, n) == 0);
 		
		if(j==10)
		{
			return false;
		}
		else
		{
			this.p = calc.pgcd(result, n);
			this.q = n / this.p;
			return true;
		}
	}
	
	public List<String> AttaqueDePollard2AvecSolution(int n , int x, int b)
	{
		List<String> retour = new ArrayList<>();
		int y=x;
		int result = 0;
		int j = 0;
		int xavant = x;
		int yavant = y;
		
		retour.add("On a donc n = "+n+", x0 = "+x+ " et b ="+b);
		retour.add("Pour utiliser pollard 2 on a x = x² + b et y = (y²+b)² + b");
		
		do
		{
			x = (int) (Math.pow(x,2) + b);
			while(x>n)
			{
				x = x -n;
			}
			retour.add("x = "+ xavant+"² + "+b+" = "+x);
			
			for(int i=0; i<2; i++)
			{
				y = (int) (Math.pow(y, 2) + b);
				while(y>n)
				{
					y = y -n;
				}
			}
			retour.add("y = ("+ yavant+"² + "+b+")² + "+b+" = "+y);
			
			result = x-y;
			while(result<0)
			{
				result = result + n;
			}
			j++;
			xavant = x;
			yavant = y;
			retour.add("pgcd("+x+"-"+y+","+n+") = "+calc.pgcd(result, n));
		}while(calc.pgcd(result, n) == 1 && j<10);
 		
		retour.add("On trouve un pgcd != 1");
		
		if(j==10)
		{
			return retour;
		}
		else
		{
			this.p = calc.pgcd(result, n);
			this.q = n / this.p;
			retour.add("Donc on a p = "+this.p+" et q = "+n+"/"+this.p+" = "+this.q);
			return retour;
		}
	}
	
	public List<String> AttaqueDePollard3AvecSolution(int n , int x1)
	{
		List<String> retour = new ArrayList<>();
		List<Integer> nbpremiers = new ArrayList<>();
		List<Integer> divisepas = new ArrayList<>();
 		int result = 0;
		int i = 2;
		int p = 0;
		int q = 0;
		boolean divpas = false;
		
		retour.add("On a donc n = "+n+" et a1 = "+x1);
		retour.add("Il faut donc calculer xn = xn-1^n et décomposer le resultat-1 en nombres premiers. On test si les nombre premiers divise n et si c'est le cas alors p = nb premier qui divise et q = n / nb premier qui divise");
		while((p == 0 && q == 0) || i<10)
		{

			result = calc.calculC(x1, i, n);
			retour.add("a"+i+" = "+ x1 +"^"+i+" = "+result);
			
			while(result>n)
			{
				result = result - n;
			}
			nbpremiers = calc.decompositionennbpremiers(result-1);
			retour.add("On décompose "+(result-1)+" en nombre premiers, on a donc :");
			for(int z = 0; z<nbpremiers.size(); z++)
			{
				retour.add("Nombre premier "+(z+1)+" = "+nbpremiers.get(z));
			}
			for(int k = 0; k<nbpremiers.size(); k++)
			{
				for(int g = 0; g<divisepas.size() ; g++)
				{
					if(divisepas.get(g) == nbpremiers.get(k))
					{
						retour.add("On a déjà vu que "+nbpremiers.get(k)+" ne divise pas "+n);
						divpas = true;
					}
				}
				if(!divpas)
				{
					if(calc.pgcd(nbpremiers.get(k), n) != 1)
					{
						retour.add(nbpremiers.get(k) + " divise "+n+" donc p = "+nbpremiers.get(k)+" et q = " +n+" / "+nbpremiers.get(k)+" = "+ n/nbpremiers.get(k));
						p = nbpremiers.get(k);
						q = n/p;
						return retour;
					}
					else
					{
						divisepas.add(nbpremiers.get(k));
						retour.add(nbpremiers.get(k)+" ne divise pas "+n);
					}
				}
				divpas = false;
			}

		i++;
		x1 = result;
		}
		return retour;
	}
	
	public int getP()
	{
		return this.p;
	}
	
	public int getQ()
	{
		return this.q;
	}

}
