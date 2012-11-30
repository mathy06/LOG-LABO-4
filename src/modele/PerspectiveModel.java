package modele;

import java.awt.image.BufferedImage;

public class PerspectiveModel extends Subject implements java.io.Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static PerspectiveModel instance;
	private int positionX = 0;
	private int positionY = 0;
	private int heigth = 0;
	private int width = 0;
	private int zoomFactor =0;
	
	public static PerspectiveModel getInstance(){
		if (instance == null)
			instance = new PerspectiveModel();
		return instance;
	}
	
	private PerspectiveModel(){
		positionX = Image.getInstance().getPosX();
		positionY = Image.getInstance().getPosY();
		heigth = Image.getInstance().getHeigth();
		width = Image.getInstance().getWidth();
	}
	
	public int getPosX(){
		return positionX;
	}
	public int getPosY(){
		return positionY;
	}
	public int getHeigth(){
		return heigth;
	}
	public int getWidth(){
		return width;
	}
	public int getZoomFactor(){
		return zoomFactor;
	}
	
	public BufferedImage getImg(){
		
		BufferedImage img = null;
		try{
			img = Image.getInstance().getImg();
		}catch(Exception except){
			except.getMessage();
		}
		return img;
	}
	
	public void translation(int posX, int posY){
		positionX = posX;
		positionY = posY;
		notifyObservers();
	}
	public void zoom(int factor){
		heigth += heigth/100 * factor;
		width += width/100* factor;
		zoomFactor += factor;
		notifyObservers();
	}
	public void undo(){}
	
	/*
	 * Méthode setProperties(PerspectiveModel)
	 * Méthode servant à copier les propriétés
	 * d'un objet Perspective model à un autre.
	 */
	public void setProperties(PerspectiveModel perspec){
		instance.heigth = perspec.getHeigth();
		instance.width = perspec.getWidth();
		instance.positionX = perspec.getPosX();
		instance.positionY = perspec.getPosY();
		notifyObservers();
	}
}
