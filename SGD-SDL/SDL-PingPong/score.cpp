/*#include "pong.h"
#include "SDL.h"
#include "SDL_ttf.h"
#include "score.h"

#include <sstream>
#include <string>
#include "pong.cpp"

Score::~Score()
{
	SDL_DestroyTexture(Message);
	SDL_FreeSurface(messageSurface);
}

Score::Score(SDL_Renderer* renderer)
{
	TTF_Init();
	TTF_Font* arial = TTF_OpenFont("arial.ttf", 128);
	SDL_Color msg_color = { 255,255,255 };

	char msg[128];
	sprintf_s(msg, "%d %d", g_SCORE_P_LEFT, g_SCORE_P_RIGHT);

	SDL_Surface* messageSurface = TTF_RenderText_Solid(arial, msg, msg_color);
	SDL_Texture* Message = SDL_CreateTextureFromSurface(renderer, messageSurface);

	msg_rect.y = 0;
	msg_rect.w = 30;
	msg_rect.h = 30;
	msg_rect.x = (g_GAME_WIDTH / 2) - (50 / 2) + (msg_rect.w / 2) - 6;

	TTF_CloseFont(arial);
	TTF_Quit();
}

void Score::draw(SDL_Renderer* renderer)
{
	SDL_RenderCopy(renderer, Message, NULL, &msg_rect);
}*/