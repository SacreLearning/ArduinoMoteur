#include <Grove_I2C_Motor_Driver.h>

// Sortie de route droite
bool rightOut();
bool exRightOut();

// Sortie de route gauche
bool leftOut();
bool exLeftOut();

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
