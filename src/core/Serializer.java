package core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import modele.PerspectiveModel;

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
Nom du fichier : Serializer.java
Date créée :       2012-12-06
Date dern. modif. : 2012-12-06

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

/**
 * Classe permettant de sauvegarder une perspective dans un fichier et de lire un fichier d'une perspective.
 */
public class Serializer {
	
	PerspectiveModel perspec;
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
		perspec = PerspectiveModel.getInstance();
		
		try
	    {
	       FileOutputStream fileOut = new FileOutputStream("serialize/"+filename+".ser");
	       ObjectOutputStream out = new ObjectOutputStream(fileOut);
	       out.writeObject(perspec);
	       out.close();
	       fileOut.close();
	    }catch(IOException i){
	        i.printStackTrace();
	    }
		
	}
	
	public void deserialize(String fileName){
		perspec = null;
		
        try
        {
           FileInputStream fileIn = new FileInputStream(fileName);
           ObjectInputStream input = new ObjectInputStream(fileIn);
           perspec = (PerspectiveModel)input.readObject();
           PerspectiveModel.getInstance().setProperties(perspec);
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
