package dev.yeff.orbital.util;

/**
 * Interface to take a callback with a single parameter, of type {@code T}.
 *
 * @author YeffyCodeGit
 */
@FunctionalInterface
public interface Callback<T> {
  void invoke(T param);
}
