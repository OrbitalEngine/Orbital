package dev.yeff.orbital.io;

import static com.raylib.Raylib.IsKeyDown;
import static com.raylib.Raylib.IsKeyUp;

public class Keyboard {
    public boolean isKeyDown(int keyCode) { return IsKeyDown(keyCode); }
    public boolean isKeyUp(int keyCode) { return IsKeyUp(keyCode); }
}
