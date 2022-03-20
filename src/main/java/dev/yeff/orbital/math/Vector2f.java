package dev.yeff.orbital.math;

public class Vector2f {
    private float x;
    private float y;

    public Vector2f(Vector2f vec2) {
        this.x = vec2.getX();
        this.y = vec2.getY();
    }

    public Vector2f(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public Vector2f() {
        this.x = 0;
        this.y = 0;
    }

    public void add(Vector2f other) {
        x = x + other.getX();
        y = y + other.getY();
    }

    public void add(float x, float y) {
        this.x = this.x + x;
        this.y = this.y + y;
    }

    public void subtract(Vector2f other) {
        x = x - other.getX();
        y = y - other.getY();
    }

    public void subtract(float x, float y) {
        this.x = this.x - x;
        this.y = this.y - y;
    }

    public void multiply(Vector2f other) {
        x = this.x * other.getX();
        y = this.y * other.getY();
    }

    public void multiply(float x, float y) {
        this.x = this.x * x;
        this.y = this.y * y;
    }

    public void divide(Vector2f other) {
        x = x / other.getX();
        y = y / other.getY();
    }

    public void divide(float x, float y) {
        this.x = this.x / x;
        this.y = this.y / y;
    }

    public void zero() {
        x = 0.0f;
        y = 0.0f;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
