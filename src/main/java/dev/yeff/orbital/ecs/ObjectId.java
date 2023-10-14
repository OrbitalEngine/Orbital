package dev.yeff.orbital.ecs;

import java.lang.annotation.*;


/**
 * Allows you to set an ID for a {@code GameObject}.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented()
public @interface ObjectId {
    String id() default "";
}
