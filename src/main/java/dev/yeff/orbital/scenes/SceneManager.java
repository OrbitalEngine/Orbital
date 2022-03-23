package dev.yeff.orbital.scenes;

import java.util.HashMap;
import java.util.Map;

/**
 * Keeps track of all the scenes registered in the {@code Game} constructor.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class SceneManager {
    // Disable constructor
    private SceneManager() { }

    private static Map<String, Scene> scenes = new HashMap<>();

    public static void addScene(String name, Scene scene) {
        scenes.put(name, scene);
    }

    public static Scene getScene(String sceneName) {
        return scenes.get(sceneName);
    }
}
