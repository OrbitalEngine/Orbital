package dev.yeff.orbital.resources;

import com.raylib.Raylib;

import static com.raylib.Raylib.LoadFont;
import static com.raylib.Raylib.UnloadFont;

/**
 * Represents a text font, which can be used by the {@code Renderer}.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class Font {
    private Raylib.Font font;

    public Font(String path) {
        font = LoadFont(path);
    }

    /**
     * Returns the raylib version of the font. This function is mainly meant to be used internally by the engine internally.
     *
     * @return The raylib version of the font.
     */
    public Raylib.Font asRaylibFont() {
        return font;
    }

    /**
     * Unloads the font from memory.
     */
    public void dispose() {
        UnloadFont(font);
    }
}
