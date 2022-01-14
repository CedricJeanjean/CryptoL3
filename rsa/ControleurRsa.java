package rsa;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;

public class ControleurRsa implements ActionListener{

	private Rsa rsa;
	private VueRsa ra;
	
	public ControleurRsa(Rsa r, VueRsa ra)
	{
		this.rsa = r;
		this.ra = ra;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton) e.getSource();
		if(b.getText().equals("Utiliser l'algo pour mes exercices (4 premiers td seulement)"))
		{
			rsa.setVue(2);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Saisie p"))
		{
			rsa.setP(Integer.parseInt(ra.getEntree1()));
			rsa.setQ(Integer.parseInt(ra.getEntree2()));
			rsa.setE(Integer.parseInt(ra.getEntree3()));
			rsa.exercicesperso(1);
		}
		else if(b.getText().equals("Chiffré un message"))
		{
			rsa.setVue(4);
		}
		else if(b.getText().equals("Déchiffré un message"))
		{
			rsa.setVue(6);
		}
		else if(b.getText().equals("Test les attaques?"))
		{
			rsa.exercicesperso(3);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Veuillez saisir un mot M:"))
		{
			rsa.setM(Integer.parseInt(ra.getEntree1()));
			rsa.exercicesperso(2);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Combien de messages à dechiffrés? (1 ou 2 ou 3 ou ... ou 50)"))
		{
			rsa.setnbC(Integer.parseInt(ra.getEntree1()));
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Veuillez saisir un mot C :"))
		{
			rsa.setdeM(Integer.parseInt(ra.getEntree1()));
		}
		else if(b.getText().equals("Faire des exercices"))
		{
			rsa.setVue(9);
		}
		else if(b.getText().equals("Exercice 7: Calculer un RSA"))
		{
			rsa.exercices(1);
		}
		else if(b.getText().equals("Valider") && ra.getTexte2().equals("Entrer n (ou 0 pour avoir de la solution) :"))
		{
			rsa.resultatn(Integer.parseInt(ra.getEntree1()));
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais resultat"))
		{
			rsa.setVue(10);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("n = p * q"))
		{
			rsa.setVue(10);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo tu as trouvé n"))
		{
			rsa.setVue(14);
		}
		else if(b.getText().equals("Valider") && ra.getTexte2().equals("Entrer m (ou 0 pour avoir de la solution) :"))
		{
			rsa.resultatm(Integer.parseInt(ra.getEntree1()));
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("m = (p-1)*(q-1)"))
		{
			rsa.setVue(14);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo tu as trouvé m"))
		{
			rsa.exercices(2);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais resultat dommage"))
		{
			rsa.setVue(14);
		}
		else if(b.getText().equals("Valider") && ra.getTexte2().equals("Calculer d et entrer le (ou 0 pour avoir de la solution) :"))
		{
			rsa.resultatd(Integer.parseInt(ra.getEntree1()));
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais resultat dommage eheh"))
		{
			rsa.setVue(18);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo tu as trouvé d"))
		{
			rsa.exercices(2);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Ouioui"))
		{
			rsa.setVue(18);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo tu as trouvé d, le rsa est donc:"))
		{
			rsa.setVue(1);
		}
		else if(b.getText().equals("Exercice 8: Calculer C"))
		{
			rsa.exercices(3);
		}
		else if(b.getText().equals("Exercice 9: Calculer M"))
		{
			rsa.exercices(4);
		}
		else if(b.getText().equals("Valider") && ra.getTexte3().equals("Calculer C et entrer le (ou 0 pour avoir de la solution) :"))
		{
			rsa.resultatC(Integer.parseInt(ra.getEntree1()));
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais resultat eheh"))
		{
			rsa.setVue(22);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo tu as trouvé c"))
		{
			rsa.setVue(1);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Nonnon"))
		{
			rsa.setVue(22);
		}
		else if(b.getText().equals("Valider") && ra.getTexte3().equals("Calculer M et entrer le (ou 0 pour avoir de la solution) :"))
		{
			rsa.resultatM(Integer.parseInt(ra.getEntree1()));
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais resultat de M"))
		{
			rsa.setVue(26);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo tu as trouvé M"))
		{
			rsa.setVue(1);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Nonnonbril"))
		{
			rsa.setVue(26);
		}
		else if(b.getText().equals("Valider") && ra.getTexte2().equals("L'attaquant a calculé la fraction continue et a trouvé:"))
		{
			List<String> retour = new ArrayList<String>();
			retour.add(ra.getEntree1());
			retour.add(ra.getEntree2());
			retour.add(ra.getEntree3());
			retour.add(ra.getEntree4());
			retour.add(ra.getEntree5());
			rsa.resultatFractionReduite(retour);
		}
		else if(b.getText().equals("Exercice 10: Attaque de Wiener"))
		{
			rsa.exercices(5);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais resultat aux fractions reduites"))
		{
			rsa.setVue(30);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Nonnonbrileeee"))
		{
			rsa.setVue(30);
		}
		else if(b.getText().equals("Valider") && ra.getTexte3().equals("Calculer d grâce à C et entrer le (ou 0 pour avoir de la solution) :"))
		{
			rsa.resultatdavecC(Integer.parseInt(ra.getEntree1()));
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais resultat 2"))
		{
			rsa.setVue(31);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo tu as trouvé D"))
		{
			rsa.setVue(1);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("gogo"))
		{
			rsa.setVue(31);
		}
		else if(b.getText().equals("Exercice 11: Attaque de Weger"))
		{
			rsa.exercices(6);
		}
		else if(b.getText().equals("Valider") && ra.getTexte2().equals("Calculer p et q et entrez les (ou 0 pour avoir de la solution) :"))
		{
			int[] retour = new int[2];
			retour[0] = Integer.parseInt(ra.getEntree1());
			retour[1] = Integer.parseInt(ra.getEntree2());
			rsa.resultatWeger(retour);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo tu as trouvé p et q"))
		{
			rsa.setVue(1);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais resultat 1"))
		{
			rsa.setVue(37);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("weger"))
		{
			rsa.setVue(37);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Entrez le message C"))
		{
			rsa.setC(Integer.parseInt(ra.getEntree1()));
			rsa.setVue(8);
		}
		else if(b.getText().equals("Valider") && ra.getTexte2().equals("Calculer M avec l'attaque de Simmons et Noris (ou 0 pour avoir de la solution) :"))
		{
			rsa.resultatSimmons(Integer.parseInt(ra.getEntree1()));
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo tu as récupéré le message de donald"))
		{
			rsa.setVue(1);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Pas le bon résultat"))
		{
			rsa.setVue(42);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("noris"))
		{
			rsa.setVue(42);
		}
		else if(b.getText().equals("Exercice 12: Attaque de Simmons et Noris"))
		{
			rsa.exercices(7);
		}
		else if(b.getText().equals("Exercice 13: Attaque de Pollard 3"))
		{
			rsa.exercices(8);
		}
		else if(b.getText().equals("Valider") && ra.getTexte2().equals("Calculer p et q avec l'attaque de Pollard 3 (ou 0 pour avoir de la solution) :"))
		{
			int[] retour = new int[2];
			retour[0] = Integer.parseInt(ra.getEntree1());
			retour[1] = Integer.parseInt(ra.getEntree2());
			rsa.resultatPollard(retour);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo sam à récupérer p et q"))
		{
			rsa.setVue(1);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Pas le bon résultat dsl"))
		{
			rsa.setVue(46);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("pollard3"))
		{
			rsa.setVue(46);
		}
		else if(b.getText().equals("Valider") && ra.getTexte2().equals("Calculer p et q avec l'attaque de Pollard 2 (ou 0 pour avoir de la solution) :"))
		{
			int[] retour = new int[2];
			retour[0] = Integer.parseInt(ra.getEntree1());
			retour[1] = Integer.parseInt(ra.getEntree2());
			rsa.resultatPollard2(retour);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Pas le bon résultat de pollard 2"))
		{
			rsa.setVue(50);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("pollard2"))
		{
			rsa.setVue(50);
		}
		else if(b.getText().equals("Exercice 14: Attaque de Pollard 2"))
		{
			rsa.exercices(9);
		}
		else if(b.getText().equals("Valider") && ra.getTexte3().equals("Calculer M avec ElGamal :"))
		{
			try {
				rsa.resultatElGamal(Integer.parseInt(ra.getEntree1()));
			}
			catch (Exception ex)
			{
				rsa.setVue(53);
			}
		}
		else if(b.getText().equals("Valider") && ra.getTexte3().equals("Déchiffrer M avec ElGamal :"))
		{
			try {
				rsa.resultatElGamalAttaque(Integer.parseInt(ra.getEntree1()));
			}
			catch (Exception ex)
			{
				rsa.setVue(84);
			}
		}
		else if(b.getText().equals("Correction") && ra.getTexte3().equals("Calculer M avec ElGamal :"))
		{
			rsa.setVue(55);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Pas le bon résultat de ElGamal"))
		{
			rsa.setVue(53);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("ElGamal"))
		{
			rsa.setVue(53);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("attaquedelgamal"))
		{
			rsa.setVue(84);
		}
		else if(b.getText().equals("Exercice 6: Decryptage de ElGamal"))
		{
			rsa.exercices(10);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo tu as trouvé M grâce a ElGamal"))
		{
			rsa.setVue(1);
		}
		else if(b.getText().equals("Valider") && ra.getTexte3().equals("Coder M avec ElGamal :"))
		{
			int[] retour = new int[2];
			try {
				retour[0] = Integer.parseInt(ra.getEntree1());
				retour[1] = Integer.parseInt(ra.getEntree2());
				rsa.resultatElGamalM(retour);
			}catch(Exception ex)
			{
				this.rsa.setVue(57);
			}
		}
		else if(b.getText().equals("Correction") && ra.getTexte3().equals("Coder M avec ElGamal :"))
		{
			rsa.setVue(60);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo tu as codé M grâce a ElGamal"))
		{
			rsa.setVue(1);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Pas le bon résultat :/"))
		{
			rsa.setVue(57);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("ElGamalM"))
		{
			rsa.setVue(57);
		}
		else if(b.getText().equals("Exercice 5: Cryptage de ElGamal"))
		{
			rsa.exercices(11);
		}
		else if(b.getText().equals("Exercice 7: Attaque de ElGamal"))
		{
			rsa.exercices(18);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo tes juste trop fort"))
		{
			rsa.setVue(1);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Tes éclatax mec"))
		{
			rsa.setVue(61);
		}
		else if(b.getText().equals("Valider") && ra.getTexte3().equals("Calculer M avec Skanks (ou 0 pour avoir de la solution) :"))
		{
			rsa.resultatAttaqueElGamal(Integer.parseInt(ra.getEntree1()));
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("ElGamalM2"))
		{
			rsa.setVue(61);
		}
		else if(b.getText().equals("Exercice 15: Attaque de ElGamal"))
		{
			rsa.exercices(12);
		}
		else if(b.getText().equals("Valider") && ra.getTexte3().equals("Le nombre est premier ? (1 = oui, 2 = non) (ou 0 pour avoir de la solution) :"))
		{
			rsa.resultatLeihmer(Integer.parseInt(ra.getEntree1()));
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("testdeprima"))
		{
			rsa.setVue(65);
		}
		else if(b.getText().equals("Exercice 16: Test de primalite"))
		{
			rsa.exercices(13);
		}
		else if(b.getText().equals("Acceder à tous les exercices ( Pas dans le programme de L3 mais peut-etre Master)"))
		{
			rsa.setVue(100);
		}
		else if(b.getText().equals("Acceder aux exercices de L3"))
		{
			rsa.setVue(9);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo le nombre est premier"))
		{
			rsa.setVue(1);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Ta raté ton 1 chance sur 2"))
		{
			rsa.setVue(65);
		}
		else if(b.getText().equals("Exercice 1: Exponentiation dichotomique"))
		{
			rsa.exercices(14);
		}
		else if(b.getText().equals("Valider") && ra.getTexte4().equals("Resultat = "))
		{
			try {
				rsa.resultatExpo(Integer.parseInt(ra.getEntree1()));
			}
			catch(Exception ex)
			{
				rsa.setVue(69);
			}
		}
		else if(b.getText().equals("Correction") && ra.getTexte4().equals("Resultat = "))
		{
			rsa.setVue(70);		
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("expodicho"))
		{
			rsa.setVue(69);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("bravo"))
		{
			rsa.quit();
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais résultat dommage"))
		{
			rsa.setVue(69);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais résultat dans le déchiffrage de M"))
		{
			rsa.setVue(84);
		}
		else if(b.getText().equals("Exercice 2: Calculer un ordre"))
		{
			rsa.exercices(15);
		}
		else if(b.getText().equals("Valider") && ra.getTexte4().equals("Ordre = "))
		{
			try {
				rsa.resultatOrdre(Integer.parseInt(ra.getEntree1()));
			}
			catch(Exception ex)
			{
				rsa.setVue(73);
			}
		}
		else if(b.getText().equals("Correction") && ra.getTexte4().equals("Ordre = "))
		{
			rsa.setVue(74);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais ordre"))
		{
			rsa.setVue(73);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("ordre"))
		{
			rsa.setVue(73);
		}
		else if(b.getText().equals("Exercice 4: Logarithmes discrets"))
		{
			rsa.exercices(16);
		}
		else if(b.getText().equals("Exercice 8: Diffie-Hellman"))
		{
			rsa.exercices(19);
		}
		else if(b.getText().equals("Valider") && ra.getTexte2().equals("Logdis"))
		{
			rsa.resultatLoga(ra.getText());
		}
		else if(b.getText().equals("Correction") && ra.getTexte2().equals("Logdis"))
		{
			rsa.setVue(78);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais logarithmes discrets"))
		{
			rsa.setVue(77);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("logdiscret"))
		{
			rsa.setVue(77);
		}
		else if(b.getText().equals("Exercice 3: Trouver des racines primitives"))
		{
			rsa.exercices(17);
		}
		else if(b.getText().equals("Valider") && ra.getTexte3().equals("RacinePrim"))
		{
			rsa.resultatRacPrim(ra.getText());
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("diffiehellman"))
		{
			rsa.setVue(87);
		}
		else if(b.getText().equals("Valider") && ra.getTexte2().equals("Calculer le message à envoyer à Bob"))
		{
			try {
				int[] retour = new int[2];
				retour[0] = Integer.parseInt(ra.getEntree1());
				retour[1] = Integer.parseInt(ra.getEntree2());
				rsa.resultatDiffieHellman(retour);
			}
			catch(Exception ex)
			{
				rsa.setVue(87);
			}
		}
		else if(b.getText().equals("Correction") && ra.getTexte3().equals("RacinePrim"))
		{
			rsa.setVue(83);
		}
		else if(b.getText().equals("Correction") && ra.getTexte().equals("attaquedelgamal"))
		{
			rsa.setVue(84);
		}
		else if(b.getText().equals("Correction") && ra.getTexte3().equals("Déchiffrer M avec ElGamal :"))
		{
			rsa.setVue(86);
		}
		else if(b.getText().equals("Correction") && ra.getTexte2().equals("Calculer le message à envoyer à Bob"))
		{
			rsa.setVue(89);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Mauvais résultat de racine primitive"))
		{
			rsa.setVue(81);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("Ce n'est pas le bon resultat"))
		{
			rsa.setVue(87);
		}
		else if(b.getText().equals("Valider") && ra.getTexte().equals("racineprimitive"))
		{
			rsa.setVue(81);
		}
	}

}
