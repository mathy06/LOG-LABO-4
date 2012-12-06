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
Nom du fichier : AbstractCoreAction.java
Date créée :       2012-12-06
Date dern. modif. : 2012-12-06

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import core.Memento;
import modele.PerspectiveModel;

public abstract class AbstractCoreAction extends AbstractAction{
	
	private static final long serialVersionUID = 1L;
	private Memento memento;
	
	public AbstractCoreAction(String ressource){
		super(ressource);
	}
	
	public void undo(){
		Memento memento_redo = PerspectiveModel.getInstance().getMemento();
		PerspectiveModel.getInstance().setMemento(memento);
		memento = memento_redo;
	}
	
	public void redo(){
		Memento memento_undo = PerspectiveModel.getInstance().getMemento();
		PerspectiveModel.getInstance().setMemento(memento);
		memento = memento_undo;
	}

	public void actionPerformed(ActionEvent event) {
		setMemento();
		executeAction();
	}
	
	protected void setMemento(){
		memento = PerspectiveModel.getInstance().getMemento();
	}
	
	public abstract void executeAction();

}
