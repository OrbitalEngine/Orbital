package dev.yeff.orbital.graphics;

import com.raylib.Raylib.Texture;
import com.raylib.Raylib.Vector2;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class Renderer {
    public void drawTexture(Texture texture, Vector2 pos) {
        DrawTextureV(texture, pos, RAYWHITE);
    }

    public void drawCircle(Color color, Vector2 pos, float size) {
        DrawCircleV(pos, size, color);
    }

    public void drawRect(Color color, Vector2 pos, Vector2 size) {
        DrawRectangleV(pos, size, color);
    }

    public void drawRect(Color color, Vector2 pos, float size) {
        DrawRectangleV(pos, new Vector2().x(size).y(size), color);
    }

    public void drawLine(Vector2 start, Vector2 end, Color color) {
        DrawLineV(start, end, color);
    }
}