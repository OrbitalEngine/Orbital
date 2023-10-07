package dev.yeff.orbital.util;

import com.raylib.Raylib;
import dev.yeff.orbital.graphics.Color;
import org.joml.Vector2f;

/**
 * Utility functions to use Orbital classes as Raylib classes. Meant to be used internally by the
 * engine, for things like rendering.
 *
 * @author YeffyCodeGit
 */
public class RaylibUtil {
  /**
   * Turns an Orbital {@code Vector2f} into a Raylib {@code Raylib.Vector2}.
   *
   * @param vec The orbital vector.
   * @return The Raylib vector.
   */
  public static Raylib.Vector2 getAsRaylibVec2(Vector2f vec) {
    return new Raylib.Vector2().x(vec.x).y(vec.y);
  }

  /**
   * Gets the Raylib version of the color, to be used internally by the engine.
   *
   * @return The raylib version of the color.
   */
  public static Raylib.Color getRaylibColor(Color color) {
    return new Raylib.Color().r(color.getR()).g(color.getG()).b(color.getB()).a(color.getA());
  }
}
