package rsa;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Rsa{
	
	private int p = 0;
	private int q;
	private int n;
	private int phin;
	private int e;
	private int resultpgcd;
	private int d;
	private int c;
	private int c2;
	private int M = 0;
	private int deM[] = new int[50];
	private int nbC = 0;
	private int question2 = 0;
	private Calculs calc;
	private int nb = 0;
	private int a = 0;
	private int b = 0;
	private int s;
	private int alpha;
	private int k = 0;
	private int P;
	private int nombre;
	private boolean calcP;
	private int nmax;
	private boolean etrepremier = false;
	
	private JFrame f;
	private VueRsa vue1;

	public Rsa()
	{	
		f = new JFrame("Rsa");
		f.setLayout(new GridLayout(1,1));
		vue1 = new VueRsa(9, this);
		f.add(vue1);
		f.pack();
		f.setVisible(true);
		f.setSize(1000,600);
		
		f.addWindowListener(new java.awt.event.WindowAdapter() {
		    @Override
		    public void windowClosing(java.awt.event.WindowEvent windowEvent) {
		        System.exit(0);
		    }
		});

		this.calc = new Calculs();
	}
	
	public void quit()
	{
		f.dispose();
	}
	
	public void exercices(int question)
	{
		if(question == 1)
		{
			nbpremiers nb = new nbpremiers();
			this.p = nb.getnbpremier();
			this.q = nb.getnbpremier();
			this.n = p*q;
			this.phin = (p-1)*(q-1); // ou m
			setVue(10);
		}
		else if(question == 2)
		{
			do
			{
				this.e = (int) (Math.random() * ( 100 - 1 ));
				this.resultpgcd = calc.pgcd(this.e,this.phin);
				
				while(this.resultpgcd!=1 && this.e < this.phin)
				{
					this.e = (int) (Math.random() * ( 200 - 1 ));
					this.resultpgcd = calc.pgcd(this.e,this.phin);
				}
			}
			while(calc.calculD(this.e, this.phin) == 0);
			
			this.d = calc.calculD(this.e, this.phin);

			setVue(18);
		}
		else if(question == 3)
		{
			nbpremiers nb = new nbpremiers();
			this.p = nb.getnbpremier();
			this.q = nb.getnbpremier();
			this.n = p*q;
			this.phin = (p-1)*(q-1); // ou m
			
			do
			{
				this.e = (int) (Math.random() * ( 100 - 1 ));
				this.resultpgcd = calc.pgcd(this.e,this.phin);
				
				while(this.resultpgcd!=1 && this.e < this.phin)
				{
					this.e = (int) (Math.random() * ( 200 - 1 ));
					this.resultpgcd = calc.pgcd(this.e,this.phin);
				}
			}
			while(calc.calculD(this.e, this.phin) == 0);
			
			this.d = calc.calculD(this.e, this.phin);
			this.M = (int) (Math.random() * ( 500 - 1 ));
			this.c = calc.calculC(this.M, this.e, this.n);
			
			setVue(22);
		}
		else if(question == 4)
		{
			nbpremiers nb = new nbpremiers();
			this.p = nb.getnbpremier();
			this.q = nb.getnbpremier();
			this.n = p*q;
			this.phin = (p-1)*(q-1); // ou m
			
			do
			{
				this.e = (int) (Math.random() * ( 100 - 1 ));
				this.resultpgcd = calc.pgcd(this.e,this.phin);
				
				while(this.resultpgcd!=1 && this.e < this.phin)
				{
					this.e = (int) (Math.random() * ( 200 - 1 ));
					this.resultpgcd = calc.pgcd(this.e,this.phin);
				}
			}
			while(calc.calculD(this.e, this.phin) == 0 || calc.calculD(this.e, this.phin) > 200);
			
			this.d = calc.calculD(this.e, this.phin);
			this.c = (int) (Math.random() * ( 500 - 1 ));
			this.M = calc.calculC(this.c, this.d, this.n);
			
			setVue(26);
		}
		else if(question == 5)
		{
			nbpremiers nb = new nbpremiers();
			this.p = nb.getnbpremier();
			this.q = nb.getnbpremier();
			this.n = p*q;
			this.phin = (p-1)*(q-1); // ou m
			
			do
			{
				this.e = (int) (Math.random() * ( 100 - 1 ));
				this.resultpgcd = calc.pgcd(this.e,this.phin);
				
				while(this.resultpgcd!=1 && this.e < this.phin)
				{
					this.e = (int) (Math.random() * ( 200 - 1 ));
					this.resultpgcd = calc.pgcd(this.e,this.phin);
				}
			}
			while(calc.calculD(this.e, this.phin) == 0 || calc.calculD(this.e, this.phin) > 200);
			
			this.c = (int) (Math.random() * ( 500 - 1 ));
			this.M = (int) (Math.random() * ( 500 - 1 ));
			this.d = calc.calculD(this.e, this.phin);
			
			setVue(30);
		}
		else if(question == 6)
		{
			AttaqueDeWeger wg;
			do {
			nbpremiers nb = new nbpremiers();
			this.p = nb.getnbpremier();
			this.q = nb.getnbpremier();
			this.n = p*q;
			this.phin = (p-1)*(q-1); // ou m
			
			do
			{
				this.e = (int) (Math.random() * ( 100 - 1 ));
				this.resultpgcd = calc.pgcd(this.e,this.phin);
				
				while(this.resultpgcd!=1 && this.e < this.phin)
				{
					this.e = (int) (Math.random() * ( 200 - 1 ));
					this.resultpgcd = calc.pgcd(this.e,this.phin);
				}
			}
			while(calc.calculD(this.e, this.phin) == 0 || calc.calculD(this.e, this.phin) > 200);
			this.M = (int) (Math.random() * ( 200 - 1 ));
			while(this.M == 0 || this.M == 1)
			{
				this.M = (int) (Math.random() * ( 200 - 1 ));
			}
			wg = new AttaqueDeWeger(p,q);
			}while(wg.AttaqueDeWegerResult(n, M) == false);
			setVue(37);
		}
		else if(question == 7)
		{
			AttaqueDeSimonsEtNoris asn;
			int i = 0;
			do {
			nbpremiers nb = new nbpremiers();
			this.p = nb.getnbpremier();
			this.q = nb.getnbpremier();
			this.n = p*q;
			this.phin = (p-1)*(q-1); // ou m
			i = 0;
			do
			{
				this.e = (int) (Math.random() * ( 500 - 1 ));
				this.resultpgcd = calc.pgcd(this.e,this.phin);
				
				while(this.resultpgcd!=1 && this.e < this.phin)
				{
					this.e = (int) (Math.random() * ( 500 - 1 ));
					this.resultpgcd = calc.pgcd(this.e,this.phin);
				}
				i++;
			}
			while((calc.calculD(this.e, this.phin) == 0 || calc.calculD(this.e, this.phin) > 500 || this.e == 1) && i != 500);

			this.c = (int) (Math.random() * ( 200 - 1 ));
			asn = new AttaqueDeSimonsEtNoris();
			}while(asn.AttaqueDeSimonsEtNorisResult(this.c, this.e, this.n) == 0 || i == 500);
			this.M = asn.AttaqueDeSimonsEtNorisResult(this.c, this.e, this.n);
			setVue(42);
		}
		else if(question == 8)
		{
			AttaqueDePollard p = new AttaqueDePollard();

			do {
				nbpremiers nb = new nbpremiers();
				this.p = nb.getnbpremier();
				this.q = nb.getnbpremier();
				this.n = this.p*this.q;
				while(this.a == 1 || this.a == 0)
				{
					this.a = (int) (Math.random() * ( 10 - 1 ));
				}
			}while(!p.AttaqueDePollard3Result(n, this.a));

			setVue(46);
		}
		else if(question == 9)
		{
			AttaqueDePollard p = new AttaqueDePollard();
			
			do {
				nbpremiers nb = new nbpremiers();
				this.p = nb.getnbpremier();
				this.q = nb.getnbpremier();
				this.n = this.p*this.q;
				while(this.a == 1 || this.a == 0)
				{
					this.a = (int) (Math.random() * ( 100 - 1 ));
				}
				this.b = (int) (Math.random() * ( 1000 - 1 ));
			}while(!p.AttaqueDePollard2Result(n, b,this.a));

			setVue(50);
		}
		else if(question == 10)
		{
			AttaqueDeElGamal at = new AttaqueDeElGamal();
			
			do {
			nbpremiers nb = new nbpremiers();
			this.p = nb.getnbpremier();
			this.s = (int) (Math.random() * ( 200 - 1 ));
			this.alpha = (int) (Math.random() * ( 200 - 1 ));

			this.c = (int) (Math.random() * ( 200 - 1 ));
			this.c2 = (int) (Math.random() * ( 200 - 1 ));
			
			/*
			this.p = 19;
			this.s = 7;
			this.alpha = 2;
					
			this.c = 13;
			this.c2 = 15;
			*/
			
			this.M = at.AttaqueDeElGamalcalcul(p, s, alpha, c, c2);
			}while(this.M == 0);

			setVue(53);
		}
		else if(question == 11)
		{
			AttaqueDeElGamal at = new AttaqueDeElGamal();
			
			nbpremiers nb = new nbpremiers();
			this.p = nb.getnbpremier();
			this.s = (int) (Math.random() * ( 200 - 1 ));
			this.alpha = (int) (Math.random() * ( 200 - 1 ));

			while(this.k == 0 || this.k == 1)
			{
				this.k = (int) (Math.random() * ( 50 - 1 ));
			}
			this.M = (int) (Math.random() * ( 200 - 1 ));
			
			/*
			//Alice
			this.M = 11; //x
			this.k = 5; // r
			
			//Bob
			this.s = 7; // k
			this.alpha = 2; //g
			this.p = 19; 
			*/
			this.calcP = true;
			
			int retour[] = at.coderM(p,s,alpha,M,k,calcP);
			this.c = retour[0];
			this.c2 = retour[1];

			setVue(57);
		}
		else if(question == 12)
		{
			AttaqueDeElGamal at = new AttaqueDeElGamal();
			
			nbpremiers nb = new nbpremiers();
			
			this.p = nb.getnbpremier();
			this.s = (int) (Math.random() * ( 200 - 1 ));
			this.alpha = (int) (Math.random() * ( 200 - 1 ));
			this.P = calc.calculC(alpha, s, p);
			while(this.k == 0)
			{
				this.k = (int) (Math.random() * ( 50 - 1 ));
			}
			this.M = (int) (Math.random() * ( 200 - 1 ));
			
			int retour[] = at.coderM(p,s,alpha,M,k, true);
			this.c = retour[0];
			this.c2 = retour[1];
			
			this.M = at.AttaqueDeElGamalLaVrai(p, alpha, P, c, c2);

			setVue(61);
		}
		else if(question == 13)
		{
			TestDePrimalite test = new TestDePrimalite();
			do {
			this.nombre = (int) (Math.random() * ( 200 - 1 ));
			this.nmax = (int) (Math.random() * ( 200 - 1 ));
			}while(!test.premier(nombre, nmax));
			setVue(65);
		}
		else if(question == 14)
		{
			int nbint = 0;
			do {
				this.p = (int) (Math.random() * ( 200 - 1 ));
				this.q = (int) (Math.random() * ( 200 - 1 ));
				this.n = (int) (Math.random() * ( 200 - 1 ));
				nbint = calc.calculExpoDicho(this.p,this.q,this.n);
			}while(nbint>7 || nbint < 2);
			setVue(69);
		}
		else if(question == 15)
		{
			int nbint = 0;
			do {
				this.p = (int) (Math.random() * ( 200 - 1 ));
				this.n = (int) (Math.random() * ( 200 - 1 ))+60;
				nbint = calc.ordre(1, this.p, this.n);
			}while(nbint > 8 || nbint < 3);
			setVue(73);
		}
		else if(question == 16)
		{
			do {
			this.p = (int) (Math.random() * (11 - 1))+4;
			this.n = calc.racinePrimitive(this.p);
			}while(this.n == 0);

			setVue(77);
		}
		else if(question == 17)
		{
			do {
				this.p = (int) (Math.random() * (20 - 1))+2;
			}while(calc.racinePrimitiveAll(this.p).size() > 8 || calc.racinePrimitiveAll(this.p).size() < 2);
			setVue(81);
		}
		else if(question == 18)
		{
			AttaqueDeElGamal at = new AttaqueDeElGamal();
			
			nbpremiers nb = new nbpremiers();
			
			do {
				this.p = (int) (Math.random() * (11 - 1))+4;
				this.alpha = calc.racinePrimitive(this.p);
			}while(this.alpha >= this.p || this.alpha == 0);
			this.P = calc.calculC(alpha, s, p);
			
			do {
				this.s = (int) (Math.random() * ( 200 - 1 ));
				this.k = calc.calculC(alpha, s, p);
			} while (this.k > this.p || this.s+2 > this.p);
			

			this.c = (int) (Math.random() * ( 200 - 1 ));
			this.c2 = (int) (Math.random() * ( 200 - 1 ));
				
			this.M = at.AttaqueDeElGamalcalcul(p,s,alpha,c,c2);

			/*
			this.c = 16;
			this.c2 = 6;
			this.p = 47;
			this.alpha = 45;
			this.s = 7;
			*/
			
			setVue(84);
		}
		else if(question == 19)
		{
			this.alpha = (int) (Math.random() * (200 - 1))+4;
			this.p = (int) (Math.random() * (200 - 1))+4;
			this.n = (int) (Math.random() * (200 - 1))+4;
			
			this.c = (int) (Math.random() * (200 - 1))+4;

			this.c2 =  calc.calculC(alpha, c, n);
			
			this.s = calc.calculC(alpha, p, n);
			
			this.b = calc.calculC(c2, p, n);
			
			setVue(87);
		}
	}
	
	public void resultatLoga(List<TextField> text)
	{
		HashMap<Integer,Integer> result = calc.logarithmeDiscret(this.p,this.n);
		int i = 0;
		int mauvais = 0;
		int zero = 0;
		boolean stop = false;
		for(TextField t : text)
		{
			try {
			if(Integer.valueOf(t.getText()) != result.get(i+1))
			{
				if(Integer.valueOf(t.getText()) == 0)
				{
					zero++;
				}
				else
				{
					mauvais++;
				}
			}
			}catch(Exception ex)
			{
				setVue(77);
				stop = true;
			}
			i++;
		}
		
		if(!stop)
		{
			if(zero == text.size())
			{
				setVue(78);
			}
			else if(mauvais != 0)
			{
				setVue(80);
			}
			else
			{
				setVue(79);
			}
		}
	}
	
	public void resultatRacPrim(List<TextField> text)
	{
		List<Integer> result = calc.racinePrimitiveAll(this.p);
		int mauvais = 0;
		int zero = 0;
		boolean stop = false;
		for(TextField t : text)
		{
			boolean bon = false;
			for(int i = 0; i<result.size();i++)
			{	
				try {
					if(Integer.valueOf(t.getText()) == result.get(i))
					{
						bon = true;
						result.remove(i);
					}
				}catch(Exception ex)
				{
					setVue(81);
					stop = true;
				}
			}
			
			try {
				if(Integer.valueOf(t.getText()) == 0)
				{
					zero++;
				}
			}catch(Exception ex)
			{
				stop = true;
			}
		}
		
		if(!stop)
		{
			if(result.size() == 0)
			{
				setVue(79);
			}
			else if(zero == result.size())
			{
				setVue(83);
			}
			else
			{
				setVue(82);
			}
		}
	}
	
	public void resultatDiffieHellman(int[] result)
	{
		if(result[0] == 0 && result[1] == 0)
		{
			setVue(89);
		}
		else if(result[0] == this.s && result[1] == this.b)
		{
			setVue(79);
		}
		else
		{
			setVue(88);
		}
	}
	
	public void resultatLeihmer(int result)
	{
		if(result == 0)
		{
			setVue(68);
		}
		else if((result == 1 && etrepremier) || (result == 0 && !etrepremier))
		{
			setVue(66);
		}
		else
		{
			setVue(67);
		}
	}
	
	public void resultatExpo(int result)
	{
		if(result == 0)
		{
			setVue(70);
		}
		else if((result == calc.calculC(this.p,this.q,this.n)))
		{
			setVue(71);
		}
		else
		{
			setVue(72);
		}
	}
	
	public void resultatOrdre(int result)
	{
		if(result == 0)
		{
			setVue(74);
		}
		else if((result == calc.ordre(0,this.p,this.n)))
		{
			setVue(75);
		}
		else
		{
			setVue(76);
		}
	}
	
	public void resultatWeger(int[] result)
	{
		if(result[0] == 0 && result[1] == 0)
		{
			setVue(40);
		}
		else if((result[0] == this.p || result[0] == this.q) && (result[1] == this.p || result[1] == this.q))
		{
			setVue(38);
		}
		else
		{
			setVue(39);
		}
	}
	
	public void resultatPollard(int[] result)
	{
		if(result[0] == 0 && result[1] == 0)
		{
			setVue(49);
		}
		else if((result[0] == this.p || result[0] == this.q) && (result[1] == this.p || result[1] == this.q))
		{
			setVue(47);
		}
		else
		{
			setVue(48);
		}
	}
	
	public void resultatPollard2(int[] result)
	{
		if(result[0] == 0 && result[1] == 0)
		{
			setVue(52);
		}
		else if((result[0] == this.p || result[0] == this.q) && (result[1] == this.p || result[1] == this.q))
		{
			setVue(47);
		}
		else
		{
			setVue(51);
		}
	}
	
	public void resultatSimmons(int result)
	{
		if(result == 0)
		{
			setVue(45);
		}
		else if(result == this.M)
		{
			setVue(43);
		}
		else
		{
			setVue(44);
		}
	}
	
	public void resultatAttaqueElGamal(int result)
	{
		if(result == 0)
		{
			setVue(64);
		}
		else if(result == this.M)
		{
			setVue(62);
		}
		else
		{
			setVue(63);
		}
	}
	
	public void resultatElGamalAttaque(int result)
	{
		if(result == 0)
		{
			setVue(86);
		}
		else if(result == this.M)
		{
			setVue(79);
		}
		else
		{
			setVue(85);
		}
	}
	
	public void resultatElGamal(int result)
	{
		if(result == 0)
		{
			setVue(55);
		}
		else if(result == this.M)
		{
			setVue(79);
		}
		else
		{
			setVue(54);
		}
	}
	
	public void resultatElGamalM(int[] result)
	{
		if(result[0] == 0 && result[1] == 0)
		{
			setVue(60);
		}
		else if(result[0] == this.c && result[1] == this.c2)
		{
			setVue(71);
		}
		else
		{
			setVue(59);
		}
	}
	
	public void resultatd(int result)
	{
		if(result == 0)
		{
			setVue(21);
		}
		else if(result != this.d)
		{
			setVue(19);
		}
		else
		{
			setVue(20);
		}
	}
	
	public void resultatdavecC(int result)
	{
		if(result == 0)
		{
			setVue(36);
		}
		else if(result != this.d)
		{
			setVue(34);
		}
		else
		{
			setVue(35);
		}
	}
	
	public void resultatC(int result)
	{
		if(result == 0)
		{
			setVue(25);
		}
		else if(result != this.c)
		{
			setVue(23);
		}
		else
		{
			setVue(24);
		}
	}
	
	public void resultatM(int result)
	{
		if(result == 0)
		{
			setVue(29);
		}
		else if(result != this.M)
		{
			setVue(27);
		}
		else
		{
			setVue(28);
		}
	}
	
	public void resultatn(int result)
	{
		if(result == 0)
		{
			setVue(12);
		}
		else if(result != this.n)
		{
			setVue(11);
		}
		else
		{
			setVue(13);
		}
	}
	
	public void resultatm(int result)
	{
		if(result == 0)
		{
			setVue(16);
		}
		else if(result != this.phin)
		{
			setVue(15);
		}
		else
		{
			setVue(17);
		}
	}
	
	public List<String> fractionReduitesAvecSolution(List<Integer> fraction)
	{
		List<String> retour = new ArrayList<String>();
		retour.add("Tout d'abord nous avons en fractions continue :");
		String frac = "[";
		for(int i : fraction)
		{
			frac += i+",";
		}
		frac+="]";
		retour.add(frac);
		
		List<Integer> p = new ArrayList<Integer>();
		List<Integer> q = new ArrayList<Integer>();
		
		retour.add("La formule pour calculer les fraction est: p0=a0, q0=1, la fraction 1 est donc p0/q0 (a0 est le premier nombre de la liste au dessus)");
		retour.add("p1 = a0*a1+1, q1=a1");
		retour.add("pour le reste on a pn = an*pn-1 + pn-2 , qn = an*qn-1 + qn-2");
		
		p.add(fraction.get(0));
		q.add(1);
		retour.add("On a donc : fraction reduite 1 = "+fraction.get(0)+"/1");
		p.add(fraction.get(0)*fraction.get(1)+1);
		q.add(fraction.get(1));
		retour.add("fraction reduite 2 = "+(fraction.get(0)*fraction.get(1)+1)+"/"+fraction.get(1));
		for(int i = 2; i<fraction.size(); i++)
		{
			p.add((fraction.get(i)*p.get(i-1))+p.get(i-2));
			q.add((fraction.get(i)*q.get(i-1))+q.get(i-2));
			if(i+1 != fraction.size())
			{
				retour.add("fraction reduite "+(i+1)+" = "+((fraction.get(i)*p.get(i-1))+p.get(i-2))+"/"+((fraction.get(i)*q.get(i-1))+q.get(i-2)));
			}
		}
		return retour;
	}
	
	public void resultatFractionReduite(List<String> retour)
	{
		List<Integer> p = new ArrayList<Integer>();
		List<Integer> q = new ArrayList<Integer>();
		List<Integer> fraction = new ArrayList<Integer>();
		fraction = calc.fractioncontinue(e,n);
		
		p = fractionreduitesP(fraction);
		q = fractionreduitesQ(fraction);
		
		String s1 = p.get(0)+"/"+q.get(0);
		String s2 = p.get(1)+"/"+q.get(1);
		String s3 = p.get(2)+"/"+q.get(2);
		String s4 = p.get(3)+"/"+q.get(3);
		String s5 = p.get(4)+"/"+q.get(4);
		
		if(retour.get(0).equals("0") && retour.get(1).equals("0") && retour.get(2).equals("0") && retour.get(3).equals("0") && retour.get(4).equals("0"))
		{
			setVue(33);
		}
		else if(s1.equals(retour.get(0)) && s2.equals(retour.get(1)) && s3.equals(retour.get(2)) && s4.equals(retour.get(3)) && s5.equals(retour.get(4)))
		{
			setVue(31);
		}
		else 
		{
			setVue(32);
		}
	}
	
	public void exercicesperso(int question2)
	{
		this.question2 = question2;
		if(this.question2 == 1)
		{
		//Si e = 0, l'algo cherche un e au pif
		this.n = p*q;
		this.phin = (p-1)*(q-1); // ou m
		
		if(this.e == 0)
		{
			this.e = (int) (Math.random() * ( 100 - 1 ));
			this.resultpgcd = calc.pgcd(this.e,this.phin);
			
			while(this.resultpgcd!=1 && this.e < this.phin)
			{
				this.e = (int) (Math.random() * ( 200 - 1 ));
				this.resultpgcd = calc.pgcd(this.e,this.phin);
			}
		}
		else
		{
			this.resultpgcd = calc.pgcd(this.e,this.phin);
		}
		
		//calcul de d (l'inverse de e)
		this.d = calc.calculD(this.e, this.phin);
		if(d==0)
		{
			Rsa a = new Rsa();
		}
		
		setVue(3);
		}
		else if(this.question2 == 2)
		{
			this.c = calc.calculC(M, this.e, this.n);
			setVue(5);
		}
		else
		{
			setVue(41);	
		}
		
	}
	
	public String getAttaque()
	{
		AttaqueDeWeger aw = new AttaqueDeWeger(this.p, this.q);
		AttaqueDeWeiner aww = new AttaqueDeWeiner(this.p, this.q, this);
		AttaqueDeSimonsEtNoris asn = new AttaqueDeSimonsEtNoris();
		if(aw.AttaqueDeWegerResult(this.n, this.phin) && aww.AttaqueDeWeinerResult(this.e, this.n, this.c, this.M) && asn.AttaqueDeSimonsEtNorisResult(this.c, this.e, this.n) != 0)
		{
			return "Attaque de Weger, Weiner, Simmons fonctionnent";
		}
		else if(aw.AttaqueDeWegerResult(this.n, this.phin) && asn.AttaqueDeSimonsEtNorisResult(this.c, this.e, this.n) != 0)
		{
			return "Attaque de Weger et Simmons fonctionnent";
		}
		else if(aww.AttaqueDeWeinerResult(this.e, this.n, this.c, this.M) && asn.AttaqueDeSimonsEtNorisResult(this.c, this.e, this.n) != 0)
		{
			return "Attaque de Weiner et Simmons fonctionnent";
		}
		else if(aww.AttaqueDeWeinerResult(this.e, this.n, this.c, this.M) && aw.AttaqueDeWegerResult(this.n, this.phin))
		{
			return "Attaque de Weiner et Weger fonctionnent";
		}
		else if(aw.AttaqueDeWegerResult(this.n, this.phin))
		{
			return "Attaque de Weger fonctionne";
		}
		else if(asn.AttaqueDeSimonsEtNorisResult(this.c, this.e, this.n) != 0)
		{
			return "Attaque de Simons fonctionne";
		}
		return "Attaque de Weiner fonctionne";
	}
	
	public void setVue(int partie)
	{
		f.remove(vue1);
		vue1 = new VueRsa(partie, this);
		f.add(vue1);
		actualiser();
	}
	
	public List<Integer> fractionreduitesP(List<Integer> fraction)
	{
		List<Integer> p = new ArrayList<Integer>();
		p.add(fraction.get(0));
		p.add(fraction.get(0)*fraction.get(1)+1);
		for(int i = 2; i<fraction.size(); i++)
		{
			p.add((fraction.get(i)*p.get(i-1))+p.get(i-2));
		}
		return p;
	}
	
	public List<Integer> fractionreduitesQ(List<Integer> fraction)
	{
		List<Integer> q = new ArrayList<Integer>();
		q.add(1);
		q.add(fraction.get(1));
		for(int i = 2; i<fraction.size(); i++)
		{
			q.add((fraction.get(i)*q.get(i-1))+q.get(i-2));
		}
		return q;
	}
	
	public boolean getCalcP()
	{
		return this.calcP;
	}
	
	public void actualiser()
	{
		f.revalidate();
		f.repaint();
	}
	
	public void setdeM(int C)
	{
		deM[this.nb] = calc.calculC(C, this.d, this.n);
		this.nb++;
		if(this.nb<this.nbC)
		{	
			setVue(7);
		}
		else
		{
			setVue(5);
		}
	}
	
	public int getA()
	{
		return this.a;
	}
	
	public int getGP()
	{
		return this.P;
	}
	
	public int getk()
	{
		return this.k;
	}
	
	public int getB()
	{
		return this.b;
	}
	
	public int getS()
	{
		return this.s;
	}
	
	public int getNMAX()
	{
		return this.nmax;
	}
	
	public int getAlpha()
	{
		return this.alpha;
	}
	
	public int getE()
	{
		return this.e;
	}
	
	public int getNombre()
	{
		return this.nombre;
	}
	
	public int getPhin()
	{
		return this.phin;
	}
	
	public int getC2()
	{
		return this.c2;
	}
	
	public int getC()
	{
		return this.c;
	}
	
	public int getD()
	{
		return this.d;
	}
	
	public int getP()
	{
		return this.p;
	}
	
	public int getQ()
	{
		return this.q;
	}
	
	public int getM()
	{
		return this.M;
	}
	
	public void setC(int c)
	{
		this.c = c;
		this.M = calc.calculC(this.c, this.d, this.n);
	}
	
	public void setP(int p)
	{
		this.p = p;
	}
	
	public void setQ(int q)
	{
		this.q = q;
	}
	
	public void setE(int e)
	{
		this.e = e;
	}
	
	public void setM(int m)
	{
		this.M = m;
	}
	
	public int getN()
	{
		return this.n;
	}
	
	public void setnbC(int c)
	{
		this.nbC = c;
		setVue(7);
	}
	
	public String toStringInter()
	{
		return "Rsa [p=" + p + ", q=" + q + ", n=" + n + ", phin=" + phin + ", e=" + e +"]";
	}

	@Override
	public String toString() {
		String retour = "Rsa [p=" + p + ", q=" + q + ", n=" + n + ", phin=" + phin + ", e=" + e
		+ ", d=" + d;
		
		if(this.question2 == 2 && this.nbC == 0)
		{
			retour += ", chiffré =" + c;
		}
		else if(this.nbC != 0)
		{
			for(int i = 0;i<this.nbC;i++)
			{
				retour += ", dechiffré=" + deM[i];
			}
		}
		retour += "]";
		return retour;
	}

}
