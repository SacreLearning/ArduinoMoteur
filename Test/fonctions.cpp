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
const int SPEED3 = 100;
const int SPEEDDefault = -70;



int status = 0;

void tournerDroite()  {
  while(getCD() == 1 && getCDE() == 1){
    enAvant();
    refresh();
    delay(50);
  }
  while(getCDE() == 0) {
      Motor.speed(MOTOR1, SPEEDDefault);
      Motor.speed(MOTOR2, SPEED3 );
    refresh();
  }

  do{
      Motor.speed(MOTOR1, SPEEDDefault);
      Motor.speed(MOTOR2, SPEED3 );
    refresh();
  }while(getCD() == 0);

  do{
      Motor.speed(MOTOR1, SPEEDDefault);
      Motor.speed(MOTOR2, SPEED3 );
    refresh();
  }while(getCG() ==0);
}

void tournerGauche()  {
  while(getCG()== 1 && getCGE() == 1){
    enAvant();
    refresh();
    delay(50);
  }
  while(getCGE() == 0){
      Motor.speed(MOTOR1, SPEED3);
      Motor.speed(MOTOR2, SPEEDDefault );
    refresh();
  }

  do{
      Motor.speed(MOTOR1, SPEED3);
      Motor.speed(MOTOR2, SPEEDDefault );
    refresh();
  }while(getCG() == 0);

  do{
      Motor.speed(MOTOR1, SPEED3);
      Motor.speed(MOTOR2, SPEEDDefault );
    refresh();
  }while(getCD() ==0);
}

void corrigerDroite() {

        Motor.speed(MOTOR1, SPEEDDefault );
        Motor.speed(MOTOR2, SPEED3 );
        delay(50);
}

void corrigerGauche() {
        Motor.speed(MOTOR1, SPEED3 );
        Motor.speed(MOTOR2, SPEEDDefault );
        delay(50);
}

void enAvant()   {
        Motor.speed(MOTOR1, SPEEDDefault);
        Motor.speed(MOTOR2, SPEEDDefault );
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
