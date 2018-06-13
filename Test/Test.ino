/*
 * 
 * Test for motor
 * 
 */

#include "fonctions.h"
#include "conditions.h"

#define i2c_address 0x0f

 //define captor pin
  int captorDroiteExPin    = 5;
  int captorDroitePin      = 6;
  int captorGauchePin      = 7;
  int captorGaucheExPin    = 8;

 //define values of pin
  int cDE     = -1;
  int cGE   = -1;
  int cD    = -1;
  int cG    = -1;

  long randNum1;
  long randNum2;
  
void setup() {
    
//PIN MODE FOR THE CAPTORS
    pinMode(captorDroiteExPin  , INPUT);
    pinMode(captorGauchePin    , INPUT);
    pinMode(captorDroitePin    , INPUT);
    pinMode(captorGaucheExPin  , INPUT);

//Motor Begin
    
    Motor.begin(i2c_address);
    randomSeed(analogRead(0));
    Serial.begin(9600);    
}


void loop() {
    cDE = digitalRead(captorDroiteExPin);
    cGE = digitalRead(captorGaucheExPin);
    cD = digitalRead(captorDroitePin);
    cG = digitalRead(captorGauchePin);


    // VERIFICATION SORTIE DE ROUTE DROITE
    while(RightOut(cDE, cGE, cD, cG) == true) {
      corrigerDroite();
    }

    // VERIFICATION SORTIE DE ROUTE GAUCHE
    while(LeftOut(cDE, cGE, cD, cG) == true)  {
      corrigerGauche();
    }

    // VERIFICATION TOURNANT DROITE
    while(IsThereARightRoad(cDE, cGE, cD, cG) == true) {
      tournerDroite();

      // VERIFICATION ROUTE FACE
      while(IsThereAFrontRoadWhenUTurnRight(cDE, cGE, cD, cG) == true) {
        randNum1 == randomizer(2);
        while(randNum1 == 1) {
          enAvant();
            if (IsThereARightRoad(cDE, cGE, cD, cG) == false) {
              randNum2 = 0;
            }
        }
        while(randNum1 == 2) {
          tournerDroite();
            if (IsThereARightRoad(cDE, cGE, cD, cG) == false) {
              randNum2 = 0;
            }  
        }
      }
    }

    // VERIFICATION TOURNANT GAUCHE
    while(IsThereALeftRoad(cDE, cGE, cD, cG) == true) {
      tournerGauche();

      // VERIFICATION ROUTE FACE
      while(IsThereAFrontRoadWhenUTurnLeft(cDE, cGE, cD, cG) == true) {
        randNum1 == randomizer(2);
        while(randNum1 == 1) {
          enAvant();
            if (IsThereALeftRoad(cDE, cGE, cD, cG) == false) {
              randNum2 = 0;
            }
        }
        while(randNum1 == 2) {
          tournerGauche();
            if (IsThereALeftRoad(cDE, cGE, cD, cG) == false) {
              randNum2 = 0;
            }  
        }
      }
   }

   // VERIFICATION TOURNANT MULTIPLE
    while(AreThereLeftAndRightRoad(cDE, cGE, cD, cG) == true) {
      randNum1 = randomizer(2);
      while(randNum1 == 1) {
        tournerDroite();

        // VERIFICATION ROUTE FACE
        while(IsThereAFrontRoadWhenUTurnRight(cDE, cGE, cD, cG) == true) {
          randNum2 = randomizer(2);
          while(randNum2 == 1) {
            enAvant();
            if (AreThereLeftAndRightRoad(cDE, cGE, cD, cG) == false) {
              randNum2 = 0;
            }
          }
          while(randNum2 == 2) {
            tournerGauche();
            if (AreThereLeftAndRightRoad(cDE, cGE, cD, cG) == false) {
              randNum2 = 0;
            }         
        }
      }
      while(randNum1 == 2) {
        tournerGauche();

        // VERIFICATION ROUTE FACE
        while(IsThereAFrontRoadWhenUTurnLeft(cDE, cGE, cD, cG) == true) {
          randNum2 = randomizer(2);
          while(randNum2 == 1) {
            enAvant();
            if (AreThereLeftAndRightRoad(cDE, cGE, cD, cG) == false) {
              randNum2 = 0;
            }
          }
          while(randNum2 == 2) {
            tournerGauche();
            if (AreThereLeftAndRightRoad(cDE, cGE, cD, cG) == false) {
              randNum2 = 0;
            }
          }
        }
      }
    }
  }
}
    
