package dev.yeff.orbital;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.ecs.components.collision.ColliderComponent;

import static com.raylib.Raylib.*;

public class CollisionChecker {
    private static Jaylib.Rectangle getRect(GameObject obj) {
        if (obj.hasComponent(TransformComponent.class))
            return new Jaylib.Rectangle(
                    obj.getComponent(TransformComponent.class).position.x,
                    obj.getComponent(TransformComponent.class).position.y,
                    obj.getComponent(TransformComponent.class).scale.x,
                    obj.getComponent(TransformComponent.class).scale.y
            );
        else
            throw new IllegalStateException("Transform component required to get rectangle.");
    }

    public static boolean rectWithRect(GameObject obj1, GameObject obj2) {
        if (obj1.hasComponent(ColliderComponent.class) && obj2.hasComponent(ColliderComponent.class)) {
            Jaylib.Rectangle rect1 = getRect(obj1);
            Jaylib.Rectangle rect2 = getRect(obj2);

            return CheckCollisionRecs(rect1, rect2);
        }

        throw new IllegalStateException("Both objects need to have colliders to check collision.");
    }

    public static boolean circleWithCircle(GameObject obj1, GameObject obj2) {
        if (obj1.hasComponent(ColliderComponent.class) && obj2.hasComponent(ColliderComponent.class)) {
            Raylib.Vector2 center1 = obj1.getComponent(TransformComponent.class).position.asRaylibVector();
            Raylib.Vector2 center2 = obj2.getComponent(TransformComponent.class).position.asRaylibVector();

            float radius1 = obj1.getComponent(TransformComponent.class).scale.x;
            float radius2 = obj2.getComponent(TransformComponent.class).scale.x;

            return CheckCollisionCircles(center1, radius1, center2, radius2);
        }

        throw new IllegalStateException("Both objects need to have colliders to check collision.");
    }

    public static boolean circleWithRect(GameObject circle, GameObject rectangle) {
        if (circle.hasComponent(ColliderComponent.class) && rectangle.hasComponent(ColliderComponent.class)) {

            Raylib.Vector2 center = circle.getComponent(TransformComponent.class).position.asRaylibVector();
            float radius = circle.getComponent(TransformComponent.class).scale.x;

            Jaylib.Rectangle rect = getRect(rectangle);

            return CheckCollisionCircleRec(center, radius, rect);
        }

        throw new IllegalStateException("Both objects need to have colliders to check collision.");
    }
}
