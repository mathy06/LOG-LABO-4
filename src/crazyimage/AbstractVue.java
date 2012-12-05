package crazyimage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import modele.Image;

import core.ApplicationSupport;
import core.EnregistrerAction;
import core.OuvrirImageAction;
import core.QuitterAction;
import core.RedoAction;
import core.Restore;
import core.UndoAction;

public abstract class AbstractVue extends JFrame implements Observer {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3153296834953213565L;

	protected static final int CANEVAS_HAUTEUR = 500;

	protected static final int CANEVAS_LARGEUR = 500;

	protected static final int MARGE_H = 50;

	protected static final int MARGE_V = 60;
	
	
	protected static final int CTRL_MASK = ActionEvent.CTRL_MASK;
	
	protected static final char FICHIER_RACC = KeyEvent.VK_F;
	protected static final char FORME_RACC = KeyEvent.VK_O;
	protected static final char SAVE_RACC = KeyEvent.VK_S;
	protected static final char RESTORE_RACC = KeyEvent.VK_R;
	protected static final char UNDO_RACC = KeyEvent.VK_Z;
	protected static final char REDO_RACC = KeyEvent.VK_Y;
	protected static final char TANSLATION_RACC = KeyEvent.VK_T;
	protected static final char QUITTER_RACC = KeyEvent.VK_Q;
	protected static final char AIDE_RACC = KeyEvent.VK_A;
	protected static final char PROPOS_RACC = KeyEvent.VK_P;
	protected static final char ZOOM_RACC = KeyEvent.VK_N;

	protected static final String
			FICHIER_TITRE = "app.frame.menus.file.title",
			FICHIER_RESTORE = "app.frame.menus.file.restore",
			FICHIER_UNDO = "app.frame.menus.file.undo",
			FICHIER_REDO = "app.frame.menus.file.redo",
			ORDRE_TITRE = "app.frame.menus.order.title",
			ORDRE_NOSEQASC = "app.frame.menus.order.nosequenceascending",
			ORDRE_NOSEQDESC = "app.frame.menus.order.nosequencedescending",
			AIDE_TITRE = "app.frame.menus.help.title",
			AIDE_PROPOS = "app.frame.menus.help.about";
	
	protected static final String DIALOGUE_A_PROPOS = "app.frame.dialog.about";
		
	protected ButtonGroup groupeOrdre;
	
	protected enum Ordre {NOSEQASC, NOSEQDESC};
	

	/**
	 * Traiter les items du menu "Ordre".
	 */
	class SecondaryMenu extends AbstractAction{
		private static final long serialVersionUID = 1L;
		
		public SecondaryMenu(String menuItemTitle){
			super(menuItemTitle);
		}
		
		public void actionPerformed(ActionEvent arg0){
			//On rafraichit l'�cran
			repaint();
			validate();
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
	 *  Cr�er le panneau sur lequel les formes sont dessin�es. 
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
			try{//On dessine l'image
				g2d.drawImage(Image.getInstance().getImg(), Image.getInstance().getPosX(), 
							  Image.getInstance().getPosY(), Image.getInstance().getWidth(), 
							  Image.getInstance().getHeigth(), null);
				
			}catch(Exception ex){
				ex.getMessage();
			}
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
					RenderingHints.VALUE_ANTIALIAS_ON);	

		}
	}
	
	/* Cr�er le menu "Ordre". */
	protected abstract JMenu creerMenuOperation();

	/* Cr�er le menu "Fichier". */
	protected JMenu creerMenuFichier() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(FICHIER_TITRE));
		menu.setMnemonic(FICHIER_RACC);
		
		menu.add(new OuvrirImageAction(AbstractVue.this));
		menu.getItem(0).setAccelerator(KeyStroke.getKeyStroke(FORME_RACC, CTRL_MASK));
		menu.getItem(0).setMnemonic(FORME_RACC);
		
		menu.add(new EnregistrerAction(AbstractVue.this));
		menu.getItem(1).setAccelerator(KeyStroke.getKeyStroke(SAVE_RACC, CTRL_MASK));
		menu.getItem(1).setMnemonic(SAVE_RACC);
		
		menu.add(new Restore(AbstractVue.this));
		menu.getItem(2).setAccelerator(KeyStroke.getKeyStroke(RESTORE_RACC, CTRL_MASK));
		menu.getItem(2).setMnemonic(RESTORE_RACC);

		menu.add(UndoAction.getInstance());
		menu.getItem(3).setText(ApplicationSupport.getResource(FICHIER_UNDO));
		menu.getItem(3).setAccelerator(KeyStroke.getKeyStroke(UNDO_RACC, CTRL_MASK));
		menu.getItem(3).setMnemonic(UNDO_RACC);

		menu.add(RedoAction.getInstance());
		menu.getItem(4).setText(ApplicationSupport.getResource(FICHIER_REDO));
		menu.getItem(4).setAccelerator(KeyStroke.getKeyStroke(REDO_RACC, CTRL_MASK));
		menu.getItem(4).setMnemonic(REDO_RACC);
		
		menu.add(new QuitterAction(AbstractVue.this));
		menu.getItem(5).setAccelerator(KeyStroke.getKeyStroke(QUITTER_RACC, CTRL_MASK));
		menu.getItem(5).setMnemonic(QUITTER_RACC);

		return menu;
	}

	/* Cr�er le menu "Aide". */
	protected JMenu creerMenuAide() {
		JMenu menu = new JMenu(ApplicationSupport.getResource(AIDE_TITRE));
		menu.setMnemonic(AIDE_RACC);

		menu.add(new AProposDeAction());
		menu.getItem(0).setAccelerator(KeyStroke.getKeyStroke(PROPOS_RACC, CTRL_MASK));
		menu.getItem(0).setMnemonic(PROPOS_RACC);

		return menu;
	}
	
	public abstract void update();
	
}
