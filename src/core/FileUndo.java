package core;

/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #4
�tudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. :  CHAP07110906
                 ROBP2002805 
                 BATM19038902 
				
Professeur : Ghizlane El boussaidi
Charg� de labo  : Alvine Boaye Belle
Nom du fichier : FileUndo.java
Date cr��e :       2012-12-06
Date dern. modif. : 2012-12-06

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

import java.util.LinkedList;

import controller.AbstractCoreAction;


/**
 * Classe contenant la liste des actions qui peuvent �tre d�faites.
 */
public class FileUndo {
	
	private static FileUndo instance;
	private LinkedList<AbstractCoreAction> actionsToUndo = new LinkedList<AbstractCoreAction>();
	
	public static FileUndo getInstance(){
		if (instance == null)
			instance = new FileUndo();
		return instance;
	}
	
	private FileUndo(){}
	
	public AbstractCoreAction removeFirst(){
		return actionsToUndo.removeFirst();
	}
	
	public void addFirst(AbstractCoreAction action){
		actionsToUndo.addFirst(action);
	}
	
	public void clear(){
		actionsToUndo.clear();
	}
	
	public boolean isEmpty(){
		return actionsToUndo.isEmpty();
	}

}
