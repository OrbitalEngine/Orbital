package dev.yeff.orbital.scenes;

import java.util.HashMap;
import java.util.Map;

public class SceneManager {
    private static Map<String, Scene> scenes = new HashMap<>();

    public static void addScene(String name, Scene scene) {
        scenes.put(name, scene);
    }

    public static Scene getScene(String sceneName) {
        return scenes.get(sceneName);
    }
}
