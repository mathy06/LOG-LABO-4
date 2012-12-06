package core;

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
Nom du fichier : Memento.java
Date créée :       2012-12-06
Date dern. modif. : 2012-12-06

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

/**
 * Classe copie de PerspectiveModel qui permet de faire des undo et redo.
 */

public class Memento {
	
	private int positionX;
	private int positionY;
	private int height;
	private int width;
	private int zoom;
	
	public Memento(int posX, int posY, int heightValue, int widthValue, int zoomValue){
		positionX = posX;
		positionY = posY;
		height = heightValue;
		width = widthValue;
		zoom = zoomValue;
	}
	
	public int getPositionX(){
		return positionX;
	}
	
	public int getPositionY(){
		return positionY;
	}

	public int getHeight(){
		return height;
	}

	public int getWidth(){
		return width;
	}

	public int getZoom(){
		return zoom;
	}

}
