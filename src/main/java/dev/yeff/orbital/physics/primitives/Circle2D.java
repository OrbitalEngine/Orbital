package dev.yeff.orbital.physics.primitives;

import dev.yeff.orbital.physics.rigidbody.Rigidbody2D;
import lombok.Getter;
import org.joml.Vector2f;

public class Circle2D {
    @Getter
    private float radius;
    private Rigidbody2D rb = null;

    public Circle2D(float radius) {
        this.radius = radius;
    }

    public Vector2f getCenter() {
        return rb.transformComponent.position;
    }
}
