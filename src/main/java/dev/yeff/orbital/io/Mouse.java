package dev.yeff.orbital.io;

import com.raylib.Raylib.Vector2;
import dev.yeff.orbital.Game;

import static com.raylib.Raylib.GetMousePosition;
import static com.raylib.Raylib.GetMouseWheelMove;

public class Mouse {
    public float getScroll() {
        return GetMouseWheelMove() * 4;
    }

    public Vector2 getMousePos() {
        return GetMousePosition();
    }
}
