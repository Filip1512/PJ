#include "ball.h"
#include "time.h"
#include "SDL.h"
#include "pong.h"

#include <iostream>
#include <cstdlib>

Ball::~Ball()
{
	SDL_DestroyTexture(b_image);
}

bool PointInRect(int x, int y, SDL_Rect rec)
{
	if (x > rec.x &&
		y > rec.y &&
		x < rec.x + rec.w &&
		y < rec.y + rec.h
		)
	{
		return true;
	}
	return false;
}

bool CheckCollision(SDL_Rect r1, SDL_Rect r2)
{
	if (
		PointInRect(r1.x, r1.y, r2) == true ||
		PointInRect(r1.x + r1.w, r1.y, r2) == true ||
		PointInRect(r1.x, r1.y + r1.h, r2) == true ||
		PointInRect(r1.x + r1.w, r1.y + r1.h, r2) == true
		)
	{
		return true;
	}
	return false;
}

void Ball::init(SDL_Renderer* renderer, int x, int y)
{	
	srand(time(NULL));

	// --------------------- ladowanie obrazu kulki
	IMG_Init(IMG_INIT_PNG);

	SDL_Surface* image = IMG_Load("ball.png");

	b_image = SDL_CreateTextureFromSurface(renderer, image);
	SDL_FreeSurface(image);

	IMG_Quit();
	 // --------------------- koniec ladowania obrazu kulki
	 
	b_position.x = x;
	b_position.y = y;
	
	b_current_x = b_position.x;
	b_current_y = b_position.y;
	
	SDL_QueryTexture(b_image, nullptr, nullptr, &b_position.w, &b_position.h);

	// --------------------- losowanie pierwszego ruchu kulki x/y - prêdkoœæ

	int num_direction = rand() % 2;

	if (num_direction == 0)
	{
		b_velocity_x = -3;
	}
	else
	{
		b_velocity_x = 3;
	}


	b_velocity_y = rand() % 5 + 2;
	//b_velocity_y = 0;
	if (num_direction == 0)
	{
		b_velocity_y = -b_velocity_y;
	}

}

void Ball::update(double delta_time)
{
	//if (CheckCollision(b_position, Paddle::getPos()) == true)
	//{
	//	b_velocity_x = -b_velocity_x;
	//}
	if (b_position.x <= 5) {
		b_velocity_x = -b_velocity_x;
	}
	else if (b_position.x >= g_GAME_WIDTH - (5 + 16)) {		// 5 - szerokosc pada, 16 - szerokosc kulki
		b_velocity_x = -b_velocity_x;
	}
	if (b_position.y <= 0) {
		b_velocity_y = -b_velocity_y;
	}
	else if (b_position.y >= g_GAME_HEIGHT - 16) {			// 16 - wysokosc kulki
		b_velocity_y = -b_velocity_y;
	}

	b_current_x = b_current_x + (b_velocity_x * delta_time);
	b_position.x = b_current_x;
	b_current_y = b_current_y + (b_velocity_y * delta_time);
	b_position.y = b_current_y;

}

void Ball::draw(SDL_Renderer* renderer)
{
	SDL_RenderCopy(renderer, b_image, nullptr, &b_position);
}