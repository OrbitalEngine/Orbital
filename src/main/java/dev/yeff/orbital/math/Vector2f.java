package dev.yeff.orbital.math;

import com.raylib.Raylib;

/**
 * Represents a vector with x and y floating-point components.
 *
 * @author YeffyCodeGit
 */
public class Vector2f {
    public float x;
    public float y;

    public Vector2f(Vector2f vec2) {
        this.x = vec2.x;
        this.y = vec2.y;
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f(float value) {
        this.x = value;
        this.y = value;
    }

    public Vector2f() {
        this.x = 0;
        this.y = 0;
    }

    /**
     * Adds the x and y components of another vector to the x and y components of the current instance.
     *
     * @param other The other vector to add with.
     */
    public void add(Vector2f other) {
        x = x + other.x;
        y = y + other.y;
    }

    /**
     * Adds the x and y values to the x and y components of the current instance.
     *
     * @param x The x value to add.
     * @param y The y value to add.
     */
    public void add(float x, float y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    /**
     * Subtracts the x and y components of another vector from the x and y components of the current instance.
     *
     * @param other The other vector to subtract from.
     */
    public void subtract(Vector2f other) {
        x = x - other.x;
        y = y - other.y;
    }

    /**
     * Subtracts the x and y values from the x and y components of the current instance.
     *
     * @param x The x value to subtract.
     * @param y The y value to subtract.
     */
    public void subtract(float x, float y) {
        this.x = this.x - x;
        this.y = this.y - y;
    }

    /**
     * Multiplies the x and y components of another vector with the x and y components of the current instance.
     *
     * @param other The other vector to multiply with.
     */
    public void multiply(Vector2f other) {
        x = this.x * other.x;
        y = this.y * other.y;
    }

    /**
     * Multiplies the x and y values with the x and y components of the current instance.
     *
     * @param x The x value to multiply with.
     * @param y The y value to multiply with.
     */
    public void multiply(float x, float y) {
        this.x = this.x * x;
        this.y = this.y * y;
    }

    /**
     * Divides the x and y components of another vector from the x and y components of the current instance.
     *
     * @param other The other vector to divide from.
     */
    public void divide(Vector2f other) {
        x = x / other.x;
        y = y / other.y;
    }

    /**
     * Divides the x and y values from the x and y components of the current instance.
     *
     * @param x The x value to divide.
     * @param y The y value to divide.
     */
    public void divide(float x, float y) {
        this.x = this.x / x;
        this.y = this.y / y;
    }

    /**
     * Returns the length of the vector.
     *
     * @return The length of the vector.
     */
    public float getMagnitude() {
        return (float) Math.sqrt((x * x) + (y * y));
    }

    /**
     * Sets the x and y components of the current instance to zero.
     */
    public void zero() {
        x = 0.0f;
        y = 0.0f;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vector2f) {
            Vector2f other = (Vector2f) obj;

            return this.x == other.x && this.y == other.y;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return String.format("Vector2f(x = %f, y = %f)", x, y);
    }
}
