package controller;

import java.awt.Component;

import core.ApplicationSupport;

public class QuitterAction extends AbstractCoreAction{
	
	private static final long serialVersionUID = 1L;
	protected static final String FICHIER_QUITTER = "app.frame.menus.file.exit";
	Component parent;
	
	public QuitterAction(Component comp) {
		super(ApplicationSupport.getResource(FICHIER_QUITTER));
		parent = comp;
	}

	@Override
	public void executeAction() {
		System.exit(0);
	}
}
