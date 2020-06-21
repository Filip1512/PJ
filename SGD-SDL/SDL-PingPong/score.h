/*#pragma once

#include "pong.h"
#include "SDL.h"
#include "SDL_ttf.h"

#include <sstream>
#include <string>

class Score
{
public:
	Score(SDL_Rect msg_rect, SDL_Renderer* renderer, TTF_Font* font);
	~Score();

	void draw(SDL_Renderer* renderer, SDL_Texture* message, SDL_Rect msg_rect);

	SDL_Renderer*	renderer;
	TTF_Font*		font;
	SDL_Rect		msg_rect;
	SDL_Surface*	messageSurface;
	SDL_Texture*	message;
	SDL_Color		msg_color;
};
*/