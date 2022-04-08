package dev.yeff.orbital.io;

import dev.yeff.orbital.math.Vector2f;

import static com.raylib.Raylib.*;

/**
 * Provides functions for receiving input from the mouse.
 *
 * @author YeffyCodeGit
 */
public class Mouse {
    /**
     * Gets the position of the mouse.
     *
     * @return The mouse position.
     */
    public Vector2f getMousePos() {
        return new Vector2f(GetMousePosition().x(), GetMousePosition().y());
    }

    /**
     * Gets the position of the mouse between frames.
     *
     * @return The delta position of the mouse.
     */
    public Vector2f getMouseDelta() { return new Vector2f(GetMouseDelta().x(), GetMouseDelta().y()); }

    /**
     * Checks if a mouse button is being held down.
     *
     * @param button The button to check for.
     * @return If the is not held down or not.
     */
    public boolean isMouseDown(Keys button) {
        return IsMouseButtonDown(button.getKeycode());
    }

    /**
     * Gets the scroll value of the mouse.
     *
     * @return The scroll value.
     */
    public float getScroll() {
        return GetMouseWheelMove() * 4;
    }

    /**
     * Checks if a mouse button is not being held down.
     *
     * @param button The button to check for.
     * @return If the is not held down or not.
     */
    public boolean isMouseUp(Keys button) {
        return IsMouseButtonUp(button.getKeycode());
    }
}
