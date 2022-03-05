package dev.yeff.orbital;

import dev.yeff.orbital.graphics.Window;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.scenes.SceneManager;
import dev.yeff.orbital.util.Time;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.HashMap;
import java.util.Map;

public class Game {
    private boolean isRunning;
    private static float UPDATE_CAP = 0;
    private float width, height;
    private String title;

    private Input input;
    private Window window;
    private Scene currentScene;

    public Game(float updateCap, float width, float height, String title, Map<String, Scene> scenes) {
        UPDATE_CAP = 1.0f / updateCap;
        this.width = width;
        this.height = height;
        this.title = title;

        scenes.forEach((name, scene) -> SceneManager.addScene(name, scene));
    }

    public void start(String sceneName) {
        window = new Window(width, height, title);

        window.getCanvas().addKeyListener(input.getKeyboard());
        window.getCanvas().addMouseListener(input.getMouse());

        currentScene = SceneManager.getScene(sceneName);
        currentScene.init(this);

        isRunning = true;
        run();
    }

    private void run() {
        float lastTime = Time.getTime();
        float lag = 0.0f;

        while (true) {
            float current = Time.getTime();
            float elapsed = current - lastTime;
            lastTime = current;
            lag += elapsed;

            while (lag >= UPDATE_CAP) {
                lag -= UPDATE_CAP;

                currentScene.update(this, elapsed);
                window.update();
            }
        }
    }

    public void loadScene(String sceneName) {
        currentScene = SceneManager.getScene(sceneName);
        currentScene.init(this);
    }

    public Canvas getFrame() {
        return window.getCanvas();
    }

    public Input getInput() {
        return input;
    }

    public float getUpdateCap() {
        return UPDATE_CAP;
    }
}
