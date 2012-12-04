package core;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.AbstractAction;
import javax.swing.filechooser.FileNameExtensionFilter;

import modele.Image;
import controller.FileChooser;

public class OuvrirImageAction extends AbstractAction {
	
	private static final long serialVersionUID = 1L;
	protected static final String FICHIER_FORME = "app.frame.menus.file.ouvrir";
	Component parent;
	
	public OuvrirImageAction(Component comp) {
		super(ApplicationSupport.getResource(FICHIER_FORME));
		parent = comp;
	}
	
	public void actionPerformed(ActionEvent arg0) {
		
		FileChooser fileChooser = new FileChooser(new FileNameExtensionFilter("Image", "jpg","jpeg","gif","bmp","png"));
		
		try{
			Image.getInstance().setImg(fileChooser.getSelectedFile(parent));
			try {
				Image.getInstance().setFilename(fileChooser.getSelectedFileName(parent));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			parent.repaint();
		}catch(IOException except){
			except.getMessage();
		}
	}
}
