package dev.yeff.orbital.graphics;

import com.raylib.Raylib;
import lombok.Getter;
import lombok.Setter;

/**
 * Enum wrapping over raylib colors, to be used by the renderer.
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

    public Raylib.Color getRaylibColor() {
        return new Raylib.Color().r((byte) r).g((byte) g).b((byte) b).a((byte) a);
    }
}
