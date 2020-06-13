#pragma once

#include "SDL.h"

class Paddle										// klasa pad�w
{
public:
	enum class Type { LEFT, RIGHT };				// lewy lub prawy pad
	enum class Direction { NONE, UP, DOWN };		// poruszanie sie w ogole/gora/dol
	Paddle(Type type, int x, int y);
	~Paddle() = default;

	void handle_input(SDL_Event const &event);		// przechwytywanie wszystkich event�w niedotycz�cych g��wnego okna
	void update(double delta_time);					// aktulizowanie pozycji pad�w oraz kolizji
	void draw(SDL_Renderer* renderer);				// narysowanie pada (prostok�t)


private:
	double m_y;										// "move y" - pozycja w pionie
	Type m_type;									// gracz / pad (lewy czy prawy)
	Direction m_direction;							// kierunek poruszania sie
	SDL_Rect m_position;							// pozycja pada
};