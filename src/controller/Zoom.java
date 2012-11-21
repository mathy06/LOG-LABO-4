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
Nom du fichier : Zoom.java
Date cr��e :       2012-11-21
Date dern. modif. : 2012-11-21

*******************************************************
Historique des modifications
*******************************************************
* 21-11-2012 : Cr�ation de la classe
* 			   impl�mentation du listener MouseWhell
********************************************************/

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import modele.Image;

/**
 * Class Zoom implements MouseWhellListener
 * Classe permettant d'effectuer des op�rations
 * de zoom sur une image pr�charg�
 */
public class Zoom implements MouseWheelListener{

	//TODO : Doit changer l'appel � repaint pour qu'il appel l'observer
	//TODO : l'algorithme ne marche pas dutout
	@Override
	public void mouseWheelMoved(MouseWheelEvent whellEvent) {
		Image.getInstance().setHeigth(Image.getInstance().getHeigth()*whellEvent.getUnitsToScroll()/100);
		Image.getInstance().setWidth(Image.getInstance().getWidth()*whellEvent.getUnitsToScroll()/100);
		Image.getInstance().setPosX(Image.getInstance().getPosX());
		Image.getInstance().setPosY(Image.getInstance().getPosY());
		whellEvent.getComponent().repaint();
	}
}
