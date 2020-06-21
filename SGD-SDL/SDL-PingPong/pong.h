#pragma once

#include "SDL.h"
#include "paddle.h"
#include "ball.h"
//#include "score.h"

const int g_WINDOW_WIDTH = 640;
const int g_WINDOW_HEIGHT = 480;
const int g_GAME_WIDTH = 400;
const int g_GAME_HEIGHT = 400;

class Pong {

public:
	enum class Winner { START, LEFT, RIGHT};

	Pong();
	~Pong() = default;

	void newRound(Winner winner);
	void game_loop();
	void update(double delta_time);
	void draw();

private:
	SDL_Window*		m_game_window;
	SDL_Event		m_game_window_event;
	SDL_Renderer*	m_game_window_renderer;

	Ball			b_ball;
	//Score			score;
	Paddle			p_left_paddle;
	Paddle			p_right_paddle;
};