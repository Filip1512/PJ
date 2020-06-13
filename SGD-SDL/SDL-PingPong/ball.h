#pragma once

#include "SDL.h"
#include "SDL_image.h"

class Ball
{
public:
    Ball() = default;
    ~Ball();

    void init(SDL_Renderer* renderer, int x, int y);
    void update(double delta_time);
    void draw(SDL_Renderer* renderer);


private:
    int m_velocity;
    double m_x;
    SDL_Texture* m_image;
    SDL_Rect m_position;
};