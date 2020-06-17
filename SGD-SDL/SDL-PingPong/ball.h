#pragma once

#include "SDL.h"
#include "SDL_image.h"
#include "paddle.h"

class Ball
{
public:
    
    Ball() = default;
    ~Ball();

    Ball(Paddle paddle)
    {
        this->p_position = paddle.p_position;
    };

    void init(SDL_Renderer* renderer, int x, int y);
    void update(double delta_time);
    void draw(SDL_Renderer* renderer);    

private:
    int             b_velocity_x;
    int             b_velocity_y;
    double          b_current_x;
    double          b_current_y;
    SDL_Texture*    b_image;
    SDL_Rect        b_position;
    SDL_Rect        p_position;
};