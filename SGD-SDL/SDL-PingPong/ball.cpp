#include "ball.h"
#include "time.h"
#include "SDL.h"
#include "pong.h"
#include "paddle.h"

#include <iostream>
#include <cstdlib>

Ball::~Ball()
{
	SDL_DestroyTexture(m_image);
}

void Ball::init(SDL_Renderer* renderer, int x, int y)
{	
	srand(time(NULL));

	// --------------------- ladowanie obrazu kulki
	IMG_Init(IMG_INIT_PNG);

	SDL_Surface* image = IMG_Load("ball.png");

	m_image = SDL_CreateTextureFromSurface(renderer, image);
	SDL_FreeSurface(image);

	IMG_Quit();
	 // --------------------- koniec ladowania obrazu kulki
	 
	m_position.x = x;
	m_position.y = y;
	
	current_x = m_position.x;
	current_y = m_position.y;
	
	SDL_QueryTexture(m_image, nullptr, nullptr, &m_position.w, &m_position.h);

	// --------------------- losowanie pierwszego ruchu kulki x/y - prêdkoœæ
	int num_x = rand() % 2;
	if (num_x == 0)
	{
		m_velocity_x = 3;
	}
	else
	{
		m_velocity_x = -3;
	}

	m_velocity_y = rand() % 3;
	if (num_x == 0)
	{
		m_velocity_y = -m_velocity_y;
	}

}

void Ball::update(double delta_time)
{
	if (m_position.x <= 5) {
		m_velocity_x = -m_velocity_x;
	}
	else if (m_position.x >= g_GAME_WIDTH - (5+16)) {		// 5 - szerokosc pada, 16 - szerokosc kulki
		m_velocity_x = -m_velocity_x;
	}
	
	if (m_position.y <= 0) {
		m_velocity_y = -m_velocity_y;
	}
	else if (m_position.y >= g_GAME_HEIGHT - 16) {			// 16 - wysokosc kulki
		m_velocity_y = -m_velocity_y;
	}

	current_x = current_x + (m_velocity_x * delta_time);
	m_position.x = current_x;
	current_y = current_y + (m_velocity_y * delta_time);
	m_position.y = current_y;

}

void Ball::draw(SDL_Renderer* renderer)
{
	SDL_RenderCopy(renderer, m_image, nullptr, &m_position);
}