package dev.yeff.orbital.tests.physics.collision;

import dev.yeff.orbital.CollisionChecker;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.ecs.components.collision.ColliderComponent;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.tests.mock.MockScene;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("tests collision between objects")
public class CollisionCheckerTests implements WithAssertions {
    private static Scene mockScene;

    @BeforeAll
    public static void setup() {
        mockScene = new MockScene();
    }

    @DisplayName("test rectangle objects colliding")
    @Test
    public void testCollision_betweenRectangleObjects() {
        GameObject object1 = new GameObjectBuilder(mockScene, "Test Object 1")
                .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(50.0f, 50.f))
                .withShape(Shapes.RECTANGLE, Colors.RED)
                .withComponents(new ColliderComponent())
                .build();

        GameObject object2 = new GameObjectBuilder(mockScene, "Test Object 2")
                .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(20.0f, 20.f))
                .withShape(Shapes.RECTANGLE, Colors.RED)
                .withComponents(new ColliderComponent())
                .build();

        assertThat(CollisionChecker.rectWithRect(object1, object2)).isTrue();
    }

    @DisplayName("test circle objects colliding")
    @Test
    public void testCollision_betweenCircleObjects() {
        GameObject object1 = new GameObjectBuilder(mockScene, "Test Object 1")
                .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(50.0f, 50.f))
                .withShape(Shapes.CIRCLE, Colors.RED)
                .withComponents(new ColliderComponent())
                .build();

        GameObject object2 = new GameObjectBuilder(mockScene, "Test Object 2")
                .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(20.0f, 20.f))
                .withShape(Shapes.CIRCLE, Colors.RED)
                .withComponents(new ColliderComponent())
                .build();

        assertThat(CollisionChecker.circleWithCircle(object1, object2)).isTrue();
    }

    @DisplayName("test circle and rectangle objects colliding")
    @Test
    public void testCollision_betweenCircle_andRectObjects() {
        GameObject circle = new GameObjectBuilder(mockScene, "Test Object 1")
                .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(50.0f, 50.f))
                .withShape(Shapes.CIRCLE, Colors.RED)
                .withComponents(new ColliderComponent())
                .build();

        GameObject rect = new GameObjectBuilder(mockScene, "Test Object 2")
                .withTransform(new Vector2f(0.0f, 0.0f), new Vector2f(20.0f, 20.f))
                .withShape(Shapes.RECTANGLE, Colors.RED)
                .withComponents(new ColliderComponent())
                .build();

        assertThat(CollisionChecker.rectWithRect(circle, rect)).isTrue();
    }
}
