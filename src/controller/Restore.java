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
Nom du fichier : Restore.java
Date créée :       2012-11-21
Date dern. modif. : 2012-11-21

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

import java.awt.Component;
import javax.swing.filechooser.FileNameExtensionFilter;

import core.ApplicationSupport;
import core.FileChooser;
import core.FileRedo;
import core.FileUndo;
import core.Serializer;

public class Restore extends AbstractCoreAction{

	private static final long serialVersionUID = 1L;
	
	protected static final String FICHIER_RESTORE = "app.frame.menus.file.restore";
	Component parent;
	
	public Restore(Component comp) {
		super(ApplicationSupport.getResource(FICHIER_RESTORE));
		parent = comp;
	}
	

	@Override
	public void executeAction() {
		
		FileChooser fileChooser = new FileChooser(new FileNameExtensionFilter("Serialize", "ser"));
		fileChooser.getSelectedFile(parent);
		
		try {
			String filename = fileChooser.getSelectedFile(parent);
			
			if(filename != null){
				//Sauvegarde de l'état avant la modification.
				FileUndo.getInstance().addFirst((AbstractCoreAction) this.clone());
				FileRedo.getInstance().clear();

				Serializer.getInstance().deserialize(filename);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
