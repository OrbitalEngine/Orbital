package dev.yeff.orbital.ecs.annotations;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to automatically program the transform of the object.
 *
 * @author YeffyCodeGit
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Transform {
    Vector position();
    Vector scale();
}
