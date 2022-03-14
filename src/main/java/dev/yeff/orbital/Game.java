package dev.yeff.orbital;

import dev.yeff.orbital.io.Window;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.scenes.SceneManager;
import lombok.Getter;

import java.util.Map;

public class Game {
    @Getter
    private int width, height;

    @Getter
    private String title;

    @Getter
    private Scene currentScene;

    private Window window;

    public Game(int width, int height, String title, Map<String, Scene> scenes) {
        this.width = width;
        this.height = height;
        this.title = title;

        scenes.forEach((n, s) -> SceneManager.addScene(n, s));
        this.window = new Window(this);
    }

    public void start(String scene) {
        currentScene = SceneManager.getScene(scene);
        window.start();
    }
}
