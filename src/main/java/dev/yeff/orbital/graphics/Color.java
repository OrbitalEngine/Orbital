package dev.yeff.orbital.graphics;

import com.raylib.Raylib;

/**
 * Enum wrapping over raylib colors, to be used by the renderer.
 *
 * @author YeffyCodeGit
 */
public class Color {
    private float r;
    private float g;
    private float b;
    private float a;

    public Color(float r, float g, float b, float a) {
        this.r = r;
        this.g = g;
        this.b = b;
        this.a = a;
    }

    public Raylib.Color getRaylibColor() {
        return new Raylib.Color().r((byte) r).g((byte) g).b((byte) b).a((byte) a);
    }
}
