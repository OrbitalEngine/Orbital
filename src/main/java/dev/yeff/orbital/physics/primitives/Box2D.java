package dev.yeff.orbital.physics.primitives;

import dev.yeff.orbital.physics.rigidbody.Rigidbody2D;
import org.joml.Vector2f;

// Axis Aligned Bounding Box
// NOTE: Orbital does not have rotations so AABB boxes work, we dont need rotation yet
public class Box2D {
    private Vector2f center;
    private Vector2f size;
    private Rigidbody2D rb = null;

    public Box2D(Vector2f center, Vector2f size) {
        this.center = center;
        this.size = size;
    }
}
