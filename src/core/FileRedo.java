package core;

import java.util.LinkedList;

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
