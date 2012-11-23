package controller;
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
Nom du fichier : ImageFileChooser.java
Date créée :       2012-11-18
Date dern. modif. : 2012-11-21

*******************************************************
Historique des modifications
*******************************************************
* 2012-11-18 : Création de la classe
* 2012-11-21 : Déplacement de package.caryimage
* 			   à package.controller
********************************************************/
import java.awt.Component;
import java.io.File;
import java.util.Locale;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 * 
 * Class ImageFileChooser
 * Permet d'instancier un JFilechooser
 *qui lui permet de récupérer un fichier
 *sur le disque et de le stocker dans un objet
 *
 */
public class ImageFileChooser {
	
	private static final ImageFileChooser INSTANCE = new ImageFileChooser();
	
	
	public static ImageFileChooser getInstance(){
		return INSTANCE;
	}
	JFileChooser fileChoose = new JFileChooser();
	private ImageFileChooser(){
		
		FileFilter filtre = new FileNameExtensionFilter("Image", "jpg","jpeg","gif","bmp","png");
		fileChoose.setLocale(Locale.getDefault());
		fileChoose.updateUI();
		fileChoose.setCurrentDirectory(new File("./image"));
		fileChoose.setDialogTitle("Choix de l'image");
		fileChoose.setApproveButtonText("Charger");
		fileChoose.addChoosableFileFilter(filtre);
	}
	
	private int open(Component parent){
		return fileChoose.showOpenDialog(parent);
	}
	
	public String getSelectedFile(Component parent){
		int answer = open(parent);
		String path = "";
		if(answer == JFileChooser.APPROVE_OPTION){
			path = fileChoose.getSelectedFile().getAbsolutePath();
		}
		return path;
	}
}
