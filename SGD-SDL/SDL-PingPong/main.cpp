#include "pong.h"

int main(int argc, char* args[])
{
    Pong pong;
    pong.game_loop();

    return 0;
}


// stworzenie instacji okna z klasy pong i wywolanie metody game_loop() - zapêtlenie okna gry
