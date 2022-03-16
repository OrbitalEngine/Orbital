package dev.yeff.orbital.resources;

import com.raylib.Raylib.Texture;
import lombok.Getter;

import static com.raylib.Raylib.*;

public class Sprite {
    @Getter
    private String path;

    @Getter
    private Texture rawTex;

    public Sprite(String path) {
        this.path = path;
        rawTex = LoadTexture(path);
    }

    public void dispose() {
        UnloadTexture(rawTex);
    }
}
