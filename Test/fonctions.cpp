#include "fonctions.h"

const int SPEED1 = -100;
const int SPEED2 = -75;
const int SPEED3 = -50;
const int SPEED4 = -25;

int status = 0;

void tournerDroite()    {
        Motor.speed(MOTOR1, 2 * (SPEED1) );
        Motor.speed(MOTOR2, 1 * (SPEED1) );
        status = 0;
}

void tournerGauche()  {
        Motor.speed(MOTOR1, 1 * (SPEED1) );
        Motor.speed(MOTOR2, 2 * (SPEED1) );
        status = 1;
}

void corrigerDroite() {
  
}

void corrigerGauche() {
  
}

void enAvant()   {
        Motor.speed(MOTOR1, 1 * (SPEED1) );
        Motor.speed(MOTOR2, 1 * (SPEED1) );
        status = 2;
}

void stop()   {
        Motor.stop(MOTOR1);
        Motor.stop(MOTOR2);
        status = 3;  
}


int randomizer(int input) {
  return random(0,input);
}
