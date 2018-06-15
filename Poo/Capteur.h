
#ifndef capteur_h
#define capteur_h

#include <Arduino.h>

class Capteur {

private: 

	//define physical number of pin
	int captorDroiteExPin    = 5 ;
	int captorGaucheExPin    = 8 ;
	int captorDroitePin      = 6 ;
	int captorGauchePin      = 7 ;
	
	//creat variable for  store values of pin
	int captorDroiteEx;
	int captorGaucheEx;
	int captorGauche;
	int captorDroite;
	
	//define values of pin
	int cDE     = -1;
	int cGE   = -1;
	int cD    = -1;
	int cG    = -1;

	
public :

	//constructor
	Capteur();
	
	// Sortie de route droite
	bool rightOut();

	// Sortie de route gauche
	bool leftOut();

	// Route à droite
	bool isThereARightRoad();

	// Route à gauche 
	bool isThereALeftRoad();

	// Route à gauche et à droite
	bool areThereLeftAndRightRoad();

	// Route en face (lors d'un tournant droite)
	bool isThereAFrontRoadWhenUTurnRight();

	// Route en face (lors d'un tournant gauche)
	bool isThereAFrontRoadWhenUTurnLeft();
	
	//get the values of pin
	void refresh();

	// Getters
	int getCDEPin();
	int getCGEPin();
	int getCDPin();
	int getCGPin();
	int getCDE();
	int getCGE();
	int getCD();
	int getCG();
};

#endif