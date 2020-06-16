#include "pong.h"

// stworzenie okna gry
// na dole w Paddle::Type::RIGHT pozycja x to "g_GAME_WIDTH - 5", bo szerokosc paddla to 5 i wychodzi³o poza okno gry :)
Pong::Pong() : m_left_paddle(Paddle::Type::LEFT, 0, (g_GAME_HEIGHT / 2) - 50), m_right_paddle(Paddle::Type::RIGHT, g_GAME_WIDTH - 5, (g_GAME_HEIGHT / 2) - 50)
{
	SDL_SetWindowTitle(m_game_window, "Ping Pong by Filip");
	SDL_CreateWindowAndRenderer(g_WINDOW_WIDTH, g_WINDOW_HEIGHT, SDL_WINDOW_RESIZABLE, &m_game_window, &m_game_window_renderer);
	SDL_RenderSetLogicalSize(m_game_window_renderer, g_GAME_WIDTH, g_GAME_HEIGHT);
	m_ball.init(m_game_window_renderer, (g_GAME_WIDTH/2)-25, (g_GAME_HEIGHT/2)-25);
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

			m_left_paddle.handle_input(m_game_window_event);
			m_right_paddle.handle_input(m_game_window_event);
		}

		update(1.0 / 60.0);	// 60fps
		draw();
	}
}

void Pong::update(double delta_time)
{
	m_left_paddle.update(delta_time);
	m_right_paddle.update(delta_time);
	m_ball.update(delta_time);
}

void Pong::draw()
{
	SDL_RenderClear(m_game_window_renderer);

	m_left_paddle.draw(m_game_window_renderer);
	m_right_paddle.draw(m_game_window_renderer);
	m_ball.draw(m_game_window_renderer);

	SDL_RenderPresent(m_game_window_renderer);
}