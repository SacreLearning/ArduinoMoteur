#ifndef classTest_h

#define classTest_h

#include <Arduino.h>

class classTest {
    int counter = 0;
    char tab [6][6];

    //LINE 0
    tab [0][0] = 'A';
    tab [0][1] = 'D';
    tab [0][2] = 'G';
    tab [0][4] = 'I';
    tab [0][2] = 'M';

    //LINE 1
    tab [1][2] = 'H';
    tab [1][4] = 'J';
    tab [1][5] = 'N';

    //LINE 3
    tab [3][0] = 'B';
    tab [3][1] = 'E';
    tab [3][5] = 'O';

    //LINE 4
    tab [4][1] = 'F';
    tab [4][5] = 'D';

    //LINE 5
    tab [5][0] = 'C';
    tab [5][4] = 'L';
    tab [5][5] = 'P';

    int direction = -1;

    classTest();
    int docount();
    int rotation();
    void direction();
    void distance();
}