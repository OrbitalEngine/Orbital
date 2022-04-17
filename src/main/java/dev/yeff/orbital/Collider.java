package dev.yeff.orbital;

import com.raylib.Jaylib;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.TransformComponent;

import static com.raylib.Raylib.CheckCollisionRecs;

public class Collider {
    public static boolean isColliding(GameObject obj1, GameObject obj2) {
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
}
