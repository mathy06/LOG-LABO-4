package controller;
/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #4
�tudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. :  CHAP07110906
                 ROBP2002805 
                 BATM19038902 
				
Professeur : Ghizlane El boussaidi
Charg� de labo  : Alvine Boaye Belle
Nom du fichier : Translation.java
Date cr��e :       2012-11-21
Date dern. modif. : 2012-11-21

*******************************************************
Historique des modifications
*******************************************************
* 2012-11-21 : Cr�ation de la classe
********************************************************/

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import modele.Image;

/**
 * 
 *Class Translation implements MouseMotionListener et MouseListener
 *Cette classe permet d'effectuer un changement de position sur 
 *une image pr�charg�
 */
public class Translation implements MouseMotionListener, MouseListener{

		//TODO : Doit changer l'appel � repaint pour qu'il appel l'observer
		@Override
		public void mouseClicked(MouseEvent mouseEvent) {
			Image.getInstance().setPosX(mouseEvent.getX());
			Image.getInstance().setPosY(mouseEvent.getY());
			mouseEvent.getComponent().repaint();
		}
		@Override
		public void mouseEntered(MouseEvent mouseEvent) {}
		@Override
		public void mouseExited(MouseEvent mouseEvent) {}
		@Override
		public void mousePressed(MouseEvent mouseEvent) {
			Image.getInstance().setPosX(mouseEvent.getX());
			Image.getInstance().setPosY(mouseEvent.getY());
			mouseEvent.getComponent().repaint();
		}
		@Override
		public void mouseReleased(MouseEvent mouseEvent) {
			Image.getInstance().setPosX(mouseEvent.getX());
			Image.getInstance().setPosY(mouseEvent.getY());
			mouseEvent.getComponent().repaint();	
		}
		
		@Override
		public void mouseDragged(MouseEvent mouseEvent) {
			Image.getInstance().setPosX(mouseEvent.getX());
			Image.getInstance().setPosY(mouseEvent.getY());
			mouseEvent.getComponent().repaint();
		}
		@Override
		public void mouseMoved(MouseEvent mouseEvent) {}
}
