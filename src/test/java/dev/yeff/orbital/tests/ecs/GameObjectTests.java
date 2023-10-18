package dev.yeff.orbital.tests.ecs;

import com.raylib.Raylib;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.ecs.components.render.LineComponent;
import dev.yeff.orbital.ecs.components.render.RenderShapeComponent;
import dev.yeff.orbital.ecs.components.render.SpriteComponent;
import dev.yeff.orbital.ecs.components.render.TextComponent;
import dev.yeff.orbital.graphics.Color;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.tests.mock.MockScene;

import java.util.Map;
import java.util.Optional;
import org.assertj.core.api.WithAssertions;
import org.joml.Vector2f;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("test game objects creation and adding components to game objects")
public class GameObjectTests implements WithAssertions {
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

  @DisplayName("create game object with no components using builder")
  @Test
  public void testCreateGameObject_usingBuilder() {
    GameObject object = new GameObjectBuilder(mockScene)
            .build(game);

    assertThat(object).isNotNull();
  }

  @DisplayName("create game object with transform component using builder")
  @Test
  public void testCreateGameObject_withTransform_usingBuilder() {
    GameObject object =
        new GameObjectBuilder(mockScene)
            .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(0.0f, 0.0f))
            .build(game);

    assertThat(object.hasComponent(TransformComponent.class)).isTrue();

    assertThat(object.getComponent(TransformComponent.class).position)
        .extracting("x", "y")
        .contains(0.0f, 0.0f);

    assertThat(object.getComponent(TransformComponent.class).scale)
        .extracting("x", "y")
        .contains(0.0f, 0.0f);
  }

  @DisplayName("create game object with render shape component using builder")
  @Test
  public void testCreateGameObject_withShape_usingBuilder() {
    GameObject object =
        new GameObjectBuilder(mockScene).withShape(Shapes.CIRCLE, Color.RED).build(game);

    assertThat(object.hasComponent(RenderShapeComponent.class)).isTrue();
    assertThat(object.getComponent(RenderShapeComponent.class))
        .extracting("shape", "color")
        .contains(Shapes.CIRCLE, Optional.of(Color.RED));
  }

  @DisplayName("create game object with text component using builder")
  @Test
  public void testCreateGameObject_withText_usingBuilder() {
    GameObject object =
        new GameObjectBuilder(mockScene).withText("Hello World", 0.0f).build(game);

    assertThat(object.hasComponent(TextComponent.class)).isTrue();
    assertThat(object.getComponent(TextComponent.class))
        .extracting("fontSize", "text", "font")
        .contains(0.0f, "Hello World", null);
  }

  @DisplayName("create game object with line component using builder")
  @Test
  public void testCreateGameObject_withLine_usingBuilder() {
    GameObject object =
        new GameObjectBuilder(mockScene)
            .withLine(new Vector2f(0.0f, 0.0f), new Vector2f(0.0f, 0.0f), 0.0f, Color.RED)
            .build(game);

    assertThat(object.hasComponent(LineComponent.class)).isTrue();

    assertThat(object.getComponent(LineComponent.class).start)
        .extracting("x", "y")
        .contains(0.0f, 0.0f);

    assertThat(object.getComponent(LineComponent.class).end)
        .extracting("x", "y")
        .contains(0.0f, 0.0f);

    assertThat(object.getComponent(LineComponent.class))
        .extracting("color", "thickness")
        .contains(Color.RED, 0.0f);
  }

  @DisplayName("create game object with sprite component using builder")
  @Test
  public void testCreateGameObject_withSprite_usingBuilder() {
    Raylib.InitWindow(100, 100, "Test window");
    GameObject object =
        new GameObjectBuilder(mockScene)
            .withSprite(ResourceManager.getSprite(getClass(), "character_0000.png"))
            .build(game);

    assertThat(object.hasComponent(SpriteComponent.class)).isTrue();
    assertThat(object.getComponent(SpriteComponent.class).sprite).isNotNull();
  }
}
