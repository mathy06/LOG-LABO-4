package core;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

import modele.Image;

public class EnregistrerAction extends AbstractAction {
	private static final long serialVersionUID = 1L;
	protected static final String FICHIER_SAVE = "app.frame.menus.file.save";
	Component parent;
	
	public EnregistrerAction(Component comp) {
		super(ApplicationSupport.getResource(FICHIER_SAVE));
		parent = comp;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		Serializer.getInstance().serialize(Image.getInstance().getFilename());
	}
}
