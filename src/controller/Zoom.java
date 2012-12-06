package controller;
/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #4
Étudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. :  CHAP07110906
                 ROBP2002805 
                 BATM19038902 
				
Professeur : Ghizlane El boussaidi
Chargé de labo  : Alvine Boaye Belle
Nom du fichier : Zoom.java
Date créée :       2012-11-21
Date dern. modif. : 2012-11-21

*******************************************************
Historique des modifications
*******************************************************
* 21-11-2012 : Création de la classe
* 			   implémentation du listener MouseWhell
********************************************************/

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JOptionPane;

import core.FileRedo;
import core.FileUndo;

import modele.Image;
import modele.PerspectiveModel;

/**
 * Class Zoom implements MouseWhellListener
 * Classe permettant d'effectuer des opérations
 * de zoom sur une image préchargé
 */
public class Zoom extends AbstractCoreAction implements MouseWheelListener{

	private static final long serialVersionUID = 1L;

	public Zoom(String ressource) {
		super(ressource);
	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent whellEvent) {
		setMemento();
		//Sauvegarde de l'état avant la modification.
		try {
			FileUndo.getInstance().addFirst((AbstractCoreAction) this.clone());
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		FileRedo.getInstance().clear();
		PerspectiveModel.getInstance().zoom(-whellEvent.getUnitsToScroll());
	}

	@Override
	public void executeAction() {
		try{
			Image.getInstance().getImg();
			String answer = "";
			answer = JOptionPane.showInputDialog("Entrer la valeur de zoom en pourcentage.");
			//Sauvegarde de l'état avant la modification.
			FileUndo.getInstance().addFirst((AbstractCoreAction) this.clone());
			FileRedo.getInstance().clear();
			//Application du zoom à l'image.
			PerspectiveModel.getInstance().percentZoom(Integer.parseInt(answer));
		}catch(NullPointerException except){
			except.getMessage();
		}catch(NumberFormatException except){
			JOptionPane.showMessageDialog(null, "Vous devez entrer un nombre entier");
		} catch (Exception except) {
			JOptionPane.showMessageDialog(null, "Vous devez dabord charger une image");
		}
	}
}
