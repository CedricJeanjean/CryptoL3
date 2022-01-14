package rsa;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueRsa extends JPanel{
	
	private JTextField result;
	private Calculs calc;
	private JLabel titre;
	private JLabel texte;
	private JLabel texte2;
	private JLabel texte3;
	private JLabel texte4;
	private JLabel texte5;
	private JLabel texte6;
	private JLabel texte7;
	private JLabel texte8;
	private JLabel texte9;
	private JButton choix1;
	private JButton choix2;
	private JButton choix3;
	private JButton choix4;
	private JButton choix5;
	private JButton choix6;
	private JButton choix7;
	private JButton choix8;
	private JButton choix9;
	private JButton choix10;
	private JButton choix11;
	private JButton choix12;
	private JButton choix13;
	private JButton choix14;
	private JButton choix15;
	private JButton choix16;
	private JButton choix17;
	private JButton choix18;
	private JButton choix19;
	private TextField entree1;
	private TextField entree2;
	private TextField entree3;
	private TextField entree4;
	private TextField entree5;
	private JButton valider;
	private JButton correction;
	private JPanel p1;
	private JPanel p2;
	private JPanel p3;
	private List<TextField> text;
	
	public VueRsa(int partie , Rsa a)
	{
		ControleurRsa controleur = new ControleurRsa(a, this);
		this.calc = new Calculs();
		
		//création des trucs utile
		this.setLayout(new BorderLayout());
		
		titre = new JLabel("Rsa");
		JPanel ptitre = new JPanel(new GridLayout(1,1));
		ptitre.add(titre);
		this.add(ptitre,BorderLayout.NORTH);
		
		texte = new JLabel("");
		texte2 = new JLabel("");
		texte3 = new JLabel("");
		texte4 = new JLabel("");
		texte5 = new JLabel("");
		texte6 = new JLabel("");
		texte7 = new JLabel("");
		texte8 = new JLabel("");
		texte9 = new JLabel("");
		entree1 = new TextField();
		entree2 = new TextField();
		entree3 = new TextField();
		entree4 = new TextField();
		entree5 = new TextField();
		valider = new JButton("Valider");
		valider.addActionListener(controleur);
		correction = new JButton("Correction");
		correction.addActionListener(controleur);
		choix1 = new JButton();
		choix1.addActionListener(controleur);
		choix2 = new JButton();
		choix2.addActionListener(controleur);
		choix3 = new JButton();
		choix3.addActionListener(controleur);
		choix4 = new JButton();
		choix4.addActionListener(controleur);
		choix5 = new JButton();
		choix5.addActionListener(controleur);
		choix6 = new JButton();
		choix6.addActionListener(controleur);
		choix7 = new JButton();
		choix7.addActionListener(controleur);
		choix8 = new JButton();
		choix8.addActionListener(controleur);
		choix9 = new JButton();
		choix9.addActionListener(controleur);
		choix10 = new JButton();
		choix10.addActionListener(controleur);
		choix11 = new JButton();
		choix11.addActionListener(controleur);
		choix12 = new JButton();
		choix12.addActionListener(controleur);
		choix13 = new JButton();
		choix13.addActionListener(controleur);
		choix14 = new JButton();
		choix14.addActionListener(controleur);
		choix15 = new JButton();
		choix15.addActionListener(controleur);
		choix16 = new JButton();
		choix16.addActionListener(controleur);
		choix17 = new JButton();
		choix17.addActionListener(controleur);
		choix18 = new JButton();
		choix18.addActionListener(controleur);
		choix19 = new JButton();
		choix19.addActionListener(controleur);
		
		text = new ArrayList<>();
		
		p2 = new JPanel(new GridLayout(2,1));
		
		if(partie == 1)
		{	
			p1 = new JPanel(new GridLayout(3,1));
			
			texte.setText("Je souhaite:");
			choix1.setText("Utiliser l'algo pour mes exercices (4 premiers td seulement)");
			choix2.setText("Faire des exercices");
			p1.add(texte);
			p1.add(choix1);
			p1.add(choix2);
			
			this.add(p1,BorderLayout.CENTER);
		}
		else if(partie == 2)
		{
			p1 = new JPanel(new GridLayout(3,2));
			texte.setText("Saisie p");
			texte2.setText("Saisie q");
			texte3.setText("Saisie e ( ou 0 et l'algo en choisi un pour toi bro )");
			p1.add(texte);
			p1.add(entree1);
			p1.add(texte2);
			p1.add(entree2);
			p1.add(texte3);
			p1.add(entree3);
			
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 3)
		{
			p1 = new JPanel(new GridLayout(5,1));
			texte.setText(a.toString());
			texte2.setText("Voulez-vous chiffré ou déchiffré un message ou test les attaques?"); 
			choix1.setText("Chiffré un message");
			choix2.setText("Déchiffré un message");
			choix3.setText("Test les attaques?");
			p1.add(texte);
			p1.add(texte2);
			p1.add(choix1);
			p1.add(choix2);
			p1.add(choix3);
			
			this.add(p1,BorderLayout.CENTER);
		}
		else if(partie == 4)
		{
			p1 = new JPanel(new GridLayout(3,2));
			texte.setText("Veuillez saisir un mot M:");
			p1.add(texte);
			p1.add(entree1);
			
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 5)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText(a.toString());
			p1.add(texte);
			this.add(p1,BorderLayout.CENTER);
		}
		else if(partie == 6)
		{
			p1 = new JPanel(new GridLayout(3,2));
			texte.setText("Combien de messages à dechiffrés? (1 ou 2 ou 3 ou ... ou 50)");
			p1.add(texte);
			p1.add(entree1);
			
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 7)
		{
			p1 = new JPanel(new GridLayout(3,2));
			texte.setText("Veuillez saisir un mot C :");
			p1.add(texte);
			p1.add(entree1);
			
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 8)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText(a.toString());
			texte2.setText(a.getAttaque());
			p1.add(texte);
			p1.add(texte2);
			this.add(p1,BorderLayout.CENTER);
		}
		else if(partie == 9)
		{
			p1 = new JPanel(new GridLayout(12,1));
			//choix1.setText("Exercice 1: Calculer un RSA");
			//choix2.setText("Exercice 2: Calculer C");
			//choix3.setText("Exercice 3: Calculer M");
			//choix4.setText("Exercice 4: Attaque de Wiener");
			//choix5.setText("Exercice 5: Attaque de Weger");
			//choix6.setText("Exercice 6: Attaque de Simmons et Noris");
			//choix7.setText("Exercice 7: Attaque de Pollard 3");
			//choix8.setText("Exercice 8: Attaque de Pollard 2");
			choix10.setText("Exercice 6: Decryptage de ElGamal");
			choix9.setText("Exercice 5: Cryptage de ElGamal");
			//choix11.setText("Exercice 11: Attaque de ElGamal");
			//choix12.setText("Exercice 12: Test de primalite");
			choix13.setText("Exercice 1: Exponentiation dichotomique");
			choix14.setText("Exercice 2: Calculer un ordre");
			choix15.setText("Exercice 4: Logarithmes discrets");
			choix16.setText("Exercice 3: Trouver des racines primitives");
			choix17.setText("Exercice 7: Attaque de ElGamal");
			choix19.setText("Exercice 8: Diffie-Hellman");
			choix18.setText("Acceder à tous les exercices ( Pas dans le programme de L3 mais peut-etre Master)");
			//p1.add(choix1);
			//p1.add(choix2);
			//p1.add(choix3);
			//p1.add(choix4);
			//p1.add(choix5);
			//p1.add(choix6);
			//p1.add(choix7);
			//p1.add(choix8);
			p1.add(choix13);
			p1.add(choix14);
			p1.add(choix16);
			p1.add(choix15);
			p1.add(choix9);
			p1.add(choix10);
			p1.add(choix17);
			p1.add(choix19);
			p1.add(choix18);
			//p1.add(choix11);
			//p1.add(choix12);
			
			this.add(p1,BorderLayout.CENTER);
		}
		else if(partie == 10)
		{
			p1 = new JPanel(new GridLayout(3,2));
			texte.setText("p = "+a.getP() + " et q = "+a.getQ());
			texte2.setText("Entrer n (ou 0 pour avoir de la solution) :");
			texte4.setText("Calculer n et m:");
			p1.add(texte);
			p1.add(texte4);
			p1.add(texte2);
			p1.add(entree1);
			
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 11)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais resultat");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 12)
		{
			p1 = new JPanel(new GridLayout(2,1));
			texte.setText("n = p * q");
			texte2.setText("Dans notre cas p= "+a.getP()+" et q= "+a.getQ()+",donc n = "+a.getP()*a.getQ());
			
			p1.add(texte);
			p1.add(texte2);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 13)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo tu as trouvé n");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 14)
		{
			p1 = new JPanel(new GridLayout(3,2));
			texte.setText("p = "+a.getP() + " et q = "+a.getQ());
			texte2.setText("Entrer m (ou 0 pour avoir de la solution) :");
			texte4.setText("Calculer n et m:");
			p1.add(texte);
			p1.add(texte4);
			p1.add(texte2);
			p1.add(entree1);
			
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 15)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais resultat dommage");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 16)
		{
			p1 = new JPanel(new GridLayout(2,1));
			texte.setText("m = (p-1)*(q-1)");
			texte2.setText("Dans notre cas p= "+a.getP()+" et q= "+a.getQ()+",donc m = "+(a.getP()-1)*(a.getQ()-1));
			
			p1.add(texte);
			p1.add(texte2);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 17)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo tu as trouvé m");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 18)
		{
			p1 = new JPanel(new GridLayout(2,1));
			texte.setText(a.toStringInter());
			p1.add(texte);
			texte2.setText("Calculer d et entrer le (ou 0 pour avoir de la solution) :");
			p1.add(texte2);
			p1.add(entree1);
			
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 19)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais resultat dommage eheh");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 20)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo tu as trouvé d, le rsa est donc:");
			texte2.setText(a.toString());
			p1.add(texte);
			p1.add(texte2);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 21)
		{
			int nb = 0;
			texte.setText("Ouioui");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			ArrayList<String> retour = new ArrayList<>();
			retour = calc.calculDavecSolution(a.getE(), a.getPhin());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 22)
		{
			texte.setVisible(true);
			p1 = new JPanel(new GridLayout(4,1));
			texte.setText(a.toString());
			texte2.setText("Nicolas Sarkozy veut envoyer un message a son avocat Thierry Herzog pour corrompre un magistrat de la cour de cassation, or, étant sur écoute il decide de crypter son message, il veut envoyer le message M = "+a.getM());
			texte3.setText("Calculer C et entrer le (ou 0 pour avoir de la solution) :");
			p1.add(texte);
			p1.add(texte2);
			p1.add(texte3);
			p1.add(entree1);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 23)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais resultat eheh");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 24)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo tu as trouvé c");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 25)
		{
			int nb = 0;
			texte.setText("Nonnon");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			ArrayList<String> retour = new ArrayList<>();
			retour = calc.calculCavecSolution(a.getM(), a.getE(), a.getN());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 26)
		{
			texte.setVisible(true);
			p1 = new JPanel(new GridLayout(4,1));
			texte.setText(a.toString());
			texte2.setText("Nicolas Sarkozy a envoyé un message à son avocat Thierry Herzog pour corrompre un magistrat de la cour de cassation, or, étant sur écoute il decide de crypter son message, on veut décrypter C = "+a.getC());
			texte3.setText("Calculer M et entrer le (ou 0 pour avoir de la solution) :");
			p1.add(texte);
			p1.add(texte2);
			p1.add(texte3);
			p1.add(entree1);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 27)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais resultat de M");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 28)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo tu as trouvé M");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 29)
		{
			int nb = 0;
			texte.setText("Nonnonbril");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			ArrayList<String> retour = new ArrayList<>();
			retour = calc.calculMavecSolution(a.getC(), a.getD(), a.getN());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 30)
		{
			p1 = new JPanel(new GridLayout(5,1));
			texte.setText("Jean-Marie Le Pen a codé le RSA avec la clé publique (e,n) = ("+a.getE()+","+a.getN()+")");
			texte2.setText("L'attaquant a calculé la fraction continue et a trouvé:");
			List<Integer> retour = new ArrayList<Integer>();
			retour = calc.fractioncontinue(a.getE(), a.getN());
			String frac = "[";
			for(int i : retour)
			{
				frac += i+",";
			}
			frac+="]";
			texte3.setText(frac);
			texte4.setText("Calculer les 5 premieres réduites (l'écrire comme ça: 58/34 ou mettre 0 à TOUTES les reduite pour avoir la solution)");
			p3 = new JPanel(new GridLayout(5,2));
			texte5.setText("Réduite 1:");
			texte6.setText("Réduite 2:");
			texte7.setText("Réduite 3:");
			texte8.setText("Réduite 4:");
			texte9.setText("Réduite 5:");
			
			p1.add(texte);
			p1.add(texte2);
			p1.add(texte3);
			p1.add(texte4);
			p3.add(texte5);
			p3.add(entree1);
			p3.add(texte6);
			p3.add(entree2);
			p3.add(texte7);
			p3.add(entree3);
			p3.add(texte8);
			p3.add(entree4);
			p3.add(texte9);
			p3.add(entree5);
			p1.add(p3);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 31)
		{
			p1 = new JPanel(new GridLayout(5,1));
			texte.setText("Jean-Marie Le Pen a codé le RSA avec la clé publique (e,n) = ("+a.getE()+","+a.getN()+")");
			texte2.setText("En supposant que M="+a.getM()+", l'attaquant a codé M et a trouvé C="+a.getC()+" .Déduire la valeur de d");
			texte3.setText("Calculer d grâce à C et entrer le (ou 0 pour avoir de la solution) :");
			
			p1.add(texte);
			p1.add(texte2);
			p1.add(texte3);
			p1.add(entree1);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 32)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais resultat aux fractions reduites");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 33)
		{
			int nb = 0;
			texte.setText("Nonnonbrileeee");
			texte.setVisible(false);
			List<Integer> retour = new ArrayList<Integer>();
			List<String> retour2 = new ArrayList<String>();
			ArrayList<JTextField> temp = new ArrayList<>();
			retour = calc.fractioncontinue(a.getE(), a.getN());
			retour2 = a.fractionReduitesAvecSolution(retour);
			for(String i : retour2)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 34)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais resultat 2");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 35)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo tu as trouvé D");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 36)
		{
			AttaqueDeWeiner wn = new AttaqueDeWeiner(a.getP(),a.getQ(),a);
			int nb = 0;
			texte.setText("gogo");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = wn.AttaqueDeWeineravecSolution(a.getE(), a.getN(), a.getC(),a.getM());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 37)
		{
			p1 = new JPanel(new GridLayout(3,1));
			texte.setText("Jean-Michel raciste à trouvé n et m (n,m) = ("+a.getN()+","+a.getM()+")");
			texte2.setText("Calculer p et q et entrez les (ou 0 pour avoir de la solution) :");
			p3 = new JPanel(new GridLayout(2,2));
			
			texte3.setText("p = ");
			texte4.setText("q = ");
			p3.add(texte3);
			p3.add(entree1);
			p3.add(texte4);
			p3.add(entree2);
			
			p1.add(texte);
			p1.add(texte2);
			p1.add(p3);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 38)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo tu as trouvé p et q");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 39)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais resultat 1");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 40)
		{
			AttaqueDeWeger wg = new AttaqueDeWeger(a.getP(),a.getQ());
			int nb = 0;
			texte.setText("weger");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = wg.AttaqueDeWegeravecSolution(a.getN(), a.getM());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 41)
		{
			texte.setVisible(true);
			p1 = new JPanel(new GridLayout(4,1));
			texte.setText("Entrez le message C");
			p1.add(texte);

			p1.add(entree1);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 42)
		{
			p1 = new JPanel(new GridLayout(3,1));
			texte.setText("Donald envoie des messages privés à son ami Kim Jong-un et a codé son message C = "+a.getC()+". Il a codé sont message avec la clé publique de Kim (n,e) = ("+a.getN()+","+a.getE()+")");
			texte2.setText("Calculer M avec l'attaque de Simmons et Noris (ou 0 pour avoir de la solution) :");
			p3 = new JPanel(new GridLayout(1,1));
			
			texte3.setText("M = ");
			p3.add(texte3);
			p3.add(entree1);
			
			p1.add(texte);
			p1.add(texte2);
			p1.add(p3);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 43)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo tu as récupéré le message de donald");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 44)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Pas le bon résultat");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 45)
		{
			AttaqueDeSimonsEtNoris asn = new AttaqueDeSimonsEtNoris();
			int nb = 0;
			texte.setText("noris");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = asn.AttaqueDeSimonsEtNorisAvecSolution(a.getC(), a.getE(), a.getN());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 46)
		{
			p1 = new JPanel(new GridLayout(3,1));
			texte.setText("Sam veut construire la factorisation de n = "+a.getN()+" grâce à Pollard 3. Il utilise a1 = "+a.getA());
			texte2.setText("Calculer p et q avec l'attaque de Pollard 3 (ou 0 pour avoir de la solution) :");
			p3 = new JPanel(new GridLayout(2,2));
			
			texte3.setText("p = ");
			texte4.setText("q = ");
			p3.add(texte3);
			p3.add(entree1);
			p3.add(texte4);
			p3.add(entree2);
			
			p1.add(texte);
			p1.add(texte2);
			p1.add(p3);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 47)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo sam à récupérer p et q");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 48)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Pas le bon résultat dsl");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 49)
		{
			AttaqueDePollard asn = new AttaqueDePollard();
			int nb = 0;
			texte.setText("pollard3");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = asn.AttaqueDePollard3AvecSolution(a.getN(), a.getA());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 50)
		{
			p1 = new JPanel(new GridLayout(3,1));
			texte.setText("Sam veut construire la factorisation de n = "+a.getN()+" grâce à Pollard 2. Il utilise x0 = "+a.getA()+ " et b ="+a.getB());
			texte2.setText("Calculer p et q avec l'attaque de Pollard 2 (ou 0 pour avoir de la solution) :");
			p3 = new JPanel(new GridLayout(2,2));
			
			texte3.setText("p = ");
			texte4.setText("q = ");
			p3.add(texte3);
			p3.add(entree1);
			p3.add(texte4);
			p3.add(entree2);
			
			p1.add(texte);
			p1.add(texte2);
			p1.add(p3);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 51)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Pas le bon résultat de pollard 2");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 52)
		{
			AttaqueDePollard asn = new AttaqueDePollard();
			int nb = 0;
			texte.setText("pollard2");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = asn.AttaqueDePollard2AvecSolution(a.getN(), a.getB(),a.getA());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 53)
		{
			p1 = new JPanel(new GridLayout(4,1));
			texte.setText("On a p = "+a.getP()+", k = "+a.getS()+", g = "+a.getAlpha());
			texte2.setText("Louis a coder son message C et obtient C = ( "+a.getC()+","+a.getC2()+") mais il a oublié son message original M , retrouver le avec ElGamal");
			texte3.setText("Calculer M avec ElGamal :");
			p3 = new JPanel(new GridLayout(2,2));
			
			texte4.setText("M = ");
			p3.add(texte4);
			p3.add(entree1);
			
			p1.add(texte);
			p1.add(texte2);
			p1.add(texte3);
			p1.add(p3);
			p2.add(valider);
			p2.add(correction);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 54)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Pas le bon résultat de ElGamal");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 55)
		{
			AttaqueDeElGamal at = new AttaqueDeElGamal();
			int nb = 0;
			texte.setText("ElGamal");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = at.AttaqueDeElGamalAvecSolution(a.getP(), a.getS(),a.getAlpha(),a.getC(),a.getC2());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 56)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo tu as trouvé M grâce a ElGamal");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 57)
		{
			p1 = new JPanel(new GridLayout(4,1));
			if(a.getCalcP())
			{
				texte.setText("Nous sommes dans F"+a.getP()+", avec k = "+a.getS()+", g = "+a.getAlpha());
			}
			else
			{
				texte.setText("Nous sommes dans F"+a.getP()+", avec h = "+a.getS()+", g = "+a.getAlpha());
			}
			texte2.setText("Louis veut coder son message M = "+a.getM()+" avec l'aléa r = "+a.getk());
			texte3.setText("Coder M avec ElGamal :");
			p3 = new JPanel(new GridLayout(2,2));
			
			texte4.setText("C1 = ");
			p3.add(texte4);
			p3.add(entree1);
			texte5.setText("C2 = ");
			p3.add(texte5);
			p3.add(entree2);
			
			
			p1.add(texte);
			p1.add(texte2);
			p1.add(texte3);
			p1.add(p3);
			p2.add(valider);
			p2.add(correction);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 58)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo tu as codé M grâce a ElGamal");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 59)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Pas le bon résultat :/");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 60)
		{
			AttaqueDeElGamal at = new AttaqueDeElGamal();
			int nb = 0;
			texte.setText("ElGamalM");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = at.coderMavecSolution(a.getP(), a.getS(),a.getAlpha(),a.getM(),a.getk(),a.getCalcP());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 61)
		{
			p1 = new JPanel(new GridLayout(4,1));
			texte.setText("On a p = "+a.getP()+", alpha = "+a.getAlpha()+", P = "+a.getGP());
			texte2.setText("Jean-Maris Bigard a généré le message C = ("+a.getC()+","+a.getC2()+")");
			texte3.setText("Calculer M avec Skanks (ou 0 pour avoir de la solution) :");
			p3 = new JPanel(new GridLayout(2,2));
			
			texte4.setText("M = ");
			p3.add(texte4);
			p3.add(entree1);
			
			
			p1.add(texte);
			p1.add(texte2);
			p1.add(texte3);
			p1.add(p3);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 62)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo tes juste trop fort");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 63)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Tes éclatax mec");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 64)
		{
			AttaqueDeElGamal at = new AttaqueDeElGamal();
			int nb = 0;
			texte.setText("ElGamalM2");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = at.AttaqueDeElGamalLaVraiAvecSolution(a.getP(), a.getAlpha(),a.getGP(),a.getC(),a.getC2());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 65)
		{
			p1 = new JPanel(new GridLayout(3,1));
			texte.setText("On a un nombre qui est égal à = "+a.getNombre()+" et une liste de nombres premiers de 1 à "+a.getNMAX());
			texte3.setText("Le nombre est premier ? (1 = oui, 2 = non) (ou 0 pour avoir de la solution) :");
			p3 = new JPanel(new GridLayout(2,2));
			
			texte4.setText("Premier? = ");
			p3.add(texte4);
			p3.add(entree1);
			
			p1.add(texte);
			p1.add(texte3);
			p1.add(p3);
			
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 66)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo le nombre est premier");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 67)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Ta raté ton 1 chance sur 2");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 68)
		{
			TestDePrimalite test = new TestDePrimalite();
			int nb = 0;
			texte.setText("testdeprima");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = test.premierAvecSolution(a.getNombre(),a.getNMAX());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 69)
		{
			p1 = new JPanel(new GridLayout(2,1));
			texte.setText("Calculer "+a.getP()+"^"+a.getQ()+" dans F"+a.getN()+" :");
			p3 = new JPanel(new GridLayout(2,2));
			
			texte4.setText("Resultat = ");
			p3.add(texte4);
			p3.add(entree1);
			
			
			p1.add(texte);
			p1.add(p3);
			p2.add(valider);
			p2.add(correction);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 70)
		{
			int nb = 0;
			texte.setText("expodicho");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = calc.calculExpoDichoAvecSolution(a.getP(),a.getQ(),a.getN());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 71)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 72)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais résultat dommage");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 73)
		{
			p1 = new JPanel(new GridLayout(2,1));
			texte.setText("Calculer l'ordre de "+a.getP()+" dans F"+a.getN()+" :");
			p3 = new JPanel(new GridLayout(2,2));
			
			texte4.setText("Ordre = ");
			p3.add(texte4);
			p3.add(entree1);
			
			
			p1.add(texte);
			p1.add(p3);
			p2.add(valider);
			p2.add(correction);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 74)
		{
			int nb = 0;
			texte.setText("ordre");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = calc.ordreAvecSolution(a.getP(),a.getN());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 75)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 76)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais ordre");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 77)
		{
			p1 = new JPanel(new GridLayout(2,1));
			texte.setText("Calculer les logarithmes discrets de F"+a.getP()+" en base "+a.getN()+" :");
			texte2.setText("Logdis");
			texte2.setVisible(false);
			p3 = new JPanel(new GridLayout(2,a.getP()));
			
			for(int i = 0; i<=a.getP();i++)
			{
				JLabel texteIl = new JLabel();
				if(i == 0)
				{
					texteIl.setText("x");
				}
				else if(i == a.getP())
				{
					texteIl.setText("Log(x)");
				}
				else
				{
					texteIl.setText(String.valueOf(i));
				}
				p3.add(texteIl);
			}
			
			
			for(int i = 1; i<a.getP();i++)
			{
				TextField but = new TextField();
				text.add(but);
				p3.add(but);
			}
			
			p1.add(texte);
			p1.add(p3);
			p2.add(valider);
			p2.add(correction);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 78)
		{
			int nb = 0;
			texte.setText("logdiscret");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = calc.logarithmeDiscretAvecCorrection(a.getP(),a.getN());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 79)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("bravo");
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 80)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais logarithmes discrets");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 81)
		{
			p1 = new JPanel(new GridLayout(3,1));
			texte.setText("Calculer toutes les racines primitives dans F"+a.getP()+" :");
			List<Integer> rac = calc.racinePrimitiveAll(a.getP());
			texte2.setText("Indice : Il y en a "+rac.size());
			texte3.setText("RacinePrim");
			texte3.setVisible(false);
			p3 = new JPanel(new GridLayout(2,rac.size()));
			
			for(int i = 1; i<=rac.size();i++)
			{
				JLabel lab = new JLabel();
				lab.setText("Racine "+i+" : ");
				TextField but = new TextField();
				p3.add(lab);
				text.add(but);
				p3.add(but);
			}
			
			
			p1.add(texte);
			p1.add(texte2);
			p1.add(p3);
			p2.add(valider);
			p2.add(correction);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 82)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais résultat de racine primitive");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 83)
		{
			int nb = 0;
			texte.setText("racineprimitive");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = calc.racinePrimitiveAllAvecCorrection(a.getP());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 84)
		{
			p1 = new JPanel(new GridLayout(4,1));
			texte.setText("On a p = "+a.getP()+", h = "+a.getk()+", g = "+a.getAlpha());
			texte2.setText("Sam intercepte le message C = ( "+a.getC()+","+a.getC2()+" ) , déchiffrer le avec ElGamal");
			texte3.setText("Déchiffrer M avec ElGamal :");
			p3 = new JPanel(new GridLayout(2,2));
			
			texte4.setText("M = ");
			p3.add(texte4);
			p3.add(entree1);
			
			p1.add(texte);
			p1.add(texte2);
			p1.add(texte3);
			p1.add(p3);
			p2.add(valider);
			p2.add(correction);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 85)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Mauvais résultat dans le déchiffrage de M");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 86)
		{
			AttaqueDeElGamal at = new AttaqueDeElGamal();
			int nb = 0;
			texte.setText("attaquedelgamal");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = at.AttaqueDeElGamalAvecSolutionPlusDur(a.getP(),a.getS(),a.getAlpha(),a.getC(),a.getC2(),a.getk());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 87)
		{
			p1 = new JPanel(new GridLayout(4,1));
			texte.setText("On a p = "+a.getN()+", alpha = "+a.getAlpha()+" et on prends un nombre r = "+a.getP());
			texte2.setText("Calculer le message à envoyer à Bob");
			texte3.setText("On recoit "+a.getC2()+", calculer le secret commun");
			p3 = new JPanel(new GridLayout(5,2));
			
			texte4.setText("Message = ");
			p3.add(texte4);
			p3.add(entree1);
			
			p3.add(texte3);
			
			texte5.setText("Secret commun = ");
			p3.add(texte5);
			p3.add(entree2);
			
			p1.add(texte);
			p1.add(texte2);
			p1.add(p3);
			p2.add(valider);
			p2.add(correction);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 88)
		{
			p1 = new JPanel(new GridLayout(1,1));
			texte.setText("Ce n'est pas le bon resultat");
			
			p1.add(texte);
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 89)
		{
			int nb = 0;
			texte.setText("diffiehellman");
			texte.setVisible(false);
			ArrayList<JTextField> temp = new ArrayList<>();
			List<String> retour = new ArrayList<>();
			retour = calc.diffiehellman(a.getAlpha(),a.getP(),a.getN(),a.getC2());
			for(String i : retour)
			{
				JTextField j = new JTextField(i);
				temp.add(j);
				nb++;
			}
			
			p1 = new JPanel(new GridLayout(nb,1));
			for(int i = 0; i<nb; i++)
			{
				p1.add(temp.get(i));
			}
			p2.add(valider);
			
			this.add(p1,BorderLayout.CENTER);
			this.add(p2,BorderLayout.SOUTH);
		}
		else if(partie == 100)
		{
			p1 = new JPanel(new GridLayout(19,1));
			JLabel texteee = new JLabel();
			texteee.setText("Cette version comporte encore beaucoup de bug");
			choix1.setText("Exercice 7: Calculer un RSA");
			choix2.setText("Exercice 8: Calculer C");
			choix3.setText("Exercice 9: Calculer M");
			choix4.setText("Exercice 10: Attaque de Wiener");
			choix5.setText("Exercice 11: Attaque de Weger");
			choix6.setText("Exercice 12: Attaque de Simmons et Noris");
			choix7.setText("Exercice 13: Attaque de Pollard 3");
			choix8.setText("Exercice 14: Attaque de Pollard 2");
			choix10.setText("Exercice 6: Decryptage de ElGamal");
			choix9.setText("Exercice 5: Cryptage de ElGamal");
			choix11.setText("Exercice 15: Attaque de ElGamal");
			choix12.setText("Exercice 16: Test de primalite");
			choix13.setText("Exercice 1: Exponentiation dichotomique");
			choix14.setText("Exercice 2: Calculer un ordre");
			choix15.setText("Exercice 4: Logarithmes discrets");
			choix16.setText("Exercice 3: Trouver des racines primitives");
			choix17.setText("Acceder aux exercices de L3");
			p1.add(texteee);
			p1.add(choix13);
			p1.add(choix14);
			p1.add(choix16);
			p1.add(choix15);
			p1.add(choix9);
			p1.add(choix10);
			p1.add(choix1);
			p1.add(choix2);
			p1.add(choix3);
			p1.add(choix4);
			p1.add(choix5);
			p1.add(choix6);
			p1.add(choix7);
			p1.add(choix8);
			p1.add(choix11);
			p1.add(choix12);
			p1.add(choix17);
			
			this.add(p1,BorderLayout.CENTER);
		}
	}
	
	public List<TextField> getText()
	{
		return text;
	}
	
	public String getTexte()
	{
		return texte.getText();
	}
	
	public String getTexte2()
	{
		return texte2.getText();
	}
	
	public String getTexte3()
	{
		return texte3.getText();
	}
	
	public String getTexte4()
	{
		return texte4.getText();
	}
	
	public String getEntree1()
	{
		return entree1.getText();
	}
	
	public String getEntree2()
	{
		return entree2.getText();
	}
	
	public String getEntree3()
	{
		return entree3.getText();
	}
	
	public String getEntree4()
	{
		return entree4.getText();
	}
	
	public String getEntree5()
	{
		return entree5.getText();
	}

}
