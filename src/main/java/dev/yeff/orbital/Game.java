package dev.yeff.orbital;

import dev.yeff.orbital.graphics.Renderer;
import dev.yeff.orbital.graphics.Window;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.scenes.SceneManager;

import com.raylib.Raylib.Camera2D;

import lombok.Getter;

import java.util.Map;

public class Game {
    @Getter
    private int width, height;

    @Getter
    private String title;

    @Getter
    private Scene currentScene;

    @Getter
    private Camera2D cam;

    @Getter
    private Renderer renderer;

    private Window window;

    public Game(int width, int height, String title, Map<String, Scene> scenes) {
        this.width = width;
        this.height = height;
        this.title = title;
        this.cam = new Camera2D();
        this.renderer = new Renderer();

        scenes.forEach((n, s) -> SceneManager.addScene(n, s));
        this.window = new Window(this);
    }

    public void start(String scene) {
        currentScene = SceneManager.getScene(scene);
        window.start();
    }

    public void loadScene(String scene) {
        currentScene = SceneManager.getScene(scene);
        currentScene.init(this);
    }
}
