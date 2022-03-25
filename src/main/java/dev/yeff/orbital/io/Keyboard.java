package dev.yeff.orbital.io;

import dev.yeff.orbital.util.Callback;

import static com.raylib.Raylib.*;

/**
 * Provides functions for receiving input from the keyboard.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class Keyboard {
    /**
     * Checks if a keyboard key is being held down.
     *
     * @param key The key to check for.
     * @return If the key is held down or not.
     */
    public boolean isKeyDown(Keys key) { return IsKeyDown(key.getKeycode()); }

    /**
     * Checks if a keyboard key is not being held down.
     *
     * @param key The key to check for.
     * @return If the is not held down or not.
     */
    public boolean isKeyUp(Keys key) { return IsKeyUp(key.getKeycode()); }

    /**
     * Invokes a {@code Callback<T>} when a keyboard key is pressed.
     *
     * @param key The key to check for.
     * @param callback The callback to invoke when the key is pressed/
     */
    public void onKeyPressed(Keys key, Callback<Integer> callback) {
        if (GetKeyPressed() == key.getKeycode()) {
            callback.invoke(key.getKeycode());
        }
    }
}
