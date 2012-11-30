
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

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.RenderingHints;

import javax.swing.ButtonGroup;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import modele.Image;
import modele.PerspectiveModel;
import controller.Zoom;

import core.ApplicationSupport;

public class VueZoom extends AbstractVue {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4829602594348697503L;

	/* - Constructeur - Créer le cadre dans lequel les formes sont dessinées. */
	public VueZoom() {
		getContentPane().add(new JScrollPane(new CustomCanvas()));
	}
	
	/**
	 *  Créer le panneau sur lequel les formes sont dessinées. 
	 */
	class CustomCanvas extends JPanel {
		private static final long serialVersionUID = 1L;

		public CustomCanvas() {
			setSize(getPreferredSize());
			setMinimumSize(getPreferredSize());
			CustomCanvas.this.addMouseWheelListener(new Zoom());
			CustomCanvas.this.setBackground(Color.white);
		}

		public Dimension getPreferredSize() {
			return new Dimension(CANEVAS_LARGEUR, CANEVAS_HAUTEUR);
		}

		public void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);
			Graphics2D g2d = (Graphics2D) graphics;
			try{//On dessine l'image
				g2d.drawImage(PerspectiveModel.getInstance().getImg(), PerspectiveModel.getInstance().getPosX(), 
							  PerspectiveModel.getInstance().getPosY(), PerspectiveModel.getInstance().getWidth(), 
							  PerspectiveModel.getInstance().getHeigth(), null);
			}catch(Exception ex){
				ex.getMessage();
			}
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);	

		}
	}

	/* Créer le menu "Ordre". */
	protected JMenu creerMenuOperation() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(ORDRE_TITRE));
		menu.setMnemonic(ZOOM_RACC);
		
		groupeOrdre = new ButtonGroup();
		
		/* Création de JRadtioButtonMenuItem. */
		JRadioButtonMenuItem zoom = new JRadioButtonMenuItem(new ListeOperations(ApplicationSupport.getResource(ORDRE_NOSEQASC), Ordre.NOSEQASC));
		
		
		/* Ajout des raccourcis spécifiques à chaque bouton radio. */
		zoom.setAccelerator(KeyStroke.getKeyStroke(ZOOM_RACC, CTRL_MASK));
		zoom.setMnemonic(ZOOM_RACC);

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

		//Ajout de la vue comme observateur du modèle.
		PerspectiveModel.getInstance().addObserver(zoom);
		Image.getInstance().addObserver(zoom);

		/* Lancer l'application. */
		ApplicationSupport.launch(zoom, ApplicationSupport
				.getResource("app.frame.titleZoom"), (centre.x - (CANEVAS_LARGEUR / 2)), (centre.y - (CANEVAS_HAUTEUR / 2)), CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}
	
	public void update(){
		repaint();
		validate();
	}
		
}

