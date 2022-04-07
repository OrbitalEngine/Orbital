package dev.yeff.orbital.scenes;

import java.util.HashMap;
import java.util.Map;

/**
 * Keeps track of all the scenes registered in the {@code Game} constructor.
 *
 * @author YeffyCodeGit
 */
public class SceneManager {
    // Disable constructor
    private SceneManager() { }

    private static final Map<String, Scene> scenes = new HashMap<>();

    /**
     * Adds a new scene to the scene manager.
     *
     * @param name The name of the scene to add it as.
     * @param scene The scene class.
     */
    public static void addScene(String name, Scene scene) {
        scenes.put(name, scene);
    }

    /**
     * Gets a scene from the scene manager.
     *
     * @param sceneName The name of the scene to get.
     * @return The scene.
     */
    public static Scene getScene(String sceneName) {
        return scenes.get(sceneName);
    }
}
