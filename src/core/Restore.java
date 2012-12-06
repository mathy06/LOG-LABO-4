package core;

import java.awt.Component;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.FileChooser;

public class Restore extends AbstractCoreAction{

	private static final long serialVersionUID = 1L;
	
	protected static final String FICHIER_RESTORE = "app.frame.menus.file.restore";
	Component parent;
	
	public Restore(Component comp) {
		super(ApplicationSupport.getResource(FICHIER_RESTORE));
		parent = comp;
	}
	

	@Override
	public void executeAction() {
		
		FileChooser fileChooser = new FileChooser(new FileNameExtensionFilter("Serialize", "ser"));
		fileChooser.getSelectedFile(parent);
		
		try {
			String filename = fileChooser.getSelectedFile(parent);
			
			if(filename != null){
				//Sauvegarde de l'�tat avant la modification.
				FileUndo.getInstance().addFirst((AbstractCoreAction) this.clone());
				FileRedo.getInstance().clear();

				Serializer.getInstance().deserialize(filename);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
