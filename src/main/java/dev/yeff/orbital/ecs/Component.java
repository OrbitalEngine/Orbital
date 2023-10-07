package dev.yeff.orbital.ecs;

import dev.yeff.orbital.Game;

/**
 * Represents a component that can be added to a game object.
 *
 * @author YeffyCodeGit
 */
public abstract class Component {
  public GameObject parent = null;

  /**
   * Gets called when the component is initialized.
   *
   * @param game The game instance.
   */
  public abstract void init(Game game);

  /**
   * Gets called every frame, when the component updates.
   *
   * @param game The game instance.
   */
  public abstract void update(Game game);
}
