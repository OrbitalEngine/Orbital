package dev.yeff.orbital.graphics;

import com.raylib.Raylib;
import lombok.Getter;

import static com.raylib.Raylib.GetColor;

/**
 * Represents an RGB color, to be used in an engine.
 *
 * @author YeffyCodeGit
 */
public class Color {
    @Getter
    private float r;

    @Getter
    private float g;

    @Getter
    private float b;

    @Getter
    private float a;

    // Constants
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color RED = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color PINK = new Color(255, 0, 221);
    public static final Color PURPLE = new Color(200, 0, 255);
    public static final Color YELLOW = new Color(255, 255, 0);

    public Color(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(float r, float g, float b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = 255;
    }

    public Color(byte hex) {
        Raylib.Color rgbaColor = GetColor(hex);

        this.r = rgbaColor.r();
        this.g = rgbaColor.g();
        this.b = rgbaColor.b();
        this.a = rgbaColor.a();
    }

    public Raylib.Color getRaylibColor() {
        return new Raylib.Color()
                .r((byte) r)
                .g((byte) g)
                .b((byte) b)
                .a((byte) a);
    }
}
