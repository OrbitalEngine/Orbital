package dev.yeff.orbital.physics.rigidbody;

import dev.yeff.orbital.ecs.components.render.LineComponent;
import dev.yeff.orbital.math.OrbitalMath;
import dev.yeff.orbital.physics.primitives.Box2D;
import dev.yeff.orbital.physics.primitives.Circle2D;
import org.joml.Vector2f;

public class IntersectionDetector2D {
    public static boolean pointOnLine(Vector2f point, LineComponent line) {
        // FORMULA TO CHECK POINT ON LINE
        // m = (lineEnd.x - lineStart.x) / (lineEnd.y - lineEnd.x)
        // y = mx + c

        float dy = line.end.y - line.start.y;
        float dx = line.end.x - line.start.y;
        float m = dx / dy;

        float c = line.end.y - (m * line.end.x);

        // Check equation
        return point.y == m * point.x + c;
    }

    public static boolean pointInCircle(Vector2f point, Circle2D circle) {
        // FORMULA TO CHECK POINT IN CIRCLE
        // l <= d

        Vector2f circleCenter = circle.getCenter();
        Vector2f centerToPoint = new Vector2f(point).sub(circleCenter);

        return centerToPoint.lengthSquared() <= circle.getRadius() * circle.getRadius();
    }

    public static boolean pointInBox(Vector2f point, Box2D box) {
        Vector2f min = box.getMin();
        Vector2f max = box.getMax();

        return point.x <= max.x && min.x <= point.x && point.y <= max.y && min.y <= point.y;
    }
}
