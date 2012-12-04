package core;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class QuitterAction extends AbstractAction{
	
	private static final long serialVersionUID = 1L;
	protected static final String FICHIER_QUITTER = "app.frame.menus.file.exit";
	Component parent;
	
	public QuitterAction(Component comp) {
		super(ApplicationSupport.getResource(FICHIER_QUITTER));
		parent = comp;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		System.exit(0);
	}
}
