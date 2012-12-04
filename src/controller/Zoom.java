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

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import javax.swing.JOptionPane;

import core.AbstractCoreAction;
import core.ActionGestion;

import modele.Image;
import modele.PerspectiveModel;

/**
 * Class Zoom implements MouseWhellListener
 * Classe permettant d'effectuer des opérations
 * de zoom sur une image préchargé
 */
public class Zoom extends AbstractCoreAction implements MouseWheelListener{

	public Zoom(String ressource) {
		super(ressource);
	}

	//TODO : Doit changer l'appel à repaint pour qu'il appel l'observer
	@Override
	public void mouseWheelMoved(MouseWheelEvent whellEvent) {
		PerspectiveModel.getInstance().zoom(-whellEvent.getUnitsToScroll());
	}

	@Override
	public void executeAction() {
		try{
			
			Image.getInstance().getImg();
			String answer = "";
			answer = JOptionPane.showInputDialog("Entrer la position voulu avec un \";\" entre les coordonné");
			ActionGestion.addAction((AbstractCoreAction) this.clone());
			PerspectiveModel.getInstance().percentZoom(Integer.parseInt(answer));
		}catch(NullPointerException except){
			except.getMessage();
		}catch(NumberFormatException except){
			JOptionPane.showMessageDialog(null, "Vous devez entrer un nombre entier");
		} catch (Exception except) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Vous devez dabord charger une image");
		}
	}
}
