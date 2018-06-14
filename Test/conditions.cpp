
#include "fonctions.h"
  int captorDroiteEx;
  int captorGaucheEx;
  int captorGauche;
  int captorDroite;

// Sortie de route droite
bool RightOut(){
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
bool LeftOut() {
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
bool IsThereARightRoad() {
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
bool IsThereALeftRoad() {
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
bool AreThereLeftAndRightRoad() {
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
bool IsThereAFrontRoadWhenUTurnRight() {
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
bool IsThereAFrontRoadWhenUTurnLeft() {
  captorDroiteEx = getCDE();
  captorGaucheEx = getCGE();
  captorDroite = getCD();
  captorGauche = getCG();
  if(captorDroite == 1) {
    return true;
  }
  else return false;
}

