package dev.yeff.orbital.io;

import com.raylib.Raylib.Vector2;
import dev.yeff.orbital.math.Vector2f;

import static com.raylib.Raylib.*;

/**
 * Provides functions for receiving input from the mouse.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class Mouse {
    public Vector2f getMousePos() {
        return new Vector2f(GetMousePosition().x(), GetMousePosition().y());
    }

    public Vector2f getMouseDelta() { return new Vector2f(GetMouseDelta().x(), GetMouseDelta().y()); }

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
