package core;

import crazyimage.VueStatique;
import crazyimage.VueTranslation;
import crazyimage.VueZoom;
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
Nom du fichier : Run.java
Date créée :       2012-11-16
Date dern. modif. : 2012-11-16

*******************************************************
Historique des modifications
*******************************************************
* 2012-11-18 : Création de la classe
********************************************************/

/**
 * 
 * Class Run 
 * Permet de lancer l'application.
 *
 */
public class Run {

	/* Lancer l'exécution de l'application. */
	public static void main(String[] args) {
		
		VueStatique.lancer();
		VueZoom.lancer();
		VueTranslation.lancer();
	}
}
