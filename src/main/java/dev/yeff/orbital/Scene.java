package dev.yeff.orbital;

/**
 * The interface to implement when creating a new scene.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public interface Scene {
    /**
     * Initializes the scene. This function gets called once, when the scene is loaded.
     */
    void init(Window window);

    /**
     * Updates the scene. This function gets called every frame, as long as the scene is being used.
     */
    void update(Window window, float delta);

    void dispose(Window window);
}
