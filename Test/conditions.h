#include <Grove_I2C_Motor_Driver.h>

// Sortie de route droite
bool RightOut();

// Sortie de route gauche
bool LeftOut();

// Route à droite
bool IsThereARightRoad();

// Route à gauche 
bool IsThereALeftRoad();

// Route à gauche et à droite
bool AreThereLeftAndRightRoad();

// Route en face (lors d'un tournant droite)
bool IsThereAFrontRoadWhenUTurnRight();

// Route en face (lors d'un tournant gauche)
bool IsThereAFrontRoadWhenUTurnLeft();
