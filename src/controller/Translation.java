package controller;

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
 Nom du fichier : Translation.java
 Date créée :       2012-11-21
 Date dern. modif. : 2012-11-21

 *******************************************************
 Historique des modifications
 *******************************************************
 * 2012-11-21 : Création de la classe
 ********************************************************/

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JOptionPane;

import core.FileRedo;
import core.FileUndo;

import modele.Image;
import modele.PerspectiveModel;

/**
 * 
 *Class Translation implements MouseMotionListener et MouseListener Cette
 * classe permet d'effectuer un changement de position sur une image préchargé
 */
public class Translation extends AbstractCoreAction implements
		MouseMotionListener, MouseListener, ActionListener {

	private static final long serialVersionUID = 1L;

	public Translation(String ressource) {
		super(ressource);
	}

	@Override
	public void mouseClicked(MouseEvent mouseEvent) {

		PerspectiveModel.getInstance().translation(mouseEvent.getX(),
				mouseEvent.getY());
	}

	@Override
	public void mouseEntered(MouseEvent mouseEvent) {}

	@Override
	public void mouseExited(MouseEvent mouseEvent) {}

	@Override
	public void mousePressed(MouseEvent mouseEvent) {
		setMemento();
		//Sauvegarde de l'état avant la modification.
		try {
			FileUndo.getInstance().addFirst((AbstractCoreAction) this.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		FileRedo.getInstance().clear();
	}

	@Override
	public void mouseReleased(MouseEvent mouseEvent) {}

	@Override
	public void mouseDragged(MouseEvent mouseEvent) {
		PerspectiveModel.getInstance().translation(mouseEvent.getX(),
				mouseEvent.getY());
	}

	@Override
	public void mouseMoved(MouseEvent mouseEvent) {}

	@Override
	public void executeAction() {
		try {
			Image.getInstance().getImg();
			String answer = "";
			while (!answer.contains(";")) {
				answer = JOptionPane
						.showInputDialog("Entrer la position voulu avec un \";\" entre les coordonné");
			}
			String[] coor = answer.split(";");
			//Sauvegarde de l'état avant la modification.
			FileUndo.getInstance().addFirst((AbstractCoreAction) this.clone());
			FileRedo.getInstance().clear();
			//Application de la translation à l'image.
			PerspectiveModel.getInstance().translation(Integer.parseInt(coor[0]), Integer.parseInt(coor[1]));
		} catch (NullPointerException except) {
			except.getMessage();
		} catch (NumberFormatException except) {
			JOptionPane.showMessageDialog(null,
					"Vous devez entrer un nombre entier");
		} catch (Exception except) {
			JOptionPane.showMessageDialog(null,
					"Vous devez dabord charger une image");
		}

	}
}
