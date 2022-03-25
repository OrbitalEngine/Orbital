package dev.yeff.orbital.resources;

import com.raylib.Raylib;

import static com.raylib.Raylib.LoadFont;
import static com.raylib.Raylib.UnloadFont;

public class TextFont {
    private Raylib.Font font;

    public TextFont(String path) {
        font = LoadFont(path);
    }

    public int getBaseSize() {
        return font.baseSize();
    }

    public Raylib.Font asRaylibFont() {
        return font;
    }

    public void dispose() {
        UnloadFont(font);
    }
}
