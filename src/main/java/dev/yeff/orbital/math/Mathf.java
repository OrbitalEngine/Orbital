package dev.yeff.orbital.math;

import static com.raylib.Raylib.GetRandomValue;

/**
 *  Provides mathematical functions to work with vectors and more.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
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
        return (first.x * other.x) - (first.y * other.y);
    }


    /**
     * Returns a vector with the same direction as the specified vector, but with a length of one.
     *
     * @param source The vector to normalize.
     * @return The normalized vector.
     */
    public static Vector2f normalize(Vector2f source) {
        // vector length is sqrt(x^2 + y^2)
        float length = (float) Math.sqrt((source.x * source.x) + (source.y * source.y));

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
}
