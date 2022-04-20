package dev.yeff.orbital.physics.collision;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.ecs.components.collision.ColliderComponent;

import static com.raylib.Raylib.*;

/**
 * Class implementing functions to check for collision between {@code GameObject}'s.
 *
 * @author YeffyCodeGit
 */
public class CollisionChecker {
    /**
     * Returns a {@code Jaylib.Rectangle} from a {@code GameObject}, to use in the collision functions.
     *
     * @param obj The game object to get the rectangle from.
     * @return The rectangle.
     */
    private static Jaylib.Rectangle getRect(GameObject obj) {
        if (obj.hasComponent(TransformComponent.class) && obj.hasComponent(ColliderComponent.class))
            return new Jaylib.Rectangle(
                    obj.getComponent(TransformComponent.class).position.x,
                    obj.getComponent(TransformComponent.class).position.y,
                    obj.getComponent(ColliderComponent.class).colliderScale.x,
                    obj.getComponent(ColliderComponent.class).colliderScale.y
            );
        else
            throw new IllegalStateException("Transform component required to get rectangle.");
    }

    /**
     * Checks if two rectangle shaped {@code GameObject}'s are colliding with each other.
     *
     * @param obj1 The first object.
     * @param obj2 The second object.
     * @return If the two objects are colliding or not.
     */
    public static boolean rectWithRect(GameObject obj1, GameObject obj2) {
        if (obj1.hasComponent(ColliderComponent.class) && obj2.hasComponent(ColliderComponent.class)) {
            Jaylib.Rectangle rect1 = getRect(obj1);
            Jaylib.Rectangle rect2 = getRect(obj2);

            return CheckCollisionRecs(rect1, rect2);
        }

        throw new IllegalStateException("Both objects need to have colliders to check collision.");
    }

    /**
     * Checks if two circle shaped {@code GameObject}'s are colliding with each other.
     *
     * @param obj1 The first object.
     * @param obj2 The second object.
     * @return If the two objects are colliding or not.
     */
    public static boolean circleWithCircle(GameObject obj1, GameObject obj2) {
        if (obj1.hasComponent(ColliderComponent.class) && obj2.hasComponent(ColliderComponent.class)) {
            Raylib.Vector2 center1 = obj1.getComponent(TransformComponent.class).position.asRaylibVector();
            Raylib.Vector2 center2 = obj2.getComponent(TransformComponent.class).position.asRaylibVector();

            float radius1 = obj1.getComponent(ColliderComponent.class).colliderScale.x;
            float radius2 = obj2.getComponent(ColliderComponent.class).colliderScale.x;

            return CheckCollisionCircles(center1, radius1, center2, radius2);
        }

        throw new IllegalStateException("Both objects need to have colliders to check collision.");
    }

    /**
     * Checks if a circular and rectangular {@code GameObject} are colliding with each other.
     *
     * @param circle The circle object.
     * @param rectangle The rectangle object.
     * @return If the two objects are colliding or not.
     */
    public static boolean circleWithRect(GameObject circle, GameObject rectangle) {
        if (circle.hasComponent(ColliderComponent.class) && rectangle.hasComponent(ColliderComponent.class)) {

            Raylib.Vector2 center = circle.getComponent(TransformComponent.class).position.asRaylibVector();
            float radius = circle.getComponent(ColliderComponent.class).colliderScale.x;

            Jaylib.Rectangle rect = getRect(rectangle);

            return CheckCollisionCircleRec(center, radius, rect);
        }

        throw new IllegalStateException("Both objects need to have colliders to check collision.");
    }
}
