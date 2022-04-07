package dev.yeff.orbital.graphics;

import com.raylib.Jaylib;
import com.raylib.Raylib;
import lombok.Getter;

import static com.raylib.Jaylib.*;

/**
 * Enum wrapping over raylib colors, to be used by the renderer.
 *
 * @author YeffyCodeGit
 */
public enum Colors {
    BLACK(Jaylib.BLACK),
    WHITE(Jaylib.WHITE),
    GRAY(Jaylib.GRAY),
    LIGHT_GRAY(LIGHTGRAY),
    DARK_GRAY(DARKGRAY),
    MAROON(Jaylib.MAROON),
    RED(Jaylib.RED),
    PINK(Jaylib.PINK),
    ORANGE(Jaylib.ORANGE),
    GOLD(Jaylib.GOLD),
    YELLOW(Jaylib.YELLOW),
    GREEN(Jaylib.GREEN),
    DARK_GREEN(DARKGREEN),
    LIME_GREEN(LIME),
    BLUE(Jaylib.BLUE),
    DARK_BLUE(DARKBLUE),
    LIGHT_BLUE(SKYBLUE),
    PURPLE(Jaylib.PURPLE),
    VIOLET(Jaylib.VIOLET),
    DARK_PURPLE(DARKPURPLE),
    BROWN(Jaylib.BROWN),
    BEIGE(Jaylib.BEIGE),
    DARK_BROWN(DARKBROWN);

    @Getter
    private Raylib.Color color;

    Colors(Raylib.Color color) {
        this.color = color;
    }
}
