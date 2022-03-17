package dev.yeff.orbital.io;

import static com.raylib.Raylib.IsKeyDown;
import static com.raylib.Raylib.IsKeyUp;

public class Keyboard {
    public boolean isKeyDown(Keys key) { return IsKeyDown(key.getKeycode()); }
    public boolean isKeyUp(Keys key) { return IsKeyUp(key.getKeycode()); }
}
