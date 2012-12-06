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
Nom du fichier : FileRedo.java
Date cr��e :       2012-12-06
Date dern. modif. : 2012-12-06

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

import java.util.LinkedList;

import controller.AbstractCoreAction;


/**
 * Classe contenant la liste des actions qui peuvent �tre refaites.
 */
public class FileRedo {
	
	private static FileRedo instance;
	private LinkedList<AbstractCoreAction> actionsToRedo = new LinkedList<AbstractCoreAction>();
	
	public static FileRedo getInstance(){
		if (instance == null)
			instance = new FileRedo();
		return instance;
	}
	
	private FileRedo(){}
	
	public AbstractCoreAction removeFirst(){
		return actionsToRedo.removeFirst();
	}
	
	public void addFirst(AbstractCoreAction action){
		actionsToRedo.addFirst(action);
	}
	
	public void clear(){
		actionsToRedo.clear();
	}
	
	public boolean isEmpty(){
		return actionsToRedo.isEmpty();
	}
}
