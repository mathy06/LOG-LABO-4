package crazyimage;

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
Nom du fichier : Observer.java
Date créée :       2012-11-30
Date dern. modif. : 2012-11-30

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

/**
 * Classe Interface des observateurs pour le patron Observateur.
 */
public interface Observer {
	
	/**
	 * Met à jour la vue.
	 */
	public void update();

}
