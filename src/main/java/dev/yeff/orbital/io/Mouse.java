package dev.yeff.orbital.io;

import com.raylib.Raylib.Vector2;

import static com.raylib.Raylib.*;

/**
 * Provides functions for receiving input from the mouse.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class Mouse {
    public Vector2 getMousePos() {
        return GetMousePosition();
    }

    public Vector2 getMouseDelta() { return GetMouseDelta(); }

    public boolean isMouseDown(Keys button) {
        return IsMouseButtonDown(button.getKeycode());
    }

    public float getScroll() {
        return GetMouseWheelMove() * 4;
    }

    public boolean isMouseUp(Keys button) {
        return IsMouseButtonUp(button.getKeycode());
    }
}
