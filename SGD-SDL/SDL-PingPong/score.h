#/*pragma once

#include "SDL.h"
#include "pong.h"

class Score
{
public:
	Score(SDL_Renderer* renderer);
	~Score() = default;

	void update(double delta_time);
	void draw(SDL_Renderer* renderer);

private:
	SDL_Rect		msg_rect;
	SDL_Surface*	messageSurface;
	SDL_Texture*	Message;
	SDL_Color		msg_color;
};*/