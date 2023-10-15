package dev.yeff.orbital.ecs.components.render;

import static dev.yeff.orbital.graphics.Renderer.drawTexture;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.resources.Sprite;
import org.joml.Vector2f;

/**
 * Stores data to render a sprite component.
 *
 * @author YeffyCodeGit
 */
public class SpriteComponent extends DrawableComponent {
  public Sprite sprite;

  public SpriteComponent(Sprite sprite) {
    this.sprite = sprite;
  }

  @Override
  public void init(Game game) {}

  @Override
  public void update(Game game) {
    Vector2f position = parent.getBehaviour(TransformComponent.class).position;
    Vector2f scale = parent.getBehaviour(TransformComponent.class).scale;

    sprite.resize(scale);

    drawTexture(sprite, position);
  }
}
