package modele;

import java.awt.image.BufferedImage;

import core.Memento;

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
Nom du fichier : PerspectiveModel.java
Date cr��e :       2012-12-06
Date dern. modif. : 2012-12-06

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

/**
 * Mod�le contenant les informations de la perspective de l'image.
 */
public class PerspectiveModel extends Subject implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	private static PerspectiveModel instance;
	private int positionX = 0;
	private int positionY = 0;
	private int height = -1;
	private int width = -1;
	private int zoomFactor =0;
	
	/**
	 * R�cup�re l'instance de la classe.
	 * @return l'unique instance de la classe
	 */
	public static PerspectiveModel getInstance(){
		if (instance == null)
			instance = new PerspectiveModel();
		return instance;
	}
	
	/**
	 * Constructeur par d�faut
	 */
	private PerspectiveModel(){
		positionX = ImageModel.getInstance().getPosX();
		positionY = ImageModel.getInstance().getPosY();
		height = ImageModel.getInstance().getHeigth();
		width = ImageModel.getInstance().getWidth();
	}
	
	/**
	 * Retourne la position en X.
	 * @return position X
	 */
	public int getPosX(){
		return positionX;
	}
	
	/**
	 * Retourne la position en Y.
	 * @return position Y
	 */
	public int getPosY(){
		return positionY;
	}
	
	/**
	 * Retourne la hauteur de l'image.
	 * @return hauteur
	 */
	public int getHeigth(){
		if(height == -1)
			height = ImageModel.getInstance().getHeigth();
		return height;
	}
	
	/**
	 * Retourne la largeur de l'image.
	 * @return largeur
	 */
	public int getWidth(){
		if(width == -1)
			width = ImageModel.getInstance().getWidth();
		return width;
	}
	
	/**
	 * Retourne le facteur de zoom appliqu� sur l'image.
	 * @return facteur de zoom
	 */
	public int getZoomFactor(){
		return zoomFactor;
	}
	
	/**
	 * Retourne l'image manipul�e.
	 * @return BufferedImage
	 */
	public BufferedImage getImg(){
		
		BufferedImage img = null;
		try{
			img = ImageModel.getInstance().getImg();
		}catch(Exception except){
			except.getMessage();
		}
		return img;
	}
	
	/**
	 * Modifie les position en X et Y de l'image pour la d�placer.
	 * @param posX
	 * @param posY
	 */
	public void translation(int posX, int posY){
		positionX = posX;
		positionY = posY;
		notifyObservers();
	}
	
	/**
	 * Modifie le facteur de zoom pour grossir ou r�duire l'image.
	 * @param factor
	 */
	public void zoom(int factor){
		height += height/100 * factor;
		width += width/100* factor;
		zoomFactor += factor;
		notifyObservers();
	}
	
	/**
	 * Modifie le facteur de zoom pour grossir ou r�duire l'image.
	 * @param percent
	 */
	public void percentZoom(int percent){
		height = ImageModel.getInstance().getHeigth() * percent/100;
		width  = ImageModel.getInstance().getWidth() * percent/100;
		zoomFactor = percent;
		notifyObservers();
	}
	
	/**
	 * Remet les valeur de la perspective � ses valeurs initiales.
	 */
	public void reset(){
		height = ImageModel.getInstance().getHeigth();
		width  = ImageModel.getInstance().getWidth();
		positionX = ImageModel.getInstance().getPosX();
		positionY = ImageModel.getInstance().getPosY();
		notifyObservers();
	}
	
	/*
	 * M�thode setProperties(PerspectiveModel)
	 * M�thode servant � copier les propri�t�s
	 * d'un objet Perspective model � un autre.
	 */
	public void setProperties(PerspectiveModel perspec){
		instance.height = perspec.getHeigth();
		instance.width = perspec.getWidth();
		instance.positionX = perspec.getPosX();
		instance.positionY = perspec.getPosY();
		notifyObservers();
	}
	
	public Memento getMemento(){
		return new Memento(positionX, positionY, height, width, zoomFactor);
	}
	
	public void setMemento(Memento memento){
		positionX = memento.getPositionX();
		positionY = memento.getPositionY();
		height = memento.getHeight();
		width = memento.getWidth();
		zoomFactor = memento.getZoom();
		notifyObservers();
	}
}
