package dev.yeff.orbital;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.TransformComponent;

import static com.raylib.Raylib.*;

public class Collider {
    public static boolean rectWithRect(GameObject obj1, GameObject obj2) {
        Jaylib.Rectangle rect1 = new Jaylib.Rectangle(
                obj1.getComponent(TransformComponent.class).position.x,
                obj1.getComponent(TransformComponent.class).position.y,
                obj1.getComponent(TransformComponent.class).scale.x,
                obj1.getComponent(TransformComponent.class).scale.y
        );

        Jaylib.Rectangle rect2 = new Jaylib.Rectangle(
                obj2.getComponent(TransformComponent.class).position.x,
                obj2.getComponent(TransformComponent.class).position.y,
                obj2.getComponent(TransformComponent.class).scale.x,
                obj2.getComponent(TransformComponent.class).scale.y
        );

        return CheckCollisionRecs(rect1, rect2);
    }

    public static boolean circleWithCircle(GameObject obj1, GameObject obj2) {
        Raylib.Vector2 center1 = obj1.getComponent(TransformComponent.class).position.asRaylibVector();
        Raylib.Vector2 center2 = obj2.getComponent(TransformComponent.class).position.asRaylibVector();

        float radius1 = obj1.getComponent(TransformComponent.class).scale.x;
        float radius2 = obj2.getComponent(TransformComponent.class).scale.x;

        return CheckCollisionCircles(center1, radius1, center2, radius2);
    }

    public static boolean circleWithRect(GameObject circle, GameObject rectangle) {
        Raylib.Vector2 center = circle.getComponent(TransformComponent.class).position.asRaylibVector();
        float radius = circle.getComponent(TransformComponent.class).scale.x;

        Jaylib.Rectangle rect = new Jaylib.Rectangle(
                rectangle.getComponent(TransformComponent.class).position.x,
                rectangle.getComponent(TransformComponent.class).position.y,
                rectangle.getComponent(TransformComponent.class).scale.x,
                rectangle.getComponent(TransformComponent.class).scale.y
        );

        return CheckCollisionCircleRec(center, radius, rect);
    }
}
