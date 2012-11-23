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
Nom du fichier : Zoom.java
Date créée :       2012-11-21
Date dern. modif. : 2012-11-21

*******************************************************
Historique des modifications
*******************************************************
* 21-11-2012 : Création de la classe
* 			   implémentation du listener MouseWhell
********************************************************/

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import modele.PerspectiveModel;

/**
 * Class Zoom implements MouseWhellListener
 * Classe permettant d'effectuer des opérations
 * de zoom sur une image préchargé
 */
public class Zoom implements MouseWheelListener{

	//TODO : Doit changer l'appel à repaint pour qu'il appel l'observer
	@Override
	public void mouseWheelMoved(MouseWheelEvent whellEvent) {
		PerspectiveModel.getInstance().zoom(-whellEvent.getUnitsToScroll());
		whellEvent.getComponent().repaint();
	}
}
