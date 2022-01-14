package rsa;

public class nbpremiers {
	
	int[] premiers = {};
	
	public nbpremiers() {}
	
	public int getnbpremier()
	{
		int reste;
		boolean flag = true;
		int nbr = (int) (Math.random() * ( 200 - 1 ));
	       
		for(int i=2; i <= nbr/2; i++)
		{
		   //nombre est divisible par lui-meme
		   reste = nbr%i;
		            
		   //si le reste est 0, alors arrete la boucle. Sinon continuer la boucle
		   if(reste == 0)
		   {
			   flag = false;
			   break;
		   }
		}
		//si flag est true, alors nombre est premier, sinon non premier
		if(flag)
		{
		   return nbr;
		}
		else
		{
		   return getnbpremier();
		}
	}
	
	public boolean estPremier(int nb)
	{
		int reste;
		boolean flag = true;
	       
		for(int i=2; i <= nb/2; i++)
		{
		   //nombre est divisible par lui-meme
		   reste = nb%i;
		            
		   //si le reste est 0, alors arrete la boucle. Sinon continuer la boucle
		   if(reste == 0)
		   {
			   flag = false;
			   break;
		   }
		}
		//si flag est true, alors nombre est premier, sinon non premier
		if(flag)
		{
		   return true;
		}
		else
		{
		   return false;
		}
	}

}
