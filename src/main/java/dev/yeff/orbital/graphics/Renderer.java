package dev.yeff.orbital.graphics;

import com.raylib.Raylib.Texture;
import com.raylib.Raylib.Vector2;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class Renderer {
    public void drawTexture(Texture texture, Vector2 pos) {
        DrawTextureV(texture, pos, RAYWHITE);
    }
}
