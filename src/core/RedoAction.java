package core;

import java.awt.event.ActionEvent;

public class RedoAction {
		
	private static final long serialVersionUID = 1L;
	private static RedoAction instance;

	public static RedoAction getInstance(){
		if (instance == null)
			instance = new RedoAction();
		return instance;
	}
	
	private RedoAction(){}
	
	public void actionPerformed(ActionEvent arg0) {
		AbstractCoreAction action = FileRedo.getInstance().removeFirst();
		action.undo();
		FileUndo.getInstance().addFirst(action);
	}
}
