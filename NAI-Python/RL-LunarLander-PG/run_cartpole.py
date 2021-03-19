"""

Reinforcement Learning - Policy Gradient
CartPole
Autorzy: Filip Krzysztofik, Sebastian Browarczyk

"""

import gym
from policy_gradient import PolicyGradient
import matplotlib.pyplot as plt
import numpy as np

env = gym.make('CartPole-v0')
env = env.unwrapped

# Policy gradient has high variance, seed for reproducability
env.seed(1)

print("env.action_space", env.action_space)
print("env.observation_space", env.observation_space)
print("env.observation_space.high", env.observation_space.high)
print("env.observation_space.low", env.observation_space.low)


RENDER_ENV = False      # okno z grą
EPISODES = 500          # maksymalna ilość iteracji
rewards = []            # nagroda
RENDER_REWARD_MIN = 50  # minimalna nagroda do wyrenderowania gry

if __name__ == "__main__":

    load_path = None #"output/weights/CartPole-v0.ckpt"
    save_path = None #"output/weights/CartPole-v0-temp.ckpt"

    PG = PolicyGradient(
        n_x = env.observation_space.shape[0],
        n_y = env.action_space.n,
        learning_rate=0.01,
        reward_decay=0.95,
        load_path=load_path,
        save_path=save_path
    )


    for episode in range(EPISODES):     # start nauki

        observation = env.reset()
        episode_reward = 0

        while True:
            if RENDER_ENV: env.render()

            # 1. Choose an action based on observation
            action = PG.choose_action(observation)

            # 2. Take action in the environment
            observation_, reward, done, info = env.step(action)

            # 3. Store transition for training
            PG.store_transition(observation, action, reward)

            if done:
                episode_rewards_sum = sum(PG.episode_rewards)
                rewards.append(episode_rewards_sum)
                max_reward_so_far = np.amax(rewards)

                print("==========================================")
                print("Episode: ", episode)
                print("Reward: ", episode_rewards_sum)
                print("Max reward so far: ", max_reward_so_far)

                # 4. Train neural network
                discounted_episode_rewards_norm = PG.learn()

                # Renderuj gre dopiero gdy program uzyska minimalny wynik RENDER_REWARD_MIN
                if max_reward_so_far > RENDER_REWARD_MIN: RENDER_ENV = True


                break

            # Save new observation
            observation = observation_
