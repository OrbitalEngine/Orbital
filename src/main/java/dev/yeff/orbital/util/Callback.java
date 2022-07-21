package dev.yeff.orbital.util;


/**
 * Functional interface to take a callback with a single parameter, of type {@code T}.
 *
 * @author YeffyCodeGit
 */
@FunctionalInterface
public interface Callback<T> {
    void invoke(T param);
}
