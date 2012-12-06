package crazyimage;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JScrollPane;

import modele.ImageModel;

import core.ApplicationSupport;

/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #4
Étudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. :  CHAP07110906
                 ROBP2002805 
                 BATM19038902 
				
Professeur : Ghizlane El boussaidi
Chargé de labo  : Alvine Boaye Belle
Nom du fichier : VueStatique.java
Date créée :       2012-12-06
Date dern. modif. : 2012-12-06

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

/**
 * Classe de l'interface graphique de la vue statique.
 */
public class VueStatique extends AbstractVue {

	private static final long serialVersionUID = -3179607321895934640L;

	/* - Constructeur - Créer le cadre dans lequel les formes sont dessinées. */
	public VueStatique() {
		getContentPane().add(new JScrollPane(new CustomCanvas()));
	}

	public static void lancer(){

		VueStatique statique = new VueStatique();
		
		JMenuBar barreMenu = new JMenuBar();
		barreMenu.add(statique.creerMenuFichier());
		barreMenu.add(statique.creerMenuAide());
		statique.setJMenuBar(barreMenu);
		//Point centre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();

		//Ajout de la vue comme observateur du modèle.
		ImageModel.getInstance().addObserver(statique);
		
		/* Lancer l'application. */
		ApplicationSupport.launch(statique, ApplicationSupport
				.getResource("app.frame.titleImage"), 0, 0, CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}


	@Override
	protected JMenu creerMenuOperation() {
		// TODO Auto-generated method stub
		return null;
	}
		
}

