package dev.yeff.orbital.io;

import com.raylib.Jaylib.Vector2;
import dev.yeff.orbital.Game;

import static com.raylib.Raylib.GetMouseWheelMove;

public class Mouse {
    public float getScroll() {
        return GetMouseWheelMove() * 4;
    }
}
