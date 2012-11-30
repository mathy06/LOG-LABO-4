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
import controller.Translation;

import core.ApplicationSupport;

public class VueTranslation extends AbstractVue{


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/* - Constructeur - Cr�er le cadre dans lequel les formes sont dessin�es. */
	public VueTranslation() {
		getContentPane().add(new JScrollPane(new CustomCanvas()));
	}
	
	/**
	 *  Cr�er le panneau sur lequel les formes sont dessin�es. 
	 */
	class CustomCanvas extends JPanel {
		private static final long serialVersionUID = 1L;

		public CustomCanvas() {
			setSize(getPreferredSize());
			setMinimumSize(getPreferredSize());
			
			CustomCanvas.this.addMouseListener(new Translation());
			CustomCanvas.this.addMouseMotionListener(new Translation());
			CustomCanvas.this.setBackground(Color.white);
		}

		public Dimension getPreferredSize() {
			return new Dimension(CANEVAS_LARGEUR, CANEVAS_HAUTEUR);
		}

		public void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);
			Graphics2D g2d = (Graphics2D) graphics;
			try{//On dessine l'image
				g2d.drawImage(PerspectiveModel.getInstance().getImg(), PerspectiveModel.getInstance().getPosX(), PerspectiveModel.getInstance().getPosY(), PerspectiveModel.getInstance().getHeigth(), PerspectiveModel.getInstance().getWidth(), null);
			}catch(Exception ex){
				ex.getMessage();
			}
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);	

		}
	}
	
	/* Cr�er le menu "Ordre". */
	protected JMenu creerMenuOperation() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(ORDRE_TITRE));
		menu.setMnemonic(TANSLATION_RACC);
		
		groupeOrdre = new ButtonGroup();
		
		/* Cr�ation de JRadtioButtonMenuItem. */
		JRadioButtonMenuItem translation = new JRadioButtonMenuItem(new ListeOperations(ApplicationSupport.getResource(ORDRE_NOSEQDESC), Ordre.NOSEQDESC));
		
		
		translation.setAccelerator(KeyStroke.getKeyStroke(TANSLATION_RACC, CTRL_MASK));
		translation.setMnemonic(TANSLATION_RACC);

		groupeOrdre.add(translation);
		
		menu.add(translation);

		return menu;
	}
	
	public static void lancer(){

		AbstractVue translation = new VueTranslation();
		JMenuBar barreMenu = new JMenuBar();
		barreMenu.add(translation.creerMenuFichier());
		barreMenu.add(translation.creerMenuOperation());
		barreMenu.add(translation.creerMenuAide());
		translation.setJMenuBar(barreMenu);
		Point centre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		
		//Ajout de la vue comme observateur du mod�le.
		PerspectiveModel.getInstance().addObserver(translation);
		Image.getInstance().addObserver(translation);
		
		/* Lancer l'application. */
		ApplicationSupport.launch(translation, ApplicationSupport
				.getResource("app.frame.titleTranslation"), (centre.x+(CANEVAS_LARGEUR / 2)), (centre.y - (CANEVAS_HAUTEUR / 2)), CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}
	
	public void update() {
		repaint();
		validate();
	}
}

