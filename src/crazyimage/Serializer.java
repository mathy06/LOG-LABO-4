package crazyimage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import modele.Image;

public class Serializer {
	
	Image img;
	
	public void serialize(){
		img = Image.getInstance();
		
		try
	    {
	       FileOutputStream fileOut = new FileOutputStream("serialize/image.ser");
	       ObjectOutputStream out = new ObjectOutputStream(fileOut);
	       out.writeObject(img);
	       out.close();
	       fileOut.close();
	    }catch(IOException i){
	        i.printStackTrace();
	    }
		
	}
	
}
