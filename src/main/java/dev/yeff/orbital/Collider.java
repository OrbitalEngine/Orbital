package dev.yeff.orbital;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.math.Vector2f;

import static com.raylib.Raylib.CheckCollisionCircles;
import static com.raylib.Raylib.CheckCollisionRecs;

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
}
