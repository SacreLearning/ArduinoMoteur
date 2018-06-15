#ifndef classTest_h

#define classTest_h

#include <Arduino.h>

class classTest {
    int counter = 0;
    char tab [5][5];

    //LINE 0
    char [0][0] = 'A';
    char [0][1] = 'D';
    char [0][2] = 'G';
    char [0][4] = 'I';
    char [0][2] = 'M';

    //LINE 1
    char [1][2] = 'H';
    char [1][4] = 'J';
    char [1][5] = 'N';

    //LINE 3
    char [3][0] = 'B';
    char [3][1] = 'E';
    char [3][5] = 'O';

    //LINE 4
    char [4][1] = 'F';
    char [4][5] = 'D';

    //LINE 5
    char [5][0] = 'C';
    char [5][4] = 'L';
    char [5][5] = 'P';

    int direction = -1;

    classTest();
    int docount();
    int rotation();
    void direction();
    void distance();
}