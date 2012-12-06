package controller;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import core.FileRedo;
import core.FileUndo;

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
		if(!FileRedo.getInstance().isEmpty()){
			AbstractCoreAction action = FileRedo.getInstance().removeFirst();
			action.undo();
			FileUndo.getInstance().addFirst(action);
		}
	}
}
