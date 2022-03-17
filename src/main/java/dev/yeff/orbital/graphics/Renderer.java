package dev.yeff.orbital.graphics;

import com.raylib.Raylib.Vector2;
import dev.yeff.orbital.resources.Sprite;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class Renderer {
    public void drawTexture(Sprite sprite, Vector2 pos) {
        DrawTextureV(sprite.getRawTex(), pos, RAYWHITE);
    }

    public void drawCircle(Colors color, Vector2 pos, float size) {
        DrawCircleV(pos, size, color.getColor());
    }

    public void drawRect(Colors color, Vector2 pos, Vector2 size) {
        DrawRectangleV(pos, size, color.getColor());
    }

    public void drawRect(Colors color, Vector2 pos, float size) {
        DrawRectangleV(pos, new Vector2().x(size).y(size), color.getColor());
    }

    public void drawLine(Vector2 start, Vector2 end, Colors color) {
        DrawLineV(start, end, color.getColor());
    }

    public void fillBackground(Colors color) { ClearBackground(color.getColor()); }

}