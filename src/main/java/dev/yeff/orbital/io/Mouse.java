package dev.yeff.orbital.io;


import org.joml.Vector2f;

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
     * @return The position of the mouse between frames.
     */
    public Vector2f getMouseDelta() { return new Vector2f(GetMouseDelta().x(), GetMouseDelta().y()); }

    /**
     * Checks if a mouse button is being held down.
     *
     * @param button The button to check for.
     * @return If the button is not being held down or not.
     */
    public boolean isMouseDown(Keys button) {
        return IsMouseButtonDown(button.getKeycode());
    }

    /**
     * Checks if a mouse button is not being held down.
     *
     * @param button The button to check for.
     * @return If the button is not being held down.
     */
    public boolean isMouseUp(Keys button) {
        return IsMouseButtonUp(button.getKeycode());
    }

    /**
     * Checks if a mouse button is being pressed once.
     *
     * @param button The button to check for.
     * @return If the button is being pressed.
     */
    public boolean isMousePressed(Keys button) {
        return IsMouseButtonPressed(button.getKeycode());
    }

    /**
     * Gets the scroll value of the mouse.
     *
     * @return The scroll value.
     */
    public float getScroll() {
        return GetMouseWheelMove() * 4;
    }
}
