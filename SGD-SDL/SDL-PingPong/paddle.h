#pragma once

#include "SDL.h"

class Paddle										// klasa padów
{
public:
	enum class Type { LEFT, RIGHT };				// lewy lub prawy pad
	enum class Direction { NONE, UP, DOWN };		// poruszanie sie w ogole/gora/dol
	Paddle(Type type, int x, int y);
	~Paddle() = default;

	void handle_input(SDL_Event const &event);		// przechwytywanie wszystkich eventów niedotycz¹cych g³ównego okna
	void update(double delta_time);					// aktulizowanie pozycji padów oraz kolizji
	void draw(SDL_Renderer* renderer);				// narysowanie pada (prostok¹t)


private:
	double m_y;										// "move y" - pozycja w pionie
	Type m_type;									// gracz / pad (lewy czy prawy)
	Direction m_direction;							// kierunek poruszania sie
	SDL_Rect m_position;							// pozycja pada
};