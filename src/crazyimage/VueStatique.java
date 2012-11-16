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
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

/**
 * <code>ApplicationSwing</code> est un exemple d'une
 * application en Java qui fournit une interface Swing, avec un simple
 * menu et un dessin.
 *
 * <h4>References</h4> 
 * <ul> 
 *
 * <li>C. Fuhrman, &quot;Notes de cours de LOG120,&quot; &Eacute;cole
 * de technologie sup&eacute;rieure, Montr&eacute;al, Qu&eacute;bec,
 * Canada, 2002
 *
 * <li>Xemacs (for generation of the initial template), <a target="_top" 
 * href="http://www.xemacs.org">www.xemacs.org</a>, 2002 
 *
 * <li><a target="_top" 
 * href="http://java.sun.com/docs/books/tutorial/uiswing/painting/overview.html">Overview
 * of Custom Painting</a>, une partie du tutoriel Java de Sun, 2002.
 *
 * <li>Java Software, <a target="_top" 
 * href="http://java.sun.com/j2se/javadoc/writingdoccomments/index.html">&quot;How
 * to Write Doc Comments for the Javadoc<sup>TM</sup> Tool,&quot;</a>
 * 2002
 *
 * </ul>
 *
 * Distribution originale &agrave; partir du 
 * <a target="_top" href="https://cours.ele.etsmtl.ca/academique/log120/">site Web</a>
 * du cours LOG120.
 * 
 * Created: Tue May 28 11:31:18 2002
 *
 * @author <a href="mailto:christopher.fuhrman@etsmtl.ca">Christopher Fuhrman</a>
 *
 * @version 1.1
 */

public class VueStatique extends JFrame {

	private static final int CANEVAS_HAUTEUR = 500;

	private static final int CANEVAS_LARGEUR = 500;

	private static final int MARGE_H = 50;

	private static final int MARGE_V = 60;
	
	private static final char FICHIER_RACC = KeyEvent.VK_F;
	private static final int FORME_MASK = ActionEvent.CTRL_MASK;
	private static final char FORME_RACC = KeyEvent.VK_O;
	private static final int QUITTER_MASK = ActionEvent.CTRL_MASK;
	private static final char QUITTER_RACC = KeyEvent.VK_Q;
	private static final char AIDE_RACC = KeyEvent.VK_A;
	private static final int PROPOS_MASK = ActionEvent.CTRL_MASK;
	private static final char PROPOS_RACC = KeyEvent.VK_P;

	private static final String
			FICHIER_TITRE = "app.frame.menus.file.title",
			FICHIER_FORME = "app.frame.menus.file.getshape",
			FICHIER_QUITTER = "app.frame.menus.file.exit",
			AIDE_TITRE = "app.frame.menus.help.title",
			AIDE_PROPOS = "app.frame.menus.help.about";

	private static final String DIALOGUE_A_PROPOS = "app.frame.dialog.about";

	private static final long serialVersionUID = 1L;
	

	
	/**
	 *  Traiter l'item "Obtenir formes".
	 */
	class OuvrirImage extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public OuvrirImage() {
			super(ApplicationSupport.getResource(FICHIER_FORME));
		}
		
		public void actionPerformed(ActionEvent arg0) {
		}
	}
	
	/**
	 *  Traiter l'item "Quitter".
	 */
	class QuitterAction extends AbstractAction {
		private static final long serialVersionUID = 1L;
		
		public QuitterAction() {
			super(ApplicationSupport.getResource(FICHIER_QUITTER));
		}
		
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
		}
	}
	
	/** 
	 * Traiter l'item "A propos". 
	 */
	class AProposDeAction extends AbstractAction {
		private static final long serialVersionUID = 1L;

		public AProposDeAction(){
			super(ApplicationSupport.getResource(AIDE_PROPOS));
		}
		
		public void actionPerformed(ActionEvent arg0) {
			JOptionPane.showMessageDialog(null, ApplicationSupport.getResource(DIALOGUE_A_PROPOS), ApplicationSupport.getResource(AIDE_PROPOS),JOptionPane.INFORMATION_MESSAGE);
		}
	}

	/**
	 *  Créer le panneau sur lequel les formes sont dessinées. 
	 */
	class CustomCanvas extends JPanel {
		private static final long serialVersionUID = 1L;

		public CustomCanvas() {
			setSize(getPreferredSize());
			setMinimumSize(getPreferredSize());
			CustomCanvas.this.setBackground(Color.white);
		}

		public Dimension getPreferredSize() {
			return new Dimension(CANEVAS_LARGEUR, CANEVAS_HAUTEUR);
		}

		public void paintComponent(Graphics graphics) {
			super.paintComponent(graphics);
			Graphics2D g2d = (Graphics2D) graphics;
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);

			
		}
	}
	
	/* - Constructeur - Créer le cadre dans lequel les formes sont dessinées. */
	public VueStatique() {
		getContentPane().add(new JScrollPane(new CustomCanvas()));
	}

	/* Créer le menu "Fichier". */
	private JMenu creerMenuFichier() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(FICHIER_TITRE));
		menu.setMnemonic(FICHIER_RACC);
		
		menu.add(new OuvrirImage());
		menu.getItem(0).setAccelerator(KeyStroke.getKeyStroke(FORME_RACC, FORME_MASK));
		menu.getItem(0).setMnemonic(FORME_RACC);
		
		menu.add(new QuitterAction());
		menu.getItem(1).setAccelerator(KeyStroke.getKeyStroke(QUITTER_RACC, QUITTER_MASK));
		menu.getItem(1).setMnemonic(QUITTER_RACC);

		return menu;
	}

	/* Créer le menu "Aide". */
	private JMenu creerMenuAide() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(AIDE_TITRE));
		menu.setMnemonic(AIDE_RACC);

		menu.add(new AProposDeAction());
		menu.getItem(0).setAccelerator(KeyStroke.getKeyStroke(PROPOS_RACC, PROPOS_MASK));
		menu.getItem(0).setMnemonic(PROPOS_RACC);

		return menu;
	}
	
	public static void lancer(){

		VueStatique image = new VueStatique();
		
		JMenuBar barreMenu = new JMenuBar();
		barreMenu.add(image.creerMenuFichier());
		barreMenu.add(image.creerMenuAide());
		image.setJMenuBar(barreMenu);
		//Point centre = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
		/* Lancer l'application. */
		ApplicationSupport.launch(image, ApplicationSupport
				.getResource("app.frame.title"), 0, 0, CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}
		
}

