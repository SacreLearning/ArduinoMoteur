#include "fonctions.h"

  //define pin
  int captorDroiteExPin    = 5;
  int captorDroitePin      = 6;
  int captorGauchePin      = 7;
  int captorGaucheExPin    = 8;

  //define values of pin
  int cDE     = -1;
  int cGE   = -1;
  int cD    = -1;
  int cG    = -1;

const int SPEED1 = 25;
const int SPEED2 = 50;
const int SPEEDDefault = -70;



int status = 0;

void tournerDroite()    {
        Motor.speed(MOTOR1, -70 );
        Motor.speed(MOTOR2, 25 );
        status = 0;
}

void tournerGauche()  {
        Motor.speed(MOTOR1, 25 );
        Motor.speed(MOTOR2, -70 );
        status = 1;
}

void corrigerDroite() {

        Motor.speed(MOTOR1, -70 );
        Motor.speed(MOTOR2, 70 );
}

void corrigerGauche() {
        Motor.speed(MOTOR1, 70 );
        Motor.speed(MOTOR2, -70 );
}

void enAvant()   {
        Motor.speed(MOTOR1, -70 );
        Motor.speed(MOTOR2, -70 );
        status = 2;
}

void stop()   {
        Motor.stop(MOTOR1);
        Motor.stop(MOTOR2);
        status = 3;  
}


int randomizer(int input){
    return random(0, input-1);
}

void refresh(){
  cDE = digitalRead(captorDroiteExPin);
  cGE = digitalRead(captorGaucheExPin);
  cD = digitalRead(captorDroitePin);
  cG = digitalRead(captorGauchePin);
}

int getCDEPin() {
  return captorDroiteExPin;
}

int getCGEPin() {
  return captorGaucheExPin;
}

int getCDPin() {
  return captorDroitePin;
}

int getCGPin() {
  return captorGauchePin;
}

int getCDE() {
  return cDE;
}

int getCGE() {
  return cGE;
}

int getCD() {
  return cD;
}

int getCG() {
  return cG;
}
