#include "pong.h"
#include "ball.h"
#include "paddle.h"
#include "SDL_ttf.h"
#include "SDL_image.h"
#include "score.cpp"


#include <sstream>
#include <string>

int g_SCORE_P_LEFT = 0;
int g_SCORE_P_RIGHT = 0;
bool g_ROUND_START;

// na dole w Paddle::Type::RIGHT pozycja x to "g_GAME_WIDTH - 5", bo szerokosc paddla to 5 i wychodzi³o poza okno gry :)
Pong::Pong() : p_left_paddle(Paddle::Type::LEFT, 1, (g_GAME_HEIGHT / 2) - 50), p_right_paddle(Paddle::Type::RIGHT, g_GAME_WIDTH - 5, (g_GAME_HEIGHT / 2) - 50)
{
	SDL_SetWindowTitle(m_game_window, "Ping Pong by Filip");
	SDL_CreateWindowAndRenderer(g_WINDOW_WIDTH, g_WINDOW_HEIGHT, SDL_WINDOW_RESIZABLE, &m_game_window, &m_game_window_renderer);
	SDL_RenderSetLogicalSize(m_game_window_renderer, g_GAME_WIDTH, g_GAME_HEIGHT);



	Pong::newRound(Winner::START);
}

void Pong::newRound(Pong::Winner winner)
{
	TTF_Init();
	TTF_Font* arial = TTF_OpenFont("arial.ttf", 128);

	g_ROUND_START = true;

	if (winner == Winner::LEFT)
	{
		g_SCORE_P_LEFT += 1;
	}
	else if (winner == Winner::LEFT)
	{
		g_SCORE_P_RIGHT += 1;
	}



	b_ball.init(m_game_window_renderer, (g_GAME_WIDTH / 2) - 8, (g_GAME_HEIGHT / 2) - 25);
}

void Pong::game_loop()
{
	bool keep_running = true;
	while (keep_running)
	{
		while (SDL_PollEvent(&m_game_window_event) > 0)
		{
			switch (m_game_window_event.type)
			{
			case SDL_QUIT:
				keep_running = false;
			}

			p_left_paddle.handle_input(m_game_window_event);
			p_right_paddle.handle_input(m_game_window_event);
		}

		update(1.0 / 60.0);
		draw();
	}
}

void Pong::update(double delta_time)
{
	p_left_paddle.update(delta_time);
	p_right_paddle.update(delta_time);
	b_ball.update(delta_time);
}

void Pong::draw()
{
	SDL_RenderClear(m_game_window_renderer);

	p_left_paddle.draw(m_game_window_renderer);
	p_right_paddle.draw(m_game_window_renderer);
	b_ball.draw(m_game_window_renderer);

	SDL_Rect rect_left;
	rect_left.h = 30;
	rect_left.w = 50;
	rect_left.x = (g_GAME_WIDTH / 2) - rect_left.w;
	rect_left.y = 1;
	SDL_Rect rect_right;
	rect_right.h = rect_left.h;
	rect_right.w = rect_left.w;
	rect_right.y = rect_left.y;
	rect_right.x = rect_left.x + rect_left.w - 1;
	SDL_SetRenderDrawColor(m_game_window_renderer, 255, 255, 255, 155);
	SDL_RenderDrawRect(m_game_window_renderer, &rect_left);
	SDL_SetRenderDrawColor(m_game_window_renderer, 0, 0, 0, 155);
	SDL_SetRenderDrawColor(m_game_window_renderer, 255, 255, 255, 155);
	SDL_RenderDrawRect(m_game_window_renderer, &rect_right);
	SDL_SetRenderDrawColor(m_game_window_renderer, 0, 0, 0, 155);

	/*
	TTF_Init();
	TTF_Font* arial = TTF_OpenFont("arial.ttf", 128);
	SDL_Color msg_color = { 255,255,255 };

	char msg[128];
	sprintf_s(msg, "%d     %d", g_SCORE_P_LEFT, g_SCORE_P_RIGHT);

	SDL_Surface* messageSurface = TTF_RenderText_Solid(arial, msg, msg_color);
	SDL_Texture* Message = SDL_CreateTextureFromSurface(m_game_window_renderer, messageSurface);

	SDL_Rect msg_rect;
	msg_rect.x = g_GAME_WIDTH/2-rect_left.w/2;
	msg_rect.y = 0;
	msg_rect.w = rect_left.w;
	msg_rect.h = rect_left.h;

	SDL_RenderCopy(m_game_window_renderer, Message, NULL, &msg_rect);
	SDL_FreeSurface(messageSurface);
	TTF_Quit();*/
	

	
	SDL_RenderPresent(m_game_window_renderer);
	TTF_Quit();

	if (g_ROUND_START == true)
	{
		SDL_Delay(2000);
		g_ROUND_START = false;
	}
}