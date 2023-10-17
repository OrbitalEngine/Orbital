package dev.yeff.orbital.ecs.annotations;

import dev.yeff.orbital.graphics.Shapes;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Collision {
    Shapes shape();
    Vector colliderScale();
}
