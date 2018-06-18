#include "coord.h"


coord::coord()  {

}

coord::docount()    {
    attachInterrupt(pinToRead, docount, RISING);
    counter++;
    return counter;
}

coord::rotation(int pinToRead)   {
    int rotation = (counter / 20);
    return rotation;
    //perimetre roue = 20.41cm
}

coord::direction(int directionPrécédente, string action){

	/*Direction
	*	1: nord
	*	2: sud
	*	3: est
	*	4: ouest
	*/
	
	/*Action
	*	TournerDroite
	*	TournerGauche
	*	EnAvant
	*/
	
	int prochaineDirection =0;
//----------------------------------------------------------------------------------
//	directionPrécédente == nord
//----------------------------------------------------------------------------------
	if(directionPrécédente == 1 && action == TournerDroite){
		prochaineDirection == 3;	//est
	
	}else if(directionPrécédente == 1 && action == TournerGauche){
		prochaineDirection == 4;	//ouest
	
	}else if(directionPrécédente == 1 && action == EnAvant){
		prochaineDirection == 1;	//nord
	
	}
//----------------------------------------------------------------------------------
//	directionPrécédente == sud
//----------------------------------------------------------------------------------
	else if(directionPrécédente == 2 && action == TournerDroite){
		prochaineDirection == 4;	//ouest
	
	}else if(directionPrécédente == 2 && action == TournerGauche){
		prochaineDirection == 3;	//est
	
	}else if(directionPrécédente == 2 && action == EnAvant){
		prochaineDirection == 2;	//sud
	
	}
//----------------------------------------------------------------------------------
//	directionPrécédente == est
//----------------------------------------------------------------------------------
	else if(directionPrécédente == 3 && action == TournerDroite){
		prochaineDirection == 2;	//sud
	
	}else if(directionPrécédente == 3 && action == TournerGauche){
		prochaineDirection == 1;	//nord
	
	}else if(directionPrécédente == 3 && action == EnAvant){
		prochaineDirection == 3;	//est
	
	}
//----------------------------------------------------------------------------------
//	directionPrécédente == ouest
//----------------------------------------------------------------------------------
	else if(directionPrécédente == 4 && action == TournerDroite){
		prochaineDirection == 1;	//nord
	
	}else if(directionPrécédente == 4 && action == TournerGauche){
		prochaineDirection == 2;	//sud
	
	}else if(directionPrécédente == 4 && action == EnAvant){
		prochaineDirection == 4;	//ouest
	}
//----------------------------------------------------------------------------------
	
	return prochaineDirection;
}

coord::checkPos(char input, char dest)  {
    if (input == dest)  {
        stop();
    }
}

coord::distanceIntoCoord(int pinToRead)  {

    attachInterrupt(pinToRead, docount, RISING);
    int cm = (counter / 1,0205);

    //unité abscisse : 42
    //unité ordonnee : 29,7
    

        while (prochaineDirection == 3)   //ABSCISSE POSITIF
            {
                if (cm == 42)    {
                //coordX = coordX++;
                tab [x+1][y];
                }
            char position = tab [x][y];
            Serial.println(position);
            }
        
        while (prochaineDirection == 4)   //ABSCISSE NEGATIF
            {
                if (cm == 42)    {
                //coordX = coordX--;
                tab [x-1][y];
                }
            char position = tab [x][y];
            Serial.println(position);
            }


        while (prochaineDirection == 1)   //ORDONNEE POSITIF
            {
                if (cm == 29,7)    {
                //coordY = coordY++;
                tab [x][y+1];
                }
            char position = tab [x][y];
            Serial.println(position);
            }
        
        while (prochaineDirection)   //ORDONNEE NEGATIF
            {
                if (cm == 29,7)    {
                //coordY = coordY--;
                tab [x][y-1];
                }
            char position = tab [x][y];
            Serial.println(position);
            }
    return position;
}