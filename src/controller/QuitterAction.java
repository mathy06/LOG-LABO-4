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
Nom du fichier : QuitterAction.java
Date créée :       2012-11-21
Date dern. modif. : 2012-11-21

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

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
