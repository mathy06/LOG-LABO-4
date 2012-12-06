package modele;

import java.util.ArrayList;
import crazyimage.Observer;
/******************************************************
Cours : LOG121
Session : A2012
Groupe : 04
Projet : Laboratoire #4
�tudiant(e)(s) : Philippe Charbonneau
				 Patrice Robitaille
				 Mathieu Battah
Code(s) perm. :  CHAP07110906
                 ROBP2002805 
                 BATM19038902 
				
Professeur : Ghizlane El boussaidi
Charg� de labo  : Alvine Boaye Belle
Nom du fichier : Subject.java
Date cr��e :       2012-11-30
Date dern. modif. : 2012-11-30

*******************************************************
Historique des modifications
*******************************************************
********************************************************/

/**
 * Classe Sujet pour le patron Observateur.
 */
public class Subject {
	
	private ArrayList<Observer> observers;
	
	/**
	 * Constructeur par d�faut
	 */
	public Subject() {
		observers = new ArrayList<Observer>();
	}
	
	/**
	 * Ajoute un observateur � la liste.
	 * @param observer
	 */
	public void addObserver(Observer observer){
		observers.add(observer);
	}
	
	/**
	 * Supprime un observateur de la liste.
	 * @param observer
	 */
	public void removeObserver(Observer observer){
		observers.remove(observer);
	}
	
	/**
	 * Averti tous les observateurs de la liste de se mettre � jour.
	 */
	public void notifyObservers(){
		for(Observer observer : observers){
			observer.update();
		}
	}

}
