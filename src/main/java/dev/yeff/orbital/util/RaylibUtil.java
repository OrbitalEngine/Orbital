package dev.yeff.orbital.util;

import com.raylib.Raylib;
import dev.yeff.orbital.math.Vector2f;

/**
 * Utility functions to use Orbital classes as Raylib classes. Meant to be used internally by the engine, for things like rendering.
 *
 * @author YeffyCodeGit
 */
public class RaylibUtil {
    /**
     * Turns an Orbital {@code Vector2f} into a Raylib {@code Raylib.Vector2}.
     *
     * @param vec The orbital vector.
     * @return The raylib vector.
     */
    public static Raylib.Vector2 getAsRaylibVec2(Vector2f vec) {
        return new Raylib.Vector2().x(vec.x).y(vec.y);
    }
}
