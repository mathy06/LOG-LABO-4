
package crazyimage;
/******************************************************
 Cours :             LOG-121
 Session :           Automne 2012
 Groupe :            4
 Projet :            Laboratoire #2
�tudiant(e)(s) : 	Philippe Charbonneau
				 	Patrice Robitaille
				 	Mathieu Battah
 Code(s) perm. :    CHAP07110906
                    ROBP2002805 
                    BATM19038902 
 Professeur :        Groucho Marx
 Date cr��e :        2002-05-28
 Date dern. modif. : 2012-10-11
 
*******************************************************
 Historique des modifications
*******************************************************
  2002-05-28	Cris Fuhrman : Version initiale
  
  2004-03-07	Cris Fuhrman : Int�gration de SwingWorker 
                requierant la classe additionnelle 
                SwingWorker.java, utilisation des variables 
                constantes, formatage de code source, 
                organisation des imports, etc.

  2005-05-01	Cris Fuhrman : Int�gration de ApplicationSupport
  				requierant la classe additionnelle
  				ApplicationSupport.java et les fichiers
  				prefs.properties, app_xx.properties (o� xx est le
  				code de la langue, p. ex. fr = fran�ais, en = anglais).
  				Suppression de l'interface Shape.
  				
  2006-05-03	S�bastien Adam :
  
                Uniformisation et maintenance du code.

                Ajout des classes pour la gestion des
                items de menu. Un �couteur ajout� pour chaque item 
                (DemarrerListener, ArreterListener, QuitterListener, 
                AProposDeListener).  
                
                La classe ApplicationSwing n'impl�mente plus ActionListener. 
                Elle d�l�gue la gestion des items.
                
                Plus besion d'un "if else if" dans la methode actionPerformed pour 
                ex�cuter l'action associ�e � un item. Le code est plus
                simple � comprendre, lire et maintenir.	
                
  2012-09-21    Patrice Robitaille:
  
  				Ajout d'une fen�tre dialog qui g�re le input de connexion
  				pour le serveur. Le script fait �galement une validation
  				� la source et r�cup�re le nom du serveur ainsi que le num�ro
  				de port � l'aide du d�limiteur ':'.
  				
  				Ajout de 2 variables contenant le nom du serveur et le num�ro de port
  				� valider.
  				
  2012-09-28	Mathieu Battah
  
  				Ajout de l'utilisation de GestionForme pour g�rer la liste de formes.
  				
  2012-10-11	Mathieu Battah
  
  				Modification des menus pour le lab 2.
              

 La distribution originale se trouve � 
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

public class VueZoom extends AbstractVue {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4829602594348697503L;

	/* - Constructeur - Cr�er le cadre dans lequel les formes sont dessin�es. */
	public VueZoom() {
		getContentPane().add(new JScrollPane(new CustomCanvas()));
	}

	/* Cr�er le menu "Ordre". */
	protected JMenu creerMenuOperation() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(ORDRE_TITRE));
		menu.setMnemonic(ORDRE_RACC);
		
		groupeOrdre = new ButtonGroup();
		
		/* Cr�ation de JRadtioButtonMenuItem. */
		JRadioButtonMenuItem zoom = new JRadioButtonMenuItem(new ListeOperations(ApplicationSupport.getResource(ORDRE_NOSEQASC), Ordre.NOSEQASC));
		
		
		/* Ajout des raccourcis sp�cifiques � chaque bouton radio. */
		zoom.setAccelerator(KeyStroke.getKeyStroke(ZOOM_OPTION, ORDRE_MASK));
		zoom.setMnemonic(ZOOM_OPTION);

		/* Ajout des boutons radio au groupe de radio bouton. */
		groupeOrdre.add(zoom);
		
		/* Ajout des boutons radio au menu. */
		menu.add(zoom);

		return menu;
	}
	
	public static void lancer(){

		VueZoom zoom = new VueZoom();
		
		JMenuBar barreMenu = new JMenuBar();
		barreMenu.add(zoom.creerMenuFichier());
		barreMenu.add(zoom.creerMenuOperation());
		barreMenu.add(zoom.creerMenuAide());
		zoom.setJMenuBar(barreMenu);
		Point centre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		/* Lancer l'application. */
		ApplicationSupport.launch(zoom, ApplicationSupport
				.getResource("app.frame.titleZoom"), (centre.x - (CANEVAS_LARGEUR / 2)), (centre.y - (CANEVAS_HAUTEUR / 2)), CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}
		
}

