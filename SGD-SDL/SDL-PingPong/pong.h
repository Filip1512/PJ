#pragma once

#include "SDL.h"
#include "paddle.h"
#include "ball.h"

const int g_WINDOW_WIDTH = 640;
const int g_WINDOW_HEIGHT = 480;
const int g_GAME_WIDTH = 400;
const int g_GAME_HEIGHT = 400;

class Pong {				// klasa Pong - glowna

public:
	enum class Winner { START, LEFT, RIGHT};

	Pong();					// konstruktor klasy Pong
	~Pong() = default;		// destruktor - zamkniecie programu/restart gry, przywrócenie podstawowych wartoœci parametrów obiektu

	void newRound(Winner winner);
	void game_loop();
	void update(double delta_time);
	void draw();

	

private:
	SDL_Window*		m_game_window;
	SDL_Event		m_game_window_event;
	SDL_Renderer*	m_game_window_renderer;

	Ball			b_ball;
	Paddle			p_left_paddle;
	Paddle			p_right_paddle;
};