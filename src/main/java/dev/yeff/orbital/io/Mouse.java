package dev.yeff.orbital.io;

import com.raylib.Raylib.Vector2;
import dev.yeff.orbital.Game;

import static com.raylib.Raylib.*;

public class Mouse {
    public float getScroll() {
        return GetMouseWheelMove() * 4;
    }

    public Vector2 getMousePos() {
        return GetMousePosition();
    }

    public boolean isMouseDown(int button) {
        return IsMouseButtonDown(button);
    }

    public boolean isMouseUp(int button) {
        return IsMouseButtonUp(button);
    }
}
