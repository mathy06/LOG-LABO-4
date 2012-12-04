package core;

import modele.PerspectiveModel;

public class ActionGestion {
	
	static FileUndo fUndo = FileUndo.getInstance();
	static FileRedo fRedo = FileRedo.getInstance();
	
	public static void addAction(AbstractCoreAction action){
		fUndo.addFirst(action);
		fRedo.clear();
	}
	
	
}
