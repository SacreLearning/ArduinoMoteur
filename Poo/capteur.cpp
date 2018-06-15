

#include <Arduino.h>
#include "capteur.h"

Capteur::Capteur(){
}

// Sortie de route droite
bool Capteur::rightOut(){
  captorDroiteEx = getCDE();
  captorGaucheEx = getCGE();
  captorDroite = getCD();
  captorGauche = getCG();
  if (captorDroite == 1 && captorDroiteEx == 0) {
    return true;
  }
  else return false;
}

// Sortie de route gauche
bool Capteur::leftOut() {
  captorDroiteEx = getCDE();
  captorGaucheEx = getCGE();
  captorDroite = getCD();
  captorGauche = getCG();
    if (captorGauche == 1 && captorGaucheEx == 0) {
    return true;
  }
  else return false;
}

// Route à droite
bool Capteur::isThereARightRoad() {
  captorDroiteEx = getCDE();
  captorGaucheEx = getCGE();
  captorDroite = getCD();
  captorGauche = getCG();
  if(captorDroite == 1 && captorDroiteEx == 1 && captorGauche == 0 && captorGaucheEx == 0) {
  return true;
  }
  else return false;
}

// Route à gauche 
bool Capteur::isThereALeftRoad() {
  captorDroiteEx = getCDE();
  captorGaucheEx = getCGE();
  captorDroite = getCD();
  captorGauche = getCG();
    if(captorGauche == 1 && captorGaucheEx == 1 && captorDroite == 0 && captorDroiteEx == 0) {
  return true;
  }
  else return false;
}

// Routes à gauche et à droite
bool Capteur::areThereLeftAndRightRoad() {
  captorDroiteEx = getCDE();
  captorGaucheEx = getCGE();
  captorDroite = getCD();
  captorGauche = getCG();
  if(captorDroite == 1 && captorDroiteEx == 1 && captorGauche == 1 && captorGaucheEx == 1) {
    return true;
  }
  else return false;
}

// Route en face (lors d'un tournant droite)
bool Capteur::isThereAFrontRoadWhenUTurnRight() {
  captorDroiteEx = getCDE();
  captorGaucheEx = getCGE();
  captorDroite = getCD();
  captorGauche = getCG();
  if(captorGauche == 1) {
    return true;
  }
  else return false;
}

// Route en face (lors d'un tournant gauche)
bool Capteur::isThereAFrontRoadWhenUTurnLeft() {
  captorDroiteEx = getCDE();
  captorGaucheEx = getCGE();
  captorDroite = getCD();
  captorGauche = getCG();
  if(captorDroite == 1) {
    return true;
  }
  else return false;
}

void Capteur::refresh(){
  cDE = digitalRead(captorDroiteExPin);
  cGE = digitalRead(captorGaucheExPin);
  cD = digitalRead(captorDroitePin);
  cG = digitalRead(captorGauchePin);
}

int Capteur::getCDEPin() {
  return captorDroiteExPin;
}

int Capteur::getCGEPin() {
  return captorGaucheExPin;
}

int Capteur::getCDPin() {
  return captorDroitePin;
}

int Capteur::getCGPin() {
  return captorGauchePin;
}

int Capteur::getCDE() {
  return cDE;
}

int Capteur::getCGE() {
  return cGE;
}

int Capteur::getCD() {
  return cD;
}

int Capteur::getCG() {
  return cG;
}