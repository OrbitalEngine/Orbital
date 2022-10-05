package dev.yeff.orbital.physics.collision;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.ecs.components.collision.ColliderComponent;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.util.RaylibUtil;

import static com.raylib.Raylib.*;

/**
 * Class implementing functions to check for collision between {@code GameObject}'s.
 *
 * @author YeffyCodeGit
 */
public class Collision {
    /**
     * Returns a {@code Jaylib.Rectangle} from a {@code GameObject}, to use in the collision functions.
     *
     * @param obj The game object to get the rectangle from.
     * @throws IllegalStateException If there was an error creating the rect from the game object.
     * @return The rectangle.
     */
    private static Jaylib.Rectangle getRect(GameObject obj) {
        if (obj.hasComponent(TransformComponent.class) && obj.hasComponent(ColliderComponent.class)) {
            TransformComponent transformComponent = obj.getComponent(TransformComponent.class);
            ColliderComponent colliderComponent = obj.getComponent(ColliderComponent.class);

            return new Jaylib.Rectangle(
                    transformComponent.position.x,
                    transformComponent.position.y,
                    colliderComponent.colliderScale.x,
                    colliderComponent.colliderScale.y
            );
        } else {
            throw new IllegalStateException("Transform component required to get rectangle.");
        }
    }

    /**
     * Checks if two {@code GameObject}'s are colliding with each other.
     *
     * @param obj1 The first object.
     * @param obj2 The second object.
     * @throws IllegalStateException If there was an error checking the collision.
     * @return If the two objects are colliding or not.
     */
    public static boolean isColliding(GameObject obj1, GameObject obj2) {
        if (obj1.getComponent(ColliderComponent.class).renderShape == Shapes.RECTANGLE || obj1.getComponent(ColliderComponent.class).renderShape == Shapes.RECTANGLE_OUTLINE
            && obj2.getComponent(ColliderComponent.class).renderShape == Shapes.RECTANGLE || obj1.getComponent(ColliderComponent.class).renderShape == Shapes.RECTANGLE_OUTLINE)
                return rectWithRect(obj1, obj2);
        else if (obj1.getComponent(ColliderComponent.class).renderShape == Shapes.CIRCLE || obj1.getComponent(ColliderComponent.class).renderShape == Shapes.CIRCLE_OUTLINE
                && obj2.getComponent(ColliderComponent.class).renderShape == Shapes.CIRCLE || obj1.getComponent(ColliderComponent.class).renderShape == Shapes.CIRCLE_OUTLINE)
                    return circleWithCircle(obj1, obj2);
        else if (obj1.getComponent(ColliderComponent.class).renderShape == Shapes.RECTANGLE || obj1.getComponent(ColliderComponent.class).renderShape == Shapes.RECTANGLE_OUTLINE
                && obj2.getComponent(ColliderComponent.class).renderShape == Shapes.CIRCLE || obj1.getComponent(ColliderComponent.class).renderShape == Shapes.CIRCLE_OUTLINE)
                    return circleWithRect(obj2, obj1);
        else if (obj1.getComponent(ColliderComponent.class).renderShape == Shapes.CIRCLE || obj1.getComponent(ColliderComponent.class).renderShape == Shapes.CIRCLE_OUTLINE
                && obj2.getComponent(ColliderComponent.class).renderShape == Shapes.RECTANGLE || obj1.getComponent(ColliderComponent.class).renderShape == Shapes.RECTANGLE_OUTLINE)
            return circleWithRect(obj1, obj2);
        else
            throw new IllegalStateException("Unknown collision shapes.");
    }

    /**
     * Checks if two rectangle shaped {@code GameObject}'s are colliding with each other.
     *
     * @param obj1 The first object.
     * @param obj2 The second object.
     * @throws IllegalStateException If there was an error checking the collision.
     * @return If the two objects are colliding or not.
     */
    private static boolean rectWithRect(GameObject obj1, GameObject obj2) {
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
     * @throws IllegalStateException If there was an error checking the collision.
     * @return If the two objects are colliding or not.
     */
    private static boolean circleWithCircle(GameObject obj1, GameObject obj2) {
        if (obj1.hasComponent(ColliderComponent.class) && obj2.hasComponent(ColliderComponent.class)) {
            Raylib.Vector2 center1 = RaylibUtil.getAsRaylibVec2(obj1.getComponent(TransformComponent.class).position);
            Raylib.Vector2 center2 = RaylibUtil.getAsRaylibVec2(obj2.getComponent(TransformComponent.class).position);

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
     * @throws IllegalStateException If there was an error checking the collision.
     * @return If the two objects are colliding or not.
     */
    private static boolean circleWithRect(GameObject circle, GameObject rectangle) {
        if (circle.hasComponent(ColliderComponent.class) && rectangle.hasComponent(ColliderComponent.class)) {
            Raylib.Vector2 center = RaylibUtil.getAsRaylibVec2(circle.getComponent(TransformComponent.class).position);
            float radius = circle.getComponent(ColliderComponent.class).colliderScale.x;

            Jaylib.Rectangle rect = getRect(rectangle);

            return CheckCollisionCircleRec(center, radius, rect);
        }

        throw new IllegalStateException("Both objects need to have colliders to check collision.");
    }
}
