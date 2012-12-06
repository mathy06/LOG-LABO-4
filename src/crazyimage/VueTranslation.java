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
import controller.Translation;

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
Nom du fichier : VueTranslation.java
Date créée :       2012-12-06
Date dern. modif. : 2012-12-06

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

/**
 * Classe de l'interface graphique de la vue permettant de faire des translations.
 */
public class VueTranslation extends AbstractVue{

	private static final long serialVersionUID = 1L;

	/* - Constructeur - Créer le cadre dans lequel les formes sont dessinées. */
	public VueTranslation() {
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
			
			CustomCanvas.this.addMouseListener(new Translation(ApplicationSupport.getResource(TRANSLATION)));
			CustomCanvas.this.addMouseMotionListener(new Translation(ApplicationSupport.getResource(TRANSLATION)));
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
		menu.setMnemonic(TANSLATION_RACC);
		
		
		/* Création de JRadtioButtonMenuItem. */
		JMenuItem translation = new JMenuItem(new SecondaryMenu(ApplicationSupport.getResource(TRANSLATION)));
		
		translation.addActionListener(new Translation(ApplicationSupport.getResource(TRANSLATION)));
		translation.setAccelerator(KeyStroke.getKeyStroke(TANSLATION_RACC, CTRL_MASK));
		translation.setMnemonic(TANSLATION_RACC);
		
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
		
		//Ajout de la vue comme observateur du modèle.
		PerspectiveModel.getInstance().addObserver(translation);
		ImageModel.getInstance().addObserver(translation);
		
		/* Lancer l'application. */
		ApplicationSupport.launch(translation, ApplicationSupport
				.getResource("app.frame.titleTranslation"), (centre.x+(CANEVAS_LARGEUR / 2)), (centre.y - (CANEVAS_HAUTEUR / 2)), CANEVAS_LARGEUR
				+ MARGE_H, CANEVAS_HAUTEUR + MARGE_V);
	}
	
}

