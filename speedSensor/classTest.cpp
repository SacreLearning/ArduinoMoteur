#include "classTest.h"


classTest::classTest()  {

}

classTest::docount()    {
    attachInterrupt(pinToRead, docount, RISING);
    counter++;
    return counter;
}

classTest::rotation(int pinToRead)   {
    int rotation = (counter / 20);
    return rotation;
    //perimetre roue = 20.41cm
}

classTest::direction()  {

}

classTest::distanceIntoCoord(int pinToRead)  {

    attachInterrupt(pinToRead, docount, RISING);
    int cm = (counter / 1,0205);

    //unité abscisse : 42
    //unité ordonnee : 29,7
    

        while (bool dirX == 1)   //ABSCISSE POSITIF
            {
                if (cm == 42)    {
                //coordX = coordX++;
                tab [x+1][y];
                }
            char position = tab [x][y];
            Serial.println(position);
            }
        
        while (bool dirX == 0)   //ABSCISSE NEGATIF
            {
                if (cm == 42)    {
                //coordX = coordX--;
                tab [x-1][y];
                }
            char position = tab [x][y];
            Serial.println(position);
            }


        while (bool dirY == 1)   //ORDONNEE POSITIF
            {
                if (cm == 29,7)    {
                //coordY = coordY++;
                tab [x][y+1];
                }
            char position = tab [x][y];
            Serial.println(position);
            }
        
        while (bool dirY == 0)   //ORDONNEE NEGATIF
            {
                if (cm == 29,7)    {
                //coordY = coordY--;
                tab [x][y-1];
                }
            char position = tab [x][y];
            Serial.println(position);
            }
}