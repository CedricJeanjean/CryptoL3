package rsa;

import java.util.List;
import java.util.ArrayList;

public class AttaqueDeWeger {
	
	private int p;
	private int q;
	
	public AttaqueDeWeger(int p, int q)
	{
		this.p = p;
		this.q = q;
	}
	
	public boolean AttaqueDeWegerResult(int n, int m)
	{
		int form = m-n-1;
		int delta = (int) (Math.pow(form, 2) - 4*n);
		int p = (int)(-form+Math.sqrt(delta))/2;
		int q = (int)(-form-Math.sqrt(delta))/2;
		
		if((p == this.p && q == this.q) || (q == this.p && p == this.q))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public List<String> AttaqueDeWegeravecSolution(int n, int m)
	{
		List<String> retour = new ArrayList<>();
		retour.add("Pour calculer Weger on calcule la formule m-n-1");
		int form = m-n-1;
		retour.add("Ensuite on fait delta : a²-(4*n). Ici a = m-n-1");
		int delta = (int) (Math.pow(form, 2) - 4*n);
		retour.add("On a donc : "+form+"²"+"-4*"+n+" = "+delta);
		int p = (int)(-form+Math.sqrt(delta))/2;
		int q = (int)(-form-Math.sqrt(delta))/2;
		retour.add("Ensuite on calcule p et q avec -a+rac(delta)/2 et -a-rac(delta)/2");
		retour.add("Donc p = -"+form+"+rac("+delta+")/2 = "+p);
		retour.add("Et q = -"+form+"-rac("+delta+")/2 = "+q);
		retour.add("Noté que p et q sont interchangeable");
		
		return retour;
	}

}
