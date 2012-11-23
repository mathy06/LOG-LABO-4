package modele;

import java.awt.image.BufferedImage;

public class PerspectiveModel {
	
	private static PerspectiveModel instance;
	private int positionX;
	private int positionY;
	private int heigth;
	private int width;
	private int zoomFactor;
	
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
	
	public BufferedImage getImage(){
		
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
	}
	public void zoom(int factor){
		heigth = heigth + heigth/100 * factor;
		width = width + width/100* factor;
		zoomFactor = zoomFactor + factor;
	}
	public void undo(){}
}
