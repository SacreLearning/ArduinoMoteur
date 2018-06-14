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
  
    refresh();
  
  stop();

    // VERIFICATION SORTIE DE ROUTE DROITE
    while(RightOut() == true) {
      corrigerDroite();
      Serial.println("corrigerDroite");
      refresh();
    }

    // VERIFICATION SORTIE DE ROUTE GAUCHE
    while(LeftOut() == true)  {
      corrigerGauche();
      Serial.println("corrigerGauche");
      refresh();
    }

    // VERIFICATION TOURNANT DROITE
    while(IsThereARightRoad() == true) {
      tournerDroite();
      Serial.println("tournerDroite");
      refresh();
      
      // VERIFICATION ROUTE FACE
      while(IsThereAFrontRoadWhenUTurnRight() == true) {
        randNum1 == randomizer(2);
        while(randNum1 == 1) {
          enAvant();
          refresh();
            if (IsThereARightRoad() == false) {
              randNum2 = 0;
            }
        }
        while(randNum1 == 2) {
          tournerDroite();
          refresh();
            if (IsThereARightRoad() == false) {
              randNum2 = 0;
            }  
        }
      }
    }

    // VERIFICATION TOURNANT GAUCHE
    while(IsThereALeftRoad() == true) {
      tournerGauche();
      Serial.println("tournerGauche");
      refresh();
      
      // VERIFICATION ROUTE FACE
      while(IsThereAFrontRoadWhenUTurnLeft() == true) {
        randNum1 == randomizer(2);
        while(randNum1 == 1) {
          enAvant();
          refresh();
            if (IsThereALeftRoad() == false) {
              randNum2 = 0;
            }
        }
        while(randNum1 == 2) {
          tournerGauche();
          refresh();
            if (IsThereALeftRoad() == false) {
              randNum2 = 0;
            }  
        }
      }
   }

   // VERIFICATION TOURNANT MULTIPLE
    while(AreThereLeftAndRightRoad() == true) {
      randNum1 = randomizer(2);
      Serial.println("Tournant Multiple");
      while(randNum1 == 1) {
        tournerDroite();

        // VERIFICATION ROUTE FACE
        while(IsThereAFrontRoadWhenUTurnRight() == true) {
          randNum2 = randomizer(2);
          while(randNum2 == 1) {
            enAvant();
            refresh();
            if (AreThereLeftAndRightRoad() == false) {
              randNum2 = 0;
            }
          }
          while(randNum2 == 2) {
            tournerGauche();
            refresh();
            if (AreThereLeftAndRightRoad() == false) {
              randNum2 = 0;
            }         
        }
      }
      while(randNum1 == 2) {
        tournerGauche();
        refresh();
        
        // VERIFICATION ROUTE FACE
        while(IsThereAFrontRoadWhenUTurnLeft() == true) {
          randNum2 = randomizer(2);
          while(randNum2 == 1) {
            enAvant();
            refresh();
            if (AreThereLeftAndRightRoad() == false) {
              randNum2 = 0;
            }
          }
          while(randNum2 == 2) {
            tournerGauche();
            refresh();
            if (AreThereLeftAndRightRoad() == false) {
              randNum2 = 0;
            }
          }
        }
      }
    }
  }
}
    
