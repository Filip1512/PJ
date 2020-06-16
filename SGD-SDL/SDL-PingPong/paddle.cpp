#include "paddle.h"
#include "pong.h"

Paddle::Paddle(Type type, int x, int y)
{
	p_position.x = x;
	p_position.y = y;
	p_position.w = 5;
	p_position.h = 60;
	p_y = static_cast<double>(y);		// rzutowanie liczby
	p_direction = Direction::NONE;
	p_type = type;
}

void Paddle::handle_input(SDL_Event const &event)
{
	switch (event.type)
	{
		case SDL_KEYDOWN:
			Uint8 const* key = SDL_GetKeyboardState(nullptr);
			// --------------------------------- LEWY PAD, poruszanie siê
			if (p_type == Type::LEFT)
			{
				if (key[SDL_SCANCODE_W])
				{
					p_direction = Direction::UP;
				}
				if (key[SDL_SCANCODE_S])
				{
					p_direction = Direction::DOWN;
				}
			}
			// --------------------------------- PRAWY PAD, poruszanie siê
			else if (p_type == Type::RIGHT)
			{
				if (key[SDL_SCANCODE_UP])
				{
					p_direction = Direction::UP;
				}
				if (key[SDL_SCANCODE_DOWN])
				{
					p_direction = Direction::DOWN;
				}
			}
	}
}

void Paddle::update(double delta_time)
{
	if (p_direction == Direction::UP)
	{
		if (p_position.y < 0) p_direction = Direction::NONE;

		p_y = p_y - 5.0 * delta_time;
		p_position.y = p_y;
	}
	else if (p_direction == Direction::DOWN)
	{
		if (p_position.y > g_GAME_HEIGHT - p_position.h) p_direction = Direction::NONE;

		p_y = p_y + 5.0 * delta_time;
		p_position.y = p_y;
	}
	else if (p_direction == Direction::NONE)
	{
		p_position.y = p_y;
	}
}

void Paddle::draw(SDL_Renderer* renderer)
{
	SDL_SetRenderDrawColor(renderer, 255, 255, 255, 255);
	SDL_RenderFillRect(renderer, &p_position);
	SDL_SetRenderDrawColor(renderer, 0, 0, 0, 255);
}