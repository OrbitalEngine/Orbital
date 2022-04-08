package dev.yeff.orbital.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Abstract class defining a scene.
 *
 * @author YeffyCodeGit
 */
public abstract class Scene {
    private boolean isRunning = false;

    @Getter
    private List<GameObject> objects;

    public Scene() {
        objects = new ArrayList<>();
    }

    public void initInternal(Game game) {
        isRunning = true;

        if (objects == null)
            objects = new ArrayList<>();

        for (GameObject go : objects)
            go.init(game);
    }

    public void addGameObject(Game game, GameObject gameObject) {
        if (!isRunning) {
            objects.add(gameObject);
        } else {
            objects.add(gameObject);
            gameObject.init(game);
        }
    }

    /**
     * Gets called when the scene is first initialized.
     *
     * @param game The game that initialized the scene.
     */
    public abstract void init(Game game);

    /**
     * Gets called every frame.
     *
     * @param game The game that is running the scene.
     * @param fps The current frames per second.
     */
    public abstract void update(Game game, float fps);

    /**
     * Gets called right before the scene is unloaded and a new scene is initialized.
     *
     * @param game The game that is disposing the scene.
     */
    public abstract void dispose(Game game);
}