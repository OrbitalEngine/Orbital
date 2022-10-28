package dev.yeff.orbital.math;

import org.joml.Vector2f;

public class OrbitalMath {
    public static boolean compareEpsilon(float x, float y, float epsilon) {
        return Math.abs(x - y) <= epsilon * Math.max(1.0f, Math.max(Math.abs(x), Math.abs(y)));
    }

    public static boolean compareEpsilon(Vector2f a, Vector2f b, float epsilon) {
        return compareEpsilon(a.x, b.x, epsilon) && compareEpsilon(a.y, b.y, epsilon);
    }

    public static boolean compareEpsilon(float x, float y) {
        return Math.abs(x - y) <= Float.MIN_VALUE * Math.max(1.0f, Math.max(Math.abs(x), Math.abs(y)));
    }

    public static boolean compareEpsilon(Vector2f a, Vector2f b) {
        return compareEpsilon(a.x, b.x, Float.MIN_VALUE) && compareEpsilon(a.y, b.y, Float.MIN_VALUE);
    }
}
