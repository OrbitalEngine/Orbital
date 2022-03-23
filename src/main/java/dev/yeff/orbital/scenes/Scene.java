package dev.yeff.orbital.scenes;

import dev.yeff.orbital.Game;

/**
 * Interface to define a scene.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public interface Scene {
    void init(Game game);

    void update(Game game, float fps);

    void dispose(Game game);
}