package dev.yeff.orbital.physics.primitives;

import dev.yeff.orbital.physics.rigidbody.Rigidbody2D;
import org.joml.Vector2f;

// Axis Aligned Bounding Box
// NOTE: Orbital does not have rotations so AABB boxes work, we dont need rotation yet
public class Box2D {
    private Vector2f center;
    private Vector2f size;
    private Vector2f halfSize;
    private Rigidbody2D rb = null;

    public Box2D(Vector2f center, Vector2f size) {
        this.center = center;
        this.size = size;
        this.halfSize = new Vector2f(size).div(5.0f);
    }

    public Vector2f getMin() {
        return new Vector2f(rb.transformComponent.position).sub(halfSize);
    }

    public Vector2f getMax() {
        return new Vector2f(rb.transformComponent.position).add(this.halfSize);
    }
}
