package dev.yeff.orbital.scenes;

import dev.yeff.orbital.Game;

public interface Scene {
    void init(Game game);

    void update(Game game, float fps);

    void dispose(Game game);
}