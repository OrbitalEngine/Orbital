package dev.yeff.orbital.resources;

import com.raylib.Raylib.Texture;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.math.Vector2f;
import lombok.Getter;

import static com.raylib.Raylib.*;

public class Sprite {
    @Getter
    private String path;

    @Getter
    private Image img;

    @Getter
    private Texture rawTex;

    public Sprite(String path) {
        this.path = path;
        this.img = LoadImage(path);
        this.rawTex = LoadTextureFromImage(img);
    }

    public void resize(Vector2f newSize) {
        // Use nearest neighbour scaling algorithm instead of the default bicubic scaling algorithm
        // https://en.wikipedia.org/wiki/Nearest-neighbor_interpolation
        ImageResizeNN(this.img, (int) newSize.x, (int) newSize.y);

        // reload the texture after resizing
        this.rawTex = LoadTextureFromImage(this.img);
    }

    public void resizeBicubic(Vector2f newSize) {
        // Raylib uses the bicubic resizing algorithm by default
        // https://en.wikipedia.org/wiki/Bicubic_interpolation
        ImageResize(this.img, (int) newSize.x, (int) newSize.y);

        // reload the texture after resizing
        this.rawTex = LoadTextureFromImage(this.img);
    }

    public void dispose() {
        UnloadImage(img);
        UnloadTexture(rawTex);
    }
}
