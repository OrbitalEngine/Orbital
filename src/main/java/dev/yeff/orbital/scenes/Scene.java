package dev.yeff.orbital.scenes;

import dev.yeff.orbital.Game;

/**
 * Interface to define a scene.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public interface Scene {
    /**
     * Gets called when the scene is first initialized.
     *
     * @param game The game that initialized the scene.
     */
    void init(Game game);

    /**
     * Gets called every frame.
     *
     * @param game The game that is running the scene.
     * @param fps The current frames per second.
     */
    void update(Game game, float fps);

    /**
     * Gets called right before the scene is unloaded and a new scene is initialized.
     *
     * @param game THe game that is disposing the scene.
     */
    void dispose(Game game);
}