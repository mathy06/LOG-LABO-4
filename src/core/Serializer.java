package core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modele.Image;

public class Serializer {
	
	Image img;
	private static Serializer instance;
	
	private Serializer(){}
	
	/**
	 * Retourne l'instance
	 * @return
	 */
	public static Serializer getInstance(){
		if (instance == null)
			instance = new Serializer();
		return instance;
	}
	
	public void serialize(String filename){
		img = Image.getInstance();
		
		try
	    {
	       FileOutputStream fileOut = new FileOutputStream("serialize/"+filename+".ser");
	       ObjectOutputStream out = new ObjectOutputStream(fileOut);
	       out.writeObject(img);
	       out.close();
	       fileOut.close();
	    }catch(IOException i){
	        i.printStackTrace();
	    }
		
	}
	
	public void deserialize(){
		img = null;
		
        try
        {
           FileInputStream fileIn = new FileInputStream("serialize/image.ser");
           ObjectInputStream input = new ObjectInputStream(fileIn);
           img = (Image)input.readObject();
           input.close();
           fileIn.close();
       }catch(IOException i){
           i.printStackTrace();
           return;
       }catch(ClassNotFoundException c){
           c.printStackTrace();
           return;
       }
	}
	
}
