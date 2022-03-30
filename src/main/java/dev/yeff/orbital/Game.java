package dev.yeff.orbital;

import dev.yeff.orbital.audio.AudioManager;
import dev.yeff.orbital.graphics.Renderer;
import dev.yeff.orbital.graphics.Window;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.scenes.SceneManager;

import com.raylib.Raylib.Camera2D;

import dev.yeff.orbital.util.Log;
import lombok.Getter;

import java.util.Map;
import java.util.Optional;


/**
 * The main class that is used to create a game using the Orbital Game Engine.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class Game {
    @Getter
    private Vector2f size;

    @Getter
    private String title;

    @Getter
    private Scene currentScene;

    @Getter
    private Camera2D cam;

    @Getter
    private Renderer renderer;

    private Window window;

    public Game(Vector2f size, String title, Map<String, Scene> scenes) {
        this.size = size;
        this.title = title;
        this.cam = new Camera2D();
        this.renderer = new Renderer();

        scenes.forEach(SceneManager::addScene);
        this.window = new Window(this);
    }

    /**
     * Starts the game using the name of the scene provided.
     *
     * @param scene The scene to start the game with.
     */
    public void start(String scene) {
        currentScene = SceneManager.getScene(scene);
        window.start();
    }

    /**
     * Loads and starts a new scene and disposes the old one.
     *
     * @param scene The scene to load.
     */
    public void loadScene(String scene) {
        // dispose current scene before loading new one
        currentScene.dispose(this);

        currentScene = SceneManager.getScene(scene);
        currentScene.init(this);
        Log.info(Game.class, "Loaded scene " + scene);
    }

    /**
     * Returns the center position of the screen.
     *
     * @return The screen center position.
     */
    public Vector2f getScreenCenter() {
        return new Vector2f(size.x / 2, size.y / 2);
    }
}
