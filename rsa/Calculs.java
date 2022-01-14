package rsa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Calculs {
	
	public Calculs() {}
	
	public int pgcd (int a , int b) {
		int t;
		int r;
	    if ( b>a) {
	            t = a;
	            a = b;
	            b = t;
	     }
	    do {
	    		if(b == 0)
	    		{
	    			r = 0;
	    		}
	    		else {
	    			r = a % b;
	    		}
	            a = b;
	            b = r;
	    } while(r !=0);
	   return a ;
	  }
	
	public List<Integer> fractioncontinue(int e, int n)
	{
		int r;
		List<Integer> retour = new ArrayList<Integer>();
	    do {
	            r = e % n;
	            retour.add((int)e/n);
	            e = n;
	            n = r;
	    } while(r !=0);
	   return retour;
	}
	
	public int calculD (int e, int phin)
	{
		int phinn = phin;
		int reste;
		int nb;
		int temp;
		int[] x = new int[50];
		int[] y = new int[50];
		x[0]=1;
		x[1]=0;
		y[0]=0;
		y[1]=1;
		int i = 2;
		
		//Si phin > e on inverse pour avoir 280 = 5 * ... et pas 5 = 280 * ...
		if (phin>e) {
	            temp = e;
	            e = phin;
	            phin = temp;
	    }
		
		//On calcule l'inverse avec Euclide Etendu
		do
		{
			if(phin == 0)
			{
				reste = 0;
				y[i-2] = 0;
				nb=0;
			}
			else
			{
				reste=e%phin;
				nb=e/phin;
			}
			if(reste!=0)
			{
				x[i]=x[i-2]-(nb*x[i-1]);
				y[i]=y[i-2]-(nb*y[i-1]);
			}
			e=phin;
			phin=reste;
			i++;
		}while(reste!=0);
		
		//si l'inverse est négatif on ajoute phin pour le rendre positif
		if(y[i-2]<0)
		{
			y[i-2]=y[i-2]+phinn;
		}
		
		//on retourne y qui est d
		return y[i-2];
	}
	
	public int calculC(int M, int e, int n)
	{
		int[] puissance = new int[512];
		int j=0;
		int nb = 2;
		int[] Md = new int[512];
		
		//on decompose la puissance en puissance de 2
		while(e!=0)
		{
			int i = 1;
			while(Math.pow(2, i)<=e)
			{
				i++;
			}
			e=(int) (e-Math.pow(2, i-1));
			if(j < 512)
			{
				puissance[j] = (int) Math.pow(2, i-1);
			}
			else
			{
				return 0;
			}
			j++;
		}
		
		//On calcule tout les puissances de M jusqu'à la puissance maximale trouvée avant
		Md[1] = M;
		while(nb<=puissance[0])
		{
			Md[nb] =Md[nb-(nb/2)]*Md[nb-(nb/2)];
			while(Md[nb]>n)
			{
				Md[nb] = Md[nb] - n;
			}
			nb = nb * 2;
		}
		
		//On additionne toutes les puissances
		int result = 1;
		for(int i : puissance)
		{
			if(i != 0)
			{
				result = result * Md[i];
				while(result>n)
				{
					result = result - n;
				}
			}
		}
		return result;
	}
	
	public int calculExpoDicho(int M, int e, int n)
	{
		int[] puissance = new int[512];
		int j=0;
		int nb = 2;
		int[] Md = new int[512];
		int nbint = 0;
		//on decompose la puissance en puissance de 2
		while(e!=0)
		{
			int i = 1;
			while(Math.pow(2, i)<=e)
			{
				i++;
			}
			e=(int) (e-Math.pow(2, i-1));
			puissance[j] = (int) Math.pow(2, i-1);
			nbint++;
			j++;
		}
		
		//On calcule tout les puissances de M jusqu'à la puissance maximale trouvée avant
		Md[1] = M;
		while(nb<=puissance[0])
		{
			Md[nb] =Md[nb-(nb/2)]*Md[nb-(nb/2)];
			while(Md[nb]>n)
			{
				Md[nb] = Md[nb] - n;
			}
			nb = nb * 2;
		}
		
		//On additionne toutes les puissances
		int result = 1;
		for(int i : puissance)
		{
			if(i != 0)
			{
				result = result * Md[i];
				while(result>n)
				{
					result = result - n;
				}
			}
		}
		return nbint;
	}
	
	static ArrayList<String> calculDavecSolution (int e, int phin)
	{
		ArrayList<String> retour = new ArrayList<>();
		int phinn = phin;
		int reste;
		int nb;
		int temp;
		int[] x = new int[50];
		int[] y = new int[50];
		x[0]=1;
		x[1]=0;
		y[0]=0;
		y[1]=1;
		int i = 2;
		
		retour.add("Pour calculer d (inverse de e) il faut que le pgcd(e,m) = 1 et trouver u par la remonté (u = d)");
		//Si phin > e on inverse pour avoir 280 = 5 * ... et pas 5 = 280 * ...
		if (phin>e) {
	            temp = e;
	            e = phin;
	            phin = temp;
	    }
		
		retour.add("On fait euclide pour trouver u:");
		retour.add("Pour trouver u je fait pas comme le prof, comme je me trompe souvent dans la remonté avec la technique du prof, j'en utilise une autre ou on fait la descente et la remonté en même temps et qui permet de ne pas ce tromper");
		retour.add("Pour calculer u on fait donc : x[i]=x[i-2]-(nb*x[i-1])");
		retour.add("On prend x[0] = 0 et x[1] = 1 et dans l'exemple : 52=8*6+4 , nb est 8");

		//On calcule l'inverse avec Euclide Etendu
		do
		{
			reste=e%phin;
			nb=e/phin;
			if(reste!=0)
			{
				x[i]=x[i-2]-(nb*x[i-1]);
				y[i]=y[i-2]-(nb*y[i-1]);
			}
			retour.add(e+"="+nb+"*"+phin+"+"+reste+" donc x["+i+"]=x["+(i-2)+"]-("+nb+"*x["+(i-1)+"]) = "+y[i-2]+"-("+nb+"*"+y[i-1] + ") = "+y[i]);
			e=phin;
			phin=reste;
			i++;
		}while(reste!=0);
		
		retour.add("On prend le x[i] de quand on trouve le pgcd = 1 donc u = "+y[i-2]);
		//si l'inverse est négatif on ajoute phin pour le rendre positif
		if(y[i-2]<0)
		{
			retour.add("Si u est négatif on ajoute m pour le rendre positif");
			int yavant = y[i-2];
			y[i-2]=y[i-2]+phinn;
			retour.add("Donc u = "+yavant+"+"+phinn+"="+y[i-2]);
		}
		
		//on retourne y qui est d
		return retour;
	}
	
	public ArrayList<String> calculCavecSolution(int M, int e, int n)
	{
		ArrayList<String> retour = new ArrayList<>();
		int[] puissance = new int[512];
		int j=0;
		int nb = 2;
		int[] Md = new int[260];
		
		retour.add("Je décompose "+e+" en puissance de 2");
		int eavant = e;
		//on decompose la puissance en puissance de 2
		while(e!=0)
		{
			int i = 1;
			while(Math.pow(2, i)<=e)
			{
				i++;
			}
			e=(int) (e-Math.pow(2, i-1));
			puissance[j] = (int) Math.pow(2, i-1);
			j++;
		}
		
		String retourne = "";
		for(int o : puissance)
		{
			if(o != 0)
			{
				retourne += o+" * ";
			}
		}
		
		if(retourne.length() > 2)
		{
			retourne = retourne.substring(0, retourne.length() - 2);
		}
		retour.add("Donc on a "+eavant+" = " + retourne);
		retour.add("On calcule maintenant toutes les puissances de C");
		//On calcule tout les puissances de M jusqu'à la puissance maximale trouvée avant
		Md[1] = M;
		while(nb<=puissance[0])
		{
			Md[nb] =Md[nb-(nb/2)]*Md[nb-(nb/2)];
			while(Md[nb]>n)
			{
				Md[nb] = Md[nb] - n;
			}
			retour.add(M+"^"+nb+" = "+String.valueOf(Md[nb]));
			nb = nb * 2;
		}
		
		retour.add("Enfin on additionne le tout");
		//On additionne toutes les puissances
		String retourne2 = "";
		String retourne3 = "";
		int result = 1;
		for(int i : puissance)
		{
			if(i != 0)
			{
				result = result * Md[i];
				while(result>n)
				{
					result = result - n;
				}
				retourne3+= M+"^"+i + " * ";
				retourne2+=String.valueOf(Md[i])+" * ";
			}
		}
		if(retourne3.length() > 2)
		{
			retourne3 = retourne3.substring(0, retourne3.length() - 2);
		}
		if(retourne2.length() > 2)
		{
			retourne2 = retourne2.substring(0, retourne2.length() - 2);
		}
		retour.add("On a donc :" + retourne3 + " = " + retourne2 + " = " + result + " dans F"+n);
		return retour;
	}	
	
	public ArrayList<String> calculExpoDichoAvecSolution(int M, int e, int n)
	{
		ArrayList<String> retour = new ArrayList<>();
		int[] puissance = new int[260];
		int j=0;
		int nb = 2;
		int[] Md = new int[260];
		
		retour.add("On cherche à calculer : "+M+"^"+e+" modulo "+n);
		retour.add("On décompose "+e+" en puissance de 2");
		int eavant = e;
		//on decompose la puissance en puissance de 2
		while(e!=0)
		{
			int i = 1;
			while(Math.pow(2, i)<=e)
			{
				i++;
			}
			e=(int) (e-Math.pow(2, i-1));
			puissance[j] = (int) Math.pow(2, i-1);
			j++;
		}
		
		String retourne = "";
		for(int o : puissance)
		{
			if(o != 0)
			{
				retourne += o+" + ";
			}
		}
		retourne = retourne.substring(0,retourne.length()-2);
		
		retour.add("Donc on a "+eavant+" = " + retourne);
		retour.add("On calcule maintenant toutes les puissances de "+M);
		//On calcule tout les puissances de M jusqu'à la puissance maximale trouvée avant
		Md[1] = M;
		while(nb<=puissance[0])
		{
			Md[nb] =Md[nb-(nb/2)]*Md[nb-(nb/2)];
			while(Md[nb]>n)
			{
				Md[nb] = Md[nb] - n;
			}
			retour.add(M+"^"+nb+" = "+String.valueOf(Md[nb])+" modulo "+n);
			nb = nb * 2;
		}
		
		retour.add("Enfin on multiplie les puissances qui nous interesse");
		//On additionne toutes les puissances
		String retourne2 = "";
		int result = 1;
		for(int i : puissance)
		{
			if(i != 0)
			{
				result = result * Md[i];
				while(result>n)
				{
					result = result - n;
				}
				retourne2+=String.valueOf(Md[i])+" * ";
			}
		}
		retourne2 = retourne2.substring(0,retourne2.length()-2);
		
		retour.add("On a donc :" + retourne2 + " = " + result);
		retour.add("Donc "+M+"^"+eavant+" = "+result+" modulo "+n);
		return retour;
	}	
	
	public ArrayList<String> calculMavecSolution(int M, int e, int n)
	{
		ArrayList<String> retour = new ArrayList<>();
		int[] puissance = new int[260];
		int j=0;
		int nb = 2;
		int[] Md = new int[260];
		
		retour.add("Pour calculer M on a la formule M = C^d mod n");
		retour.add("Ici on a M = "+M+" ,d = "+e+" et n ="+n);
		retour.add("Je vais faire grâce aux puissances donc je décompose d en puissance de 2");
		int eavant = e;
		//on decompose la puissance en puissance de 2
		while(e!=0)
		{
			int i = 1;
			while(Math.pow(2, i)<e)
			{
				i++;
			}
			e=(int) (e-Math.pow(2, i-1));
			puissance[j] = (int) Math.pow(2, i-1);
			j++;
		}
		
		String retourne = "";
		for(int o : puissance)
		{
			if(o != 0)
			{
				retourne += " * e^"+o;
			}
		}
		
		retour.add("Donc on a "+eavant+" = " + retourne);
		retour.add("On calcule maintenant toutes les puissances de M");
		//On calcule tout les puissances de M jusqu'à la puissance maximale trouvée avant
		Md[1] = M;
		while(nb<=puissance[0])
		{
			Md[nb] =Md[nb-(nb/2)]*Md[nb-(nb/2)];
			while(Md[nb]>n)
			{
				Md[nb] = Md[nb] - n;
			}
			retour.add("d^"+nb+" = "+String.valueOf(Md[nb]));
			nb = nb * 2;
		}
		
		retour.add("Enfin on additionne le tout");
		//On additionne toutes les puissances
		String retourne2 = "";
		int result = 1;
		for(int i : puissance)
		{
			if(i != 0)
			{
				result = result * Md[i];
				while(result>n)
				{
					result = result - n;
				}
				retourne2+=String.valueOf(Md[i])+" * ";
			}
		}
		retour.add("On a donc :" + retourne2 + " = " + result);
		return retour;
	}	
	
	public List<Integer> decompositionennbpremiers(int x)
	{
		nbpremiers nb = new nbpremiers();
		List<Integer> premier = new ArrayList<>();
		int x2 = x;
		
		for(int i = 2; i<x; i++)
		{
			if(x2%i == 0 && nb.estPremier(i))
			{
				x2 = x2/i;
				premier.add(i);
			}
		}
		
		return premier;
	}
	
	public int ordre(int type, int M , int n)
	{
		List<Integer> ordrePos = ordrePossible(n-1);
		int nbint = 0;
		for(Integer i : ordrePos)
		{
			nbint++;
			if(calculC(M, i, n) == 1)
			{
				if(type==0)
				{
					return i;
				}
				return nbint;
			}
		}
		return 0;
	}
	
	public List<Integer> ordrePossible(int n)
	{
		List<Integer> ordrePos = new ArrayList<>();
		for(int i = 1; i<=n/2 ; i++)
		{
			if(n % i == 0)
			{
				ordrePos.add(i);
			}
		}
		ordrePos.add(n);
		return ordrePos;
	}
	
	public List<String> ordreAvecSolution(int M, int n)
	{
		List<String> retour = new ArrayList<>();
		retour.add("On cherche à calculer l'ordre de "+M+" dans F"+n);
		retour.add("On commence à chercher tous les ordres possibles qui sont des diviseurs de p-1");
		List<Integer> ordrePos = ordrePossible(n-1);
		String ordre = "";
		for(Integer i : ordrePos)
		{
			ordre += i +" , ";
		}
		ordre = ordre.substring(0,ordre.length()-2);
		retour.add("Les ordres possibles sont : "+ordre);
		
		retour.add("Ensuite on calcule "+M+" puissance tous les ordres possibles jusqu'a trouver 1");
		
		int ordrenb = 0;
		for(Integer i : ordrePos)
		{
			if(ordrenb == 0)
			{
				retour.add(M+"^"+i+" = "+calculC(M, i, n)+" modulo "+n);
				if(calculC(M,i,n) == 1)
				{
					ordrenb = i;
				}
			}
		}
		retour.add("On trouve 1 quand on a "+M+"^"+ordrenb+", donc ordre ="+ordrenb);
		return retour;
	}

	public HashMap<Integer,Integer> logarithmeDiscret(int p,int n)
	{
		HashMap<Integer, Integer> log = new HashMap<>();
		for(int i = 1;i<p;i++)
		{
			log.put(calculC(n,i, p),i);
		}
		return log;
	}
	
	public List<String> logarithmeDiscretAvecCorrection(int p,int n)
	{
		List<String> retour = new ArrayList<>();
		HashMap<Integer, Integer> log = new HashMap<>();
		
		retour.add("On veut calculer les logarithmes discrets de "+p+" en base "+n);
		retour.add("On creer donc un premier tableau avec toutes les valeurs de i et leurs valeurs de "+n+" ^i correspondant :");
		for(int i = 1;i<p;i++)
		{
			retour.add(i+" : "+calculC(n, i, p));
			log.put(calculC(n, i, p),i);
		}
		
		retour.add("On fait ensuite un 2ème tableau avec les valeurs de x et leurs logarithme correspondant");
		retour.add("Pour trouver le logarithme on va prendre la valeur correspondante dans le premier tableau");
		retour.add("Par exemple si on cherche le logarithme discret de 4 , on recherche 4 dans les valeur de "+n+"^i du premier tableau et on prend le i");
		retour.add("Ca donne :");
		for(int i = 1;i<p;i++)
		{
			retour.add(i+" : "+log.get(i));
		}
		
		return retour;
	}
	
	public List<Integer> racinePrimitiveAll(int p)
	{
		List<Integer> rac = new ArrayList<>();
		for(int i = 0; i<p ;i++)
		{
			if(ordre(0,i,p) == p-1)
			{
				rac.add(i);
			}
		}

		return rac;
	}
	
	public List<String> racinePrimitiveAllAvecCorrection(int p)
	{
		List<String> retour = new ArrayList<>();
		retour.add("On cherche toutes les racines primitives dans F"+p);
		retour.add("Pour cela il faut calculer l'ordre de tous les nombres <"+p);
		retour.add("Si un nombre à pour ordre "+p+"-1 donc "+(p-1)+" alors il sera une racine primitive");
		List<Integer> rac = new ArrayList<>();
		for(int i = 2; i<p ;i++)
		{
			retour.add("Ordre de "+i+" dans F"+p+" = "+ordre(0,i,p));
			if(ordre(0,i,p) == p-1)
			{
				retour.add("L'ordre est égal à "+(p-1)+" donc "+i+" est une racine primitive");
				rac.add(i);
			}
		}

		String racineprimitive = "";
		for(Integer i : rac)
		{
			racineprimitive += i+" , ";
		}
		racineprimitive = racineprimitive.substring(0,racineprimitive.length()-2);
		retour.add("Les racines primitives sont donc : "+racineprimitive);
		return retour;
	}
	
	public List<String> diffiehellman(int alpha, int p, int n, int c2)
	{
		List<String> retour = new ArrayList<>();
		retour.add("On commence par calculer le message que l'on envoie à bob");
		retour.add("Il est égal à g^a mod p = "+alpha+"^"+p+" mod "+n);
		int mes = calculC(alpha,p,n);
		retour.add("On envoie donc : "+mes);
		retour.add("On recoit "+c2);
		retour.add("Notre secret commun est donc Messagerecu^a mod p = "+c2+"^"+p+" mod "+n);
		int secret = calculC(c2,p,n);
		retour.add("Le secret est donc : "+secret);
		return retour;
	}
	
	public int racinePrimitive(int p)
	{
		List<Integer> rac = new ArrayList<>();
		for(int i = 0; i<p ;i++)
		{
			if(ordre(0,i,p) == p-1)
			{
				rac.add(i);
			}
		}
		if(rac.size() != 0)
		{
			int rand = (int) (Math.random() * ( rac.size() ));
			return rac.get(rand);
		}
		return 0;
	}

}
