package dev.yeff.orbital.io;

import dev.yeff.orbital.util.Callback;

import java.util.function.Function;

import static com.raylib.Raylib.*;

public class Keyboard {
    public boolean isKeyDown(Keys key) { return IsKeyDown(key.getKeycode()); }

    public boolean isKeyUp(Keys key) { return IsKeyUp(key.getKeycode()); }

    public void onKeyPressed(Keys key, Callback<Integer> callback) {
        if (GetKeyPressed() == key.getKeycode()) {
            callback.invoke(key.getKeycode());
        }
    }
}
