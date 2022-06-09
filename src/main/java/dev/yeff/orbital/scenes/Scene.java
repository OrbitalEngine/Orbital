package dev.yeff.orbital.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import lombok.Getter;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    /**
     * Finds and returns a specific {@code GameObject} using the ID.
     *
     * @param id The id of the game object.
     * @return The game object, null if not found.
     */
    public GameObject findObject(String id) {
        for (GameObject go : objects)
            if (go.getId() == id)
                return go;

        return null;
    }

    /**
     * Initializes all {@code GameObject}'s added to the scene.
     *
     * @param game The instance of the game.
     */
    public void initInternal(Game game) {
        isRunning = true;

        for (GameObject go : objects)
            go.init(game);
    }

    /**
     * Adds a new {@code GameObject} to the scene.
     *
     * @param game The instance of the game.
     * @param gameObject The game object to add.
     */
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