package core;

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
