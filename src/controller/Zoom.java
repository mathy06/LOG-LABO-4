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

import modele.PerspectiveModel;

/**
 * Class Zoom implements MouseWhellListener
 * Classe permettant d'effectuer des op�rations
 * de zoom sur une image pr�charg�
 */
public class Zoom implements MouseWheelListener{

	//TODO : Doit changer l'appel � repaint pour qu'il appel l'observer
	@Override
	public void mouseWheelMoved(MouseWheelEvent whellEvent) {
		PerspectiveModel.getInstance().zoom(-whellEvent.getUnitsToScroll());
		whellEvent.getComponent().repaint();
	}
}
