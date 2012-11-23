package crazyimage;
/******************************************************
 Cours :             LOG-121
 Session :           Automne 2012
 Groupe :            4
 Projet :            Laboratoire #2
Étudiant(e)(s) : 	Philippe Charbonneau
				 	Patrice Robitaille
				 	Mathieu Battah
 Code(s) perm. :    CHAP07110906
                    ROBP2002805 
                    BATM19038902 
 Professeur :        Groucho Marx
 Date créée :        2002-05-28
 Date dern. modif. : 2012-10-11
 
*******************************************************
 Historique des modifications
*******************************************************
  2002-05-28	Cris Fuhrman : Version initiale
  
  2004-03-07	Cris Fuhrman : Intégration de SwingWorker 
                requierant la classe additionnelle 
                SwingWorker.java, utilisation des variables 
                constantes, formatage de code source, 
                organisation des imports, etc.

  2005-05-01	Cris Fuhrman : Intégration de ApplicationSupport
  				requierant la classe additionnelle
  				ApplicationSupport.java et les fichiers
  				prefs.properties, app_xx.properties (où xx est le
  				code de la langue, p. ex. fr = français, en = anglais).
  				Suppression de l'interface Shape.
  				
  2006-05-03	Sébastien Adam :
  
                Uniformisation et maintenance du code.

                Ajout des classes pour la gestion des
                items de menu. Un écouteur ajouté pour chaque item 
                (DemarrerListener, ArreterListener, QuitterListener, 
                AProposDeListener).  
                
                La classe ApplicationSwing n'implémente plus ActionListener. 
                Elle délègue la gestion des items.
                
                Plus besion d'un "if else if" dans la methode actionPerformed pour 
                exécuter l'action associée à un item. Le code est plus
                simple à comprendre, lire et maintenir.	
                
  2012-09-21    Patrice Robitaille:
  
  				Ajout d'une fenêtre dialog qui gère le input de connexion
  				pour le serveur. Le script fait également une validation
  				à la source et récupère le nom du serveur ainsi que le numéro
  				de port à l'aide du délimiteur ':'.
  				
  				Ajout de 2 variables contenant le nom du serveur et le numéro de port
  				à valider.
  				
  2012-09-28	Mathieu Battah
  
  				Ajout de l'utilisation de GestionForme pour gérer la liste de formes.
  				
  2012-10-11	Mathieu Battah
  
  				Modification des menus pour le lab 2.
              

 La distribution originale se trouve à 
 https://cours.ele.etsmtl.ca/academique/log120/notesdecours/exemples/lab/lab1/ApplicationSwing.zip
********************************************************/

import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import core.ApplicationSupport;

public class VueTranslation extends AbstractVue {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* - Constructeur - Créer le cadre dans lequel les formes sont dessinées. */
	public VueTranslation() {
		getContentPane().add(new JScrollPane(new CustomCanvas()));
	}
	
	/* Créer le menu "Ordre". */
	protected JMenu creerMenuOperation() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(ORDRE_TITRE));
		menu.setMnemonic(ORDRE_RACC);
		
		groupeOrdre = new ButtonGroup();
		
		/* Création de JRadtioButtonMenuItem. */
		JRadioButtonMenuItem translation = new JRadioButtonMenuItem(new ListeOperations(ApplicationSupport.getResource(ORDRE_NOSEQDESC), Ordre.NOSEQDESC));
		
		
		translation.setAccelerator(KeyStroke.getKeyStroke(TANSLATION_OPTION, ORDRE_MASK));
		translation.setMnemonic(TANSLATION_OPTION);

		groupeOrdre.add(translation);
		
		menu.add(translation);

		return menu;
	}
	
	public static void lancer(){

		AbstractVue vue = new VueTranslation();
		JMenuBar barreMenu = new JMenuBar();
		barreMenu.add(vue.creerMenuFichier());
		barreMenu.add(vue.creerMenuOperation());
		barreMenu.add(vue.creerMenuAide());
		vue.setJMenuBar(barreMenu);
		Point centre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		/* Lancer l'application. */
		ApplicationSupport.launch(vue, ApplicationSupport
				.getResource("app.frame.titleTranslation"), (centre.x+(CANEVAS_LARGEUR / 2)), (centre.y - (CANEVAS_HAUTEUR / 2)), CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}
}

