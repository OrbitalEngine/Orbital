package dev.yeff.orbital.tests.physics.collision;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.ecs.components.collision.ColliderComponent;
import dev.yeff.orbital.graphics.Color;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.physics.collision.Collision;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.tests.mock.MockScene;
import org.assertj.core.api.WithAssertions;
import org.joml.Vector2f;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

@DisplayName("tests collision between objects")
public class CollisionTests implements WithAssertions {
  private static Scene mockScene;
  private static Game game;

  @BeforeAll
  public static void setup() {
    mockScene = new MockScene();
    Map<String, Scene> scenes = Map.of(
            "Mock", mockScene
    );

    game = new Game(new Vector2f(0, 0), "[GAME_OBJECT_TEST_RUNNER]", scenes, false, 60.0f);
  }

  @DisplayName("test rectangle objects colliding")
  @Test
  public void testCollision_betweenRectangleObjects() {
    GameObject object1 =
        new GameObjectBuilder(mockScene)
            .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(50.0f, 50.f))
            .withShape(Shapes.RECTANGLE, new Color(255, 0, 0, 255))
            .withComponents(new ColliderComponent(Shapes.RECTANGLE, new Vector2f(50.0f, 50.f)))
            .build(game);

    GameObject object2 =
        new GameObjectBuilder(mockScene)
            .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(20.0f, 20.f))
            .withShape(Shapes.RECTANGLE, new Color(255, 0, 0, 255))
            .withComponents(new ColliderComponent(Shapes.RECTANGLE, new Vector2f(20.0f, 20.0f)))
            .build(game);

    assertThat(Collision.isColliding(object1, object2)).isTrue();
  }

  @DisplayName("test circle objects colliding")
  @Test
  public void testCollision_betweenCircleObjects() {
    GameObject object1 =
        new GameObjectBuilder(mockScene)
            .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(50.0f, 50.f))
            .withShape(Shapes.CIRCLE, new Color(255, 0, 0, 255))
            .withComponents(new ColliderComponent(Shapes.CIRCLE, new Vector2f(50.0f, 50.0f)))
            .build(game);

    GameObject object2 =
        new GameObjectBuilder(mockScene)
            .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(20.0f, 20.f))
            .withShape(Shapes.CIRCLE, new Color(255, 0, 0, 255))
            .withComponents(new ColliderComponent(Shapes.CIRCLE, new Vector2f(20.0f, 20.0f)))
            .build(game);

    assertThat(Collision.isColliding(object1, object2)).isTrue();
  }

  @DisplayName("test circle and rectangle objects colliding")
  @Test
  public void testCollision_betweenCircle_andRectObjects() {
    GameObject circle =
        new GameObjectBuilder(mockScene)
            .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(50.0f, 50.f))
            .withShape(Shapes.CIRCLE, new Color(255, 0, 0, 255))
            .withComponents(new ColliderComponent(Shapes.CIRCLE, new Vector2f(50.0f, 50.0f)))
            .build(game);

    GameObject rect =
        new GameObjectBuilder(mockScene)
            .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(20.0f, 20.f))
            .withShape(Shapes.RECTANGLE, new Color(255, 0, 0, 255))
            .withComponents(new ColliderComponent(Shapes.RECTANGLE, new Vector2f(20.0f, 20.0f)))
            .build(game);

    assertThat(Collision.isColliding(circle, rect)).isTrue();
  }
}
