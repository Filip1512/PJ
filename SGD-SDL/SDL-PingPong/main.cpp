#include "pong.h"
#include "paddle.h"
#include "ball.h"

#include <string>

int main(int argc, char* args[])
{

    Pong pong;
    pong.game_loop();

    return 0;
}


// stworzenie instacji okna z klasy pong i wywolanie metody game_loop() - zapÍtlenie okna gry
