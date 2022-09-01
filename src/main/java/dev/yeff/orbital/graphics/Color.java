package dev.yeff.orbital.graphics;

import com.raylib.Raylib;
import dev.yeff.orbital.math.Mathf;
import lombok.Getter;

import static com.raylib.Raylib.GetColor;

/**
 * Stores RGBA color data, to be used for rendering.
 *
 * @author YeffyCodeGit
 */
public class Color {
    @Getter
    private byte r;

    @Getter
    private byte g;

    @Getter
    private byte b;

    @Getter
    private byte a;

    // Constants
    public static final Color BLACK = new Color(0, 0, 0);
    public static final Color WHITE = new Color(255, 255, 255);
    public static final Color RED = new Color(255, 0, 0);
    public static final Color GREEN = new Color(0, 255, 0);
    public static final Color BLUE = new Color(0, 0, 255);
    public static final Color PINK = new Color(255, 0, 221);
    public static final Color PURPLE = new Color(200, 0, 255);
    public static final Color YELLOW = new Color(255, 255, 0);

    public Color(byte r, byte g, byte b, byte a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Color(byte r, byte g, byte b) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = (byte) 255;
    }

    public Color(float r, float g, float b) {
        this.r = (byte) (Mathf.clamp(r, 0, 1) * 255.9999);
        this.g = (byte) (Mathf.clamp(g, 0, 1) * 255.9999);
        this.b = (byte) (Mathf.clamp(b, 0, 1) * 255.9999);
        this.a = (byte) 255;
    }

    public Color(float r, float g, float b, float a) {
        this.r = (byte) Mathf.clamp(r, 0, 255);;
        this.g = (byte) Mathf.clamp(g, 0, 255);;
        this.b = (byte) Mathf.clamp(b, 0, 255);;
        this.a = (byte) Mathf.clamp(a, 0, 255);;
    }

    public Color(byte hex) {
        Raylib.Color rgbaColor = GetColor(hex);

        this.r = rgbaColor.r();
        this.g = rgbaColor.g();
        this.b = rgbaColor.b();
        this.a = rgbaColor.a();
    }

    /**
     * Linearly interpolates between two colors and returns the resulting color.
     *
     * @param inital The inital color.
     * @param target The color to lerp to, from the inital color.
     * @param t The value used to interpolate between the two colors.
     * @return The lerped color.
     */
    public static Color lerp(Color inital, Color target, float t) {
        return new Color(
                Mathf.lerp(inital.r, target.r, t),
                Mathf.lerp(inital.g, target.g, t),
                Mathf.lerp(inital.b, target.b, t),
                Mathf.lerp(inital.a, target.a, t)
        );
    }

    /**
     * Gets the Raylib version of the color, to be used internally by the engine.
     *
     * @return The raylib version of the color.
     */
    public Raylib.Color getRaylibColor() {
        return new Raylib.Color()
                .r(r)
                .g(g)
                .b(b)
                .a(a);
    }
}
