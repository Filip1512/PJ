/*#include "SDL.h"
#include "SDL_ttf.h"
#include "score.h"

#include <sstream>
#include <string>

Score::~Score()
{
	SDL_DestroyTexture(message);
	SDL_FreeSurface(messageSurface);
}

Score::Score(SDL_Rect msg_rect, SDL_Renderer* renderer, TTF_Font* font) : renderer(renderer), font(font)
{
		//char msg[128];
		//sprintf_s(msg, "%d %d", g_SCORE_P_LEFT, g_SCORE_P_RIGHT);
		SDL_Color msg_color = { 255, 255, 255 };
		SDL_Surface* messageSurface = TTF_RenderText_Solid(font, "0", msg_color);
		SDL_Texture* message = SDL_CreateTextureFromSurface(renderer, messageSurface);

		SDL_QueryTexture(message, nullptr, nullptr, &msg_rect.w, &msg_rect.h);

		msg_rect.y = 0;
		msg_rect.w = 30;
		msg_rect.h = 30;
		msg_rect.x = (400 / 2) - (50 / 2) + (msg_rect.w / 2) - 6;
}

void Score::draw(SDL_Renderer* renderer, SDL_Texture* message, SDL_Rect msg_rect)
{
	SDL_RenderCopy(renderer, message, NULL, &msg_rect);
}*/