
#include <Arduino.h>
#include <capteur.h>
#include "robot.h"


Robot::Robot() {
}



void Robot::tournerDroite(Capteur capteur)    {
    while(capteur.getCD() == 1 && capteur.getCDE() == 1){
		enAvant();
		capteur.refresh();
		delay(50);
	}
	while(capteur.getCDE() == 0) {
		Motor.speed(MOTOR1, SPEEDDefault);
		Motor.speed(MOTOR2, SPEED3 );
		capteur.refresh();
	}

	do{
		Motor.speed(MOTOR1, SPEEDDefault);
		Motor.speed(MOTOR2, SPEED3 );
		capteur.refresh();
	}while(capteur.getCD() == 0);

	do{
		Motor.speed(MOTOR1, SPEEDDefault);
		Motor.speed(MOTOR2, SPEED3 );
		capteur.refresh();
	}while(capteur.getCG() ==0);
}

void Robot::tournerGauche(Capteur capteur)  {
    while(capteur.getCG()== 1 && capteur.getCGE() == 1){
		enAvant();
		capteur.refresh();
		delay(50);
	}
	while(capteur.getCGE() == 0){
		Motor.speed(MOTOR1, SPEED3);
		Motor.speed(MOTOR2, SPEEDDefault );
		capteur.refresh();
	}

	do{
		Motor.speed(MOTOR1, SPEED3);
		Motor.speed(MOTOR2, SPEEDDefault );
		capteur.refresh();
	}while(capteur.getCG() == 0);

	do{
		Motor.speed(MOTOR1, SPEED3);
		Motor.speed(MOTOR2, SPEEDDefault );
		capteur.refresh();
	}while(capteur.getCD() ==0);
}

void Robot::corrigerDroite() {
        Motor.speed(MOTOR1, SPEEDDefault );
        Motor.speed(MOTOR2, SPEED3 );
		delay(50);
}

void Robot::corrigerGauche() {
        Motor.speed(MOTOR1, SPEED3 );
        Motor.speed(MOTOR2, SPEEDDefault );
		delay(50);
}

void Robot::enAvant()   {
        Motor.speed(MOTOR1, SPEEDDefault );
        Motor.speed(MOTOR2, SPEEDDefault );
        status = 2;
}

void Robot::stop()   {
        Motor.stop(MOTOR1);
        Motor.stop(MOTOR2);
        status = 3;  
}

int Robot::randomizer(int input){
    return random(0, input-1);
}
