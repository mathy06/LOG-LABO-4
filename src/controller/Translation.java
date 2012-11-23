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

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import modele.PerspectiveModel;

/**
 * 
 *Class Translation implements MouseMotionListener et MouseListener
 *Cette classe permet d'effectuer un changement de position sur 
 *une image préchargé
 */
public class Translation implements MouseMotionListener, MouseListener{

		//TODO : Doit changer l'appel à repaint pour qu'il appel l'observer
		@Override
		public void mouseClicked(MouseEvent mouseEvent) {
			
			PerspectiveModel.getInstance().translation(mouseEvent.getX(), mouseEvent.getY());
			mouseEvent.getComponent().repaint();
		}
		@Override
		public void mouseEntered(MouseEvent mouseEvent) {}
		@Override
		public void mouseExited(MouseEvent mouseEvent) {}
		@Override
		public void mousePressed(MouseEvent mouseEvent) {
			PerspectiveModel.getInstance().translation(mouseEvent.getX(), mouseEvent.getY());
			mouseEvent.getComponent().repaint();
		}
		@Override
		public void mouseReleased(MouseEvent mouseEvent) {
			PerspectiveModel.getInstance().translation(mouseEvent.getX(), mouseEvent.getY());
			mouseEvent.getComponent().repaint();	
		}
		
		@Override
		public void mouseDragged(MouseEvent mouseEvent) {
			PerspectiveModel.getInstance().translation(mouseEvent.getX(), mouseEvent.getY());
			mouseEvent.getComponent().repaint();
		}
		@Override
		public void mouseMoved(MouseEvent mouseEvent) {}
}
