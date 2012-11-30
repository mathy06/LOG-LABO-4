package core;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.FileChooser;

public class Restore extends AbstractAction{

	private static final long serialVersionUID = 1L;
	
	protected static final String FICHIER_RESTORE = "app.frame.menus.file.restore";
	Component parent;
	
	public Restore(Component comp) {
		super(ApplicationSupport.getResource(FICHIER_RESTORE));
		parent = comp;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		FileChooser fileChooser = new FileChooser(new FileNameExtensionFilter("Serialize", "ser"));
		fileChooser.getSelectedFile(parent);
		
		try {
			String filename = fileChooser.getSelectedFileName(parent);
			
			if(filename != null)
				Serializer.getInstance().deserialize(filename);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
