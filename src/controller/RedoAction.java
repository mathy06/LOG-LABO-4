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
Nom du fichier : RedoAction.java
Date créée :       2012-11-21
Date dern. modif. : 2012-11-21

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import core.FileRedo;
import core.FileUndo;

public class RedoAction extends AbstractAction{
		
	private static final long serialVersionUID = 1L;
	private static RedoAction instance;

	public static RedoAction getInstance(){
		if (instance == null)
			instance = new RedoAction();
		return instance;
	}
	
	private RedoAction(){}
	
	public void actionPerformed(ActionEvent arg0) {
		if(!FileRedo.getInstance().isEmpty()){
			AbstractCoreAction action = FileRedo.getInstance().removeFirst();
			action.undo();
			FileUndo.getInstance().addFirst(action);
		}
	}
}
