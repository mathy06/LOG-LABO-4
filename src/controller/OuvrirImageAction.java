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
Nom du fichier : OuvrirImageAction.java
Date créée :       2012-11-21
Date dern. modif. : 2012-11-21

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

import java.awt.Component;
import java.io.IOException;

import javax.swing.filechooser.FileNameExtensionFilter;

import modele.ImageModel;
import core.ApplicationSupport;
import core.FileChooser;

public class OuvrirImageAction extends AbstractCoreAction {
	
	private static final long serialVersionUID = 1L;
	protected static final String FICHIER_FORME = "app.frame.menus.file.getshape";
	Component parent;
	
	public OuvrirImageAction(Component comp) {
		super(ApplicationSupport.getResource(FICHIER_FORME));
		parent = comp;
	}

	
	@Override
	public void executeAction() {

		FileChooser fileChooser = new FileChooser(new FileNameExtensionFilter("Image", "jpg","jpeg","gif","bmp","png"));
		
		try{
			ImageModel.getInstance().setImg(fileChooser.getSelectedFile(parent));
			try {
				ImageModel.getInstance().setFilename(fileChooser.getSelectedFileName(parent));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			parent.repaint();
		}catch(IOException except){
			except.getMessage();
		}
	}
}
