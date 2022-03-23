package dev.yeff.orbital.math;

import static com.raylib.Raylib.GetRandomValue;

public class Mathf {
    public static float dot(Vector2f first, Vector2f other) {
        return (first.x * other.x) + (first.y * other.y);
    }

    public static float cross(Vector2f first, Vector2f other) {
        return (first.x * other.x) - (first.y * other.y);
    }

    public static Vector2f normalize(Vector2f source) {
        // vector length is sqrt(x^2 + y^2)
        float length = (float) Math.sqrt((source.x * source.x) + (source.y * source.y));

        return new Vector2f(source.x / length, source.y / length);
    }

    public static Vector2f generateRandomVec(int min, int max) {
        return new Vector2f(GetRandomValue(min, max), GetRandomValue(min, max));
    }

    public static Vector2f generateRandomVec(Vector2f xRange, Vector2f yRange) {
        return new Vector2f(GetRandomValue((int) xRange.x, (int) xRange.y), GetRandomValue((int) yRange.x, (int) yRange.y));
    }
}
