#include <Grove_I2C_Motor_Driver.h>

// Sortie de route droite
bool RightOut(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche);

// Sortie de route gauche
bool LeftOut(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche);

// Route à droite
bool IsThereARightRoad(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche);

// Route à gauche 
bool IsThereALeftRoad(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche);

// Route à gauche et à droite
bool AreThereLeftAndRightRoad(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche);

// Route en face (lors d'un tournant droite)
bool IsThereAFrontRoadWhenUTurnRight(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche);

// Route en face (lors d'un tournant gauche)
bool IsThereAFrontRoadWhenUTurnLeft(int captorDroiteEx,int captorGaucheEx,int captorDroite,int captorGauche);
