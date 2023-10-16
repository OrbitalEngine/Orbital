package dev.yeff.orbital.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import java.util.ArrayList;
import java.util.List;

import dev.yeff.orbital.ecs.components.TagComponent;
import dev.yeff.orbital.util.Log;
import lombok.Getter;

/**
 * Abstract class defining a scene.
 *
 * @author YeffyCodeGit
 */
public abstract class Scene {
  private boolean isRunning = false;

  @Getter private List<GameObject> objects;

  public Scene() {
    objects = new ArrayList<>();
  }

  /**
   * Finds and returns a specific {@code GameObject} using the tag stored in the {@code TagComponent}.
   * @implNote If any GameObject in the scene does not have a {@code TagComponent}, the function will not be able to find that object as it searches using that {@code TagComponent}.
   *
   * @param id The id of the game object.
   * @return The game object, null if not found.
   */
  public GameObject findObject(String id) {
    for (GameObject go : objects) {
      if (go.hasComponent(TagComponent.class)) {
        if (go.getComponent(TagComponent.class).tagName == id) {
          return go;
        }
      }
    }

    return null;
  }

  /**
   * Initializes all {@code GameObject}'s added to the scene.
   *
   * @param game The instance of the game.
   */
  public void initInternal(Game game) {
    isRunning = true;

    for (GameObject go : objects) {
      go.internalInit(game);
      go.init(game);
    }
  }

  /**
   * Adds a new {@code GameObject} to the scene.
   *
   * @param game The instance of the game.
   * @param gameObject The game object to add.
   */
  public void addGameObject(Game game, GameObject gameObject) {
    if (!gameObject.hasComponent(TagComponent.class))
      Log.warn(getClass(), "This object does not have a tag, therefore any functions requiring object id's will not work." +
              " To add one, add a TagComponent to the object with your desired name.");

    if (!isRunning) {
      objects.add(gameObject);
    } else {
      objects.add(gameObject);
      gameObject.internalInit(game);
    }
  }

  /**
   * Removes a {@code GameObject} from the scene.
   *
   * @param object The object to remove.
   */
  public void removeGameObject(GameObject object) {
    objects.remove(object);
  }

  /**
   * Removes a {@code GameObject} from the scene.
   *
   * @param id The ID of the object.
   */
  public void removeGameObject(String id) {
    objects.stream()
            .filter(object -> object.hasComponent(TagComponent.class))
            .filter(object -> object.getComponent(TagComponent.class).tagName == id)
            .forEach(object -> objects.remove(object));
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
