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

	SDL_Rect	p_position;							// pozycja pada

private:
	double		p_y;								// pozycja w pionie
	Type		p_type;								// gracz / pad (lewy czy prawy)
	Direction	p_direction;						// kierunek poruszania sie
};