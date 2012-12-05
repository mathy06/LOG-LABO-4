package core;

import java.util.LinkedList;

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
