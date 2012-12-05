package core;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

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
