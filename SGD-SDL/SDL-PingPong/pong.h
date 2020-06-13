#pragma once

#include <SDL.h>

class Pong {				// klasa Pong - glowna

public:

	Pong();					// konstruktor klasy Pong
	~Pong() = default;		// destruktor - zamkniecie programu/restart gry, przywrócenie podstawowych wartoœci parametrów obiektu

	void game_loop();
	void update(double delta_time);
	void draw();

private:
	SDL_Window* m_game_window;
	SDL_Event m_game_window_event;
	SDL_Renderer* m_game_window_renderer;

};