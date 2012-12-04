package core;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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
		AbstractCoreAction action = FileRedo.getInstance().removeFirst();
		action.undo();
		FileUndo.getInstance().addFirst(action);
	}
}
