package dev.yeff.orbital.graphics;

import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.resources.TextFont;

import java.time.format.TextStyle;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

public class Renderer {
    public void drawTexture(Sprite sprite, Vector2f pos) {
        DrawTexture(sprite.getRawTex(), (int) pos.x, (int) pos.y, RAYWHITE);
    }

    public void drawCircle(Colors color, Vector2f pos, float radius) {
        DrawCircle((int) pos.x, (int) pos.y, radius, color.getColor());
    }

    public void drawCircleOutline(Colors color, Vector2f pos, float radius) {
        DrawCircleLines((int) pos.x, (int) pos.y, radius, color.getColor());
    }

    public void drawRect(Colors color, Vector2f pos, Vector2f size) {
        DrawRectangle((int) pos.x, (int) pos.y, (int) size.x, (int) size.y, color.getColor());
    }

    public void drawRect(Colors color, Vector2f pos, float size) {
        DrawRectangle((int) pos.x, (int) pos.y, (int) size, (int) size, color.getColor());
    }

    public void drawRectOutline(Vector2f pos, Vector2f size, Colors color) {
        DrawRectangleLines((int) pos.x, (int) pos.y, (int) size.x, (int) size.y, color.getColor());
    }

    public void drawRectOutline(Vector2f pos, float size, Colors color) {
        DrawRectangleLines((int) pos.x, (int) pos.y, (int) size, (int) size, color.getColor());
    }

    public void drawLine(Vector2f start, Vector2f end, Colors color) {
        DrawLine((int) start.x, (int) start.y, (int) end.x, (int) end.y, color.getColor());
    }

    public void drawLine(Vector2f start, Vector2f end, Colors color, float thickness) {
        DrawLineEx(start.asRaylibVector(), end.asRaylibVector(), thickness, color.getColor());
    }

    public void drawString(String text, float fontSize, Vector2f pos) {
        DrawText(text, (int) pos.x, (int) pos.y, (int) fontSize, Colors.BLACK.getColor());
    }

    public void fillBackground(Colors color) { ClearBackground(color.getColor()); }
}