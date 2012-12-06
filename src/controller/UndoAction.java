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
Nom du fichier : UndoAction.java
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

public class UndoAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	private static UndoAction instance;

	public static UndoAction getInstance(){
		if (instance == null)
			instance = new UndoAction();
		return instance;
	}
	
	private UndoAction(){}
	
	public void actionPerformed(ActionEvent arg0) {
		if(!FileUndo.getInstance().isEmpty()){
			AbstractCoreAction action = FileUndo.getInstance().removeFirst();
			action.undo();
			FileRedo.getInstance().addFirst(action);
		}
	}

}
