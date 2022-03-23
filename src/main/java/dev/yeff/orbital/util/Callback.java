package dev.yeff.orbital.util;


/**
 * Utility class to take a callback with a single parameter, of type {@code T}.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public interface Callback<T> {
    void invoke(T param);
}
