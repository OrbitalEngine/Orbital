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
                .r((byte) r)
                .g((byte) g)
                .b((byte) b)
                .a((byte) a);
    }
}
