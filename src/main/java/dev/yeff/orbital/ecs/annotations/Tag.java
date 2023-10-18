package dev.yeff.orbital.ecs.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Sets the tag of an object by adding a {@code TagComponent} under the hood.
 *
 * @author YeffyCodeGit
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Tag {
    String tagName();
}
