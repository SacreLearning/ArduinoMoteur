/*
 * 
 * Test for motor
 * 
 */

#include "fonctions.h"
#include "conditions.h"

#define i2c_address 0x0f

  long randNum1;
  long randNum2;

void setup() {
    
//PIN MODE FOR THE CAPTORS
    pinMode(getCDEPin()  , INPUT);
    pinMode(getCGEPin()  , INPUT);
    pinMode(getCDPin()  , INPUT);
    pinMode(getCGPin()  , INPUT);

//Motor Begin
    
    Motor.begin(i2c_address);
    randomSeed(analogRead(0));
    Serial.begin(9600);    
}

void loop() {
    
    enAvant();  
    refresh();

    //stop();
    // VERIFICATION SORTIE ROUTE DROITE
    while(rightOut() == true) {
      corrigerDroite();
      Serial.println("corrigerDroite");
      refresh();
    }

    // VERIFICATION SORTIE ROUTE GAUCHE
    while(leftOut() == true)  {
      corrigerGauche();
      Serial.println("corrigerGauche");
      refresh();
    }

    // VERIFICATION TOURNANT DROITE
    while(isThereARightRoad() == true) {
      tournerDroite();
  }
    while(isThereALeftRoad() == true) {
      tournerGauche();
    }

/*   // VERIFICATION TOURNANT MULTIPLE
    while(areThereLeftAndRightRoad() == true) {
      randNum1 = randomizer(2);
      Serial.println("Tournant Multiple");
      while(randNum1 == 1) {
        tournerDroite();
        refresh();
        
        // VERIFICATION ROUTE FACE
        while(isThereAFrontRoadWhenUTurnRight() == true) {
          randNum2 = randomizer(2);
          while(randNum2 == 1) {
            enAvant();
            refresh();
            if (areThereLeftAndRightRoad() == false) {
              randNum2 = 0;
            }
          }
          while(randNum2 == 2) {
            tournerGauche();
            refresh();
            if (areThereLeftAndRightRoad() == false) {
              randNum2 = 0;
            }         
        }
      }
      while(randNum1 == 2) {
        tournerGauche();
        refresh();
        
        // VERIFICATION ROUTE FACE
        while(isThereAFrontRoadWhenUTurnLeft() == true) {
          randNum2 = randomizer(2);
          while(randNum2 == 1) {
            enAvant();
            refresh();
            if (areThereLeftAndRightRoad() == false) {
              randNum2 = 0;
            }
          }
          while(randNum2 == 2) {
            tournerGauche();
            refresh();
            if (areThereLeftAndRightRoad() == false) {
              randNum2 = 0;
            }
          }
        }
      }
    }
  }*/
}
    
