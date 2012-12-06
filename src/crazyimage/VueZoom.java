
package crazyimage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.RenderingHints;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import modele.ImageModel;
import modele.PerspectiveModel;
import controller.Zoom;

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
Nom du fichier : VueZoom.java
Date créée :       2012-12-06
Date dern. modif. : 2012-12-06

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

/**
 * Classe de l'interface graphique de la vue permettant de zoomer.
 */
public class VueZoom extends AbstractVue {
	
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
			CustomCanvas.this.addMouseWheelListener(new Zoom(ApplicationSupport.getResource(ZOOM)));
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
		JMenu menu = new JMenu(ApplicationSupport.getResource(OPERATION_TITRE));
		menu.setMnemonic(ZOOM_RACC);
		
		/* Création de JRadtioButtonMenuItem. */
		JMenuItem zoom = new JMenuItem(new SecondaryMenu(ApplicationSupport.getResource(ZOOM)));
		
		
		/* Ajout des raccourcis spécifiques à chaque bouton radio. */
		zoom.addActionListener(new Zoom(ApplicationSupport.getResource(ZOOM)));
		zoom.setAccelerator(KeyStroke.getKeyStroke(ZOOM_RACC, CTRL_MASK));
		zoom.setMnemonic(ZOOM_RACC);

		
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
		ImageModel.getInstance().addObserver(zoom);

		/* Lancer l'application. */
		ApplicationSupport.launch(zoom, ApplicationSupport
				.getResource("app.frame.titleZoom"), (centre.x - (CANEVAS_LARGEUR / 2)), (centre.y - (CANEVAS_HAUTEUR / 2)), CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}
		
}

