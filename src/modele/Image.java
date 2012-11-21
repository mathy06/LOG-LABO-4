package modele;
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
Nom du fichier : Image.java
Date créée :       2012-11-19
Date dern. modif. : 2012-11-20

*******************************************************
Historique des modifications
*******************************************************
* 2012-11-19 : Création de la classe
* 2012-11-20 : ajout des méthodes get,set : width,height
********************************************************/

import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;

/**
 * 
 * Class Image
 * Classe représentant une image
 * sur laquelle il est possible d'efefctuer
 * des opérations de changement.
 *
 */
public class Image {
	
	private static Image instance;
	int posX =0; //Position en X de l'image
	int posY =0; //Position en Y de l'image
	int width = 500;
	int heigth =500;
	BufferedImage bufferImg = null;
	
	
	private Image(){}
	
	/**
	 * Retourne l'instance de l'image
	 * @return
	 */
	public static Image getInstance(){
		if (instance == null)
			instance = new Image();
		return instance;
	}
	
	public void setPosX(int newX){
		posX = newX;
	}
	
	public void setPosY(int newY){
		posY = newY;
	}
	
	public int getPosX(){
		return posX;
	}
	
	public int getPosY(){
		return posY;
	}
	
	public void setWidth(int newWidth){
		width = newWidth;
	}
	public void setHeigth(int newHeigth){
		heigth = newHeigth;
	}
	
	public int getWidth(){
		return width;
	}
	public int getHeigth(){
		return heigth;
	}
	
	
	
	/**
	 * Prend un path et load l'image relié au path;
	 * @param path
	 * @throws IOException 
	 */
	public void setImg(String path) throws IOException{
		
		try{
			bufferImg = ImageIO.read(new File(path));
			setHeigth(bufferImg.getHeight());
			setWidth(bufferImg.getWidth());
		}catch(IOException except){
			throw except;
		}
	}
	
	/**
	 * Recevoir l'image lue
	 * @return
	 * @throws Exception
	 */
	public BufferedImage getImg() throws Exception{

		if(bufferImg != null){
			return bufferImg;
		}
		else
			throw new Exception("must load an image before");
	}
	
	
}
