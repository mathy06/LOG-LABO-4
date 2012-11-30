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


/**
 * 
 * Class ImageFileChooser
 * Permet d'instancier un JFilechooser
 *qui lui permet de récupérer un fichier
 *sur le disque et de le stocker dans un objet
 *
 */
public class FileChooser {
	
	private JFileChooser fileChoose = new JFileChooser();
	private String fileName;
	
	public FileChooser(FileFilter filtre){
		
		fileChoose.setLocale(Locale.getDefault());
		fileChoose.updateUI();
		fileChoose.setCurrentDirectory(new File("./image"));
		fileChoose.setDialogTitle("Choix du fichier");
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
			fileName = fileChoose.getSelectedFile().getName();
		}
		return path;
	}
	
	public String getSelectedFileName(Component parent){
		return fileName;
	}
}
