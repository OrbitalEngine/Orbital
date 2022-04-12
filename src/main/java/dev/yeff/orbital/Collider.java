package dev.yeff.orbital;

import com.raylib.Jaylib;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.math.Vector2f;

import static com.raylib.Raylib.CheckCollisionRecs;

public class Collider {
    public static boolean isColliding(GameObject object1, GameObject object2) {
        Vector2f firstObjPosition = object1.getComponent(TransformComponent.class).position;
        Vector2f secondObjPosition = object2.getComponent(TransformComponent.class).position;

        Vector2f secondObjScale = object1.getComponent(TransformComponent.class).scale;
        Vector2f firstObjScale = object2.getComponent(TransformComponent.class).scale;

        Jaylib.Rectangle rect1 = new Jaylib.Rectangle(firstObjPosition.x, firstObjPosition.y, firstObjScale.x, secondObjPosition.y);
        Jaylib.Rectangle rect2 = new Jaylib.Rectangle(secondObjPosition.x, secondObjPosition.y, secondObjScale.x, secondObjPosition.y);

        return CheckCollisionRecs(rect1, rect2);
    }
}
