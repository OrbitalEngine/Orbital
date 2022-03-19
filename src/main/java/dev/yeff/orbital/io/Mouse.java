package dev.yeff.orbital.io;

import com.raylib.Raylib.Vector2;
import dev.yeff.orbital.Game;

import static com.raylib.Raylib.*;

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
