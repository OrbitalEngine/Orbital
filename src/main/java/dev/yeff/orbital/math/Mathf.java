package dev.yeff.orbital.math;

import static com.raylib.Raylib.GetRandomValue;
import static com.raylib.Raylib.SetRandomSeed;

/**
 * Provides mathematical functions to work with vectors and more.
 *
 * @author YeffyCodeGit
 */
public class Mathf {
    // Disable constructor
    private Mathf() { }

    /**
     * Calculates the dot product of two vectors.
     *
     * @param first The first vector.
     * @param other The second vector.
     * @return The dot product of the two vectors.
     */
    public static float dot(Vector2f first, Vector2f other) {
        return (first.x * other.x) + (first.y * other.y);
    }

    /**
     * Calculates the cross product of two vectors.
     *
     * @param first The first vector.
     * @param other The second vector.
     * @return The cross product of the two vectors.
     */
    public static float cross(Vector2f first, Vector2f other) {
        return (first.x * other.y) - (first.y * other.x);
    }

    /**
     * Sets the seed to be used by the random number generator.
     *
     * @param seed The random seed.
     */
    public static void setRandomSeed(int seed) {
        SetRandomSeed(seed);
    }

    /**
     * Returns a vector with the same direction as the specified vector, but with a length of one.
     *
     * @param source The vector to normalize.
     * @return The normalized vector.
     */
    public static Vector2f normalize(Vector2f source) {
        float length = source.getMagnitude();

        if (length <= 0)
            throw new IllegalStateException("Length is less than 0, cannot normalize");

        return new Vector2f(source.x / length, source.y / length);
    }

    /**
     * Returns a random vector whose x and y components are based on given minimum and maximum values.
     *
     * @param min The minimum value the x or y components can be.
     * @param max The maximum value the x or y components can be.
     * @return The random vector.
     */
    public static Vector2f generateRandomVec(int min, int max) {
        return new Vector2f(GetRandomValue(min, max), GetRandomValue(min, max));
    }

    /**
     * Returns a random vector whose x and y components are based on given minimum and maximum values.
     *
     * @param min The minimum value the result can be.
     * @param max The maximum value the result can be.
     * @return The random vector.
     */
    public static Vector2f generateRandomVec(Vector2f min, Vector2f max) {
        return new Vector2f(GetRandomValue((int) min.x, (int) max.x), GetRandomValue((int) min.y, (int) max.y));
    }

    /**
     * Linearly interpolates between {@code a} and {@code b} by interpolation point t.
     *
     * @param a The starting value, this will be returned if t = 0.
     * @param b The ending value, this will be returned if t = 1.
     * @param t The value used to interpolate between {@code a} and {@code b}
     * @return The interpolated value.
     */
    public static float lerp(float a, float b, float t) {
        return a * (1.0f - t) + t * b;
    }

    /**
     * Calculates the linear interpolation value based on the range of {@code a} and {@code b}, and {@code v}.
     *
     * @param a The starting value.
     * @param b The ending value.
     * @param v The result of the linear interpolation between {@code a} and {@code b}.
     * @return The value, which when used to calculate linear interpolation with the same {@code a} and {@code b} values, results in {@code v}.
     */
    public static float inverseLerp(float a, float b, float v) {
        return (v - a) / (b - a);
    }
}
