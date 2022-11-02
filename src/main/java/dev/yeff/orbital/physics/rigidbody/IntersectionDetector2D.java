package dev.yeff.orbital.physics.rigidbody;

import dev.yeff.orbital.ecs.components.render.LineComponent;
import dev.yeff.orbital.math.OrbitalMath;
import dev.yeff.orbital.physics.primitives.Box2D;
import dev.yeff.orbital.physics.primitives.Circle2D;
import org.joml.Vector2f;

import javax.swing.*;

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

    public static boolean lineInCirce(LineComponent line, Circle2D circle) {
        if (pointInCircle(line.start, circle) || pointInCircle(line.end, circle)) {
            return true;
        }

        Vector2f ab = new Vector2f(line.end).sub(line.start);

        // projection point (circle position) onto ab (line segment)
        // parameterized position t
        Vector2f circleCenter = circle.getCenter();
        Vector2f circleToLineStart = new Vector2f(circleCenter).sub(line.start);
        float t = circleToLineStart.dot(ab) / ab.dot(ab);

        // check if t is on the line segment
        if (t < 0.0f || t > 1.0f) return false;

        // find the closest point to line segment
        Vector2f closestPoint = new Vector2f(line.start).add(ab.mul(t));

        return pointInCircle(closestPoint, circle);
    }
}
