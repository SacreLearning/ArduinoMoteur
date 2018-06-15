
#ifndef robot_h
#define robot_h

#include <Arduino.h>
#include <Grove_I2C_Motor_Driver.h>

class Robot {

private :

	//set values of speed
	const int SPEED1 = 25;
	const int SPEED2 = 50;
	const int SPEED3 = 100;
	const int SPEEDDefault = -70;
	
	int status = 0;

public :

	//constructor
	Robot(); 

	// Fonction pour tourner à droite
	void tournerDroite(Capteur capteur); 

	// Fonction de correction droite
	void corrigerDroite();

	// Fonction pour tourner à Gauche
	void tournerGauche(Capteur capteur);

	// Fonction de correction gauche
	void corrigerGauche();

	// Fonction pour aller tout droit 
	void enAvant();
	
	// Fonction pour s'arrêter 
	void stop(); 

	// Fonction d'aléatoire
	int randomizer(int input);
};

#endif