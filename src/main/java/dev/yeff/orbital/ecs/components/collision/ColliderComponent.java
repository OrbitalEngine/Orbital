package dev.yeff.orbital.ecs.components.collision;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.graphics.Shapes;
import org.joml.Vector2f;

/**
 * Component storing data for collision between objects.
 *
 * @author YeffyCodeGit
 */
public class ColliderComponent extends Component {
  public Shapes renderShape;
  public Vector2f colliderScale;

  public ColliderComponent(Shapes renderShape, Vector2f colliderScale) {
    this.renderShape = renderShape;
    this.colliderScale = colliderScale;
  }

  @Override
  public void init(Game game) {}

  @Override
  public void update(Game game) {}
}
