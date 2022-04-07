package dev.yeff.orbital.graphics;

import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.*;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.resources.Font;

import java.util.ArrayList;
import java.util.List;

import static com.raylib.Jaylib.RAYWHITE;
import static com.raylib.Raylib.*;

/**
 * Class providing functionality to render different shapes, text and {@code Sprite}'s.
 *
 * @author YeffyCodeGit
 */
public class Renderer {
    private static List<GameObject> renderObjects = new ArrayList<>();

    // Disable constructor
    private Renderer() { }


    /**
     * Updates the renderer about all the objects that need to be rendered.
     *
     * @param renderObjects The new list of objects to be rendered.
     */
    public static void updateRenderObjects(List<GameObject> renderObjects) {
        Renderer.renderObjects = renderObjects;
    }

    /**
     * Renders all the objects that need to be rendered.
     */
    public static void performRenders() {
        for (GameObject go : renderObjects) {
            if (go.hasComponent(RenderShapeComponent.class)) {
                Shapes shape = go.getComponent(RenderShapeComponent.class).shape;
                Colors color = go.getComponent(RenderShapeComponent.class).color;
                Vector2f scale = go.getComponent(TransformComponent.class).scale;
                Vector2f position = go.getComponent(TransformComponent.class).position;

                switch (shape) {
                    case CIRCLE -> drawCircle(color, position, scale.x);
                    case RECTANGLE -> drawRect(color, position, scale);
                    case CIRCLE_OUTLINE -> drawCircleOutline(color, position, scale.x);
                    case RECTANGLE_OUTLINE -> drawRectOutline(position, scale, color);
                }

            } else if (go.hasComponent(TextComponent.class)) {
                float fontSize = go.getComponent(TextComponent.class).fontSize;
                String text = go.getComponent(TextComponent.class).text;
                Font font = go.getComponent(TextComponent.class).font;
                Vector2f position = go.getComponent(TransformComponent.class).position;

                if (font != null)
                    drawString(text, fontSize, position, font);
                else
                    drawString(text, fontSize, position);
            } else if (go.hasComponent(LineComponent.class)) {
                float thickness = go.getComponent(LineComponent.class).thickness;
                Colors color = go.getComponent(LineComponent.class).color;
                Vector2f start = go.getComponent(LineComponent.class).start;
                Vector2f end = go.getComponent(LineComponent.class).end;

                drawLine(start, end, color, thickness);
            } else {
                Sprite sprite = go.getComponent(SpriteComponent.class).sprite;
                Vector2f position = go.getComponent(TransformComponent.class).position;
                Vector2f scale = go.getComponent(TransformComponent.class).scale;

                sprite.resize(scale);

                drawTexture(sprite, position);
            }
        }
    }

    /**
     * Draws a {@code Sprite} to the screen at a given position.
     *
     * @param sprite The sprite to draw.
     * @param pos The position to draw it at.
     */
    public static void drawTexture(Sprite sprite, Vector2f pos) {
        DrawTexture(sprite.getRawTex(), (int) pos.x, (int) pos.y, RAYWHITE);
    }

    /**
     * Draws a circle at a given position.
     *
     * @param color The color of the circle.
     * @param pos The position to draw the circle at.
     * @param radius The radius of the circle.
     */
    public static void drawCircle(Colors color, Vector2f pos, float radius) {
        DrawCircle((int) pos.x, (int) pos.y, radius, color.getColor());
    }

    /**
     * Draws an outline of a circle at a given position.
     *
     * @param color The color of the outline.
     * @param pos The position to draw the circle outline at.
     * @param radius The radius of the circle.
     */
    public static void drawCircleOutline(Colors color, Vector2f pos, float radius) {
        DrawCircleLines((int) pos.x, (int) pos.y, radius, color.getColor());
    }

    /**
     * Draws a rectangle at a given position.
     *
     * @param color The color of the rectangle.
     * @param pos The position to draw the rectangle at.
     * @param size The width and height of the rectangle.
     */
    public static void drawRect(Colors color, Vector2f pos, Vector2f size) {
        DrawRectangle((int) pos.x, (int) pos.y, (int) size.x, (int) size.y, color.getColor());
    }

    /**
     * Draws a rectangle at a given position.
     *
     * @param color The color of the rectangle.
     * @param pos The position to draw the rectangle at.
     * @param size The size of the rectangle.
     */
    public static void drawRect(Colors color, Vector2f pos, float size) {
        DrawRectangle((int) pos.x, (int) pos.y, (int) size, (int) size, color.getColor());
    }

    /**
     * Draws an outline of a rectangle at a given position.
     *
     * @param pos The position of the rectangle outline at.
     * @param size The width and height of the rectangle.
     * @param color The color of the outline.
     */
    public static void drawRectOutline(Vector2f pos, Vector2f size, Colors color) {
        DrawRectangleLines((int) pos.x, (int) pos.y, (int) size.x, (int) size.y, color.getColor());
    }

    /**
     * Draws an outline of a rectangle at a given position.
     *
     * @param pos The position of the rectangle outline at.
     * @param size The size of the rectangle.
     * @param color The color of the outline.
     */
    public static void drawRectOutline(Vector2f pos, float size, Colors color) {
        DrawRectangleLines((int) pos.x, (int) pos.y, (int) size, (int) size, color.getColor());
    }

    /**
     * Draws a straight line from a given starting and ending point.
     *
     * @param start The starting point of the line.
     * @param end The ending point of the line.
     * @param color The color of the line.
     */
    public static void drawLine(Vector2f start, Vector2f end, Colors color) {
        DrawLine((int) start.x, (int) start.y, (int) end.x, (int) end.y, color.getColor());
    }

    /**
     * Draws a straight line from a given starting and ending point, with a thickness.
     *
     * @param start The starting point of the line.
     * @param end The ending point of the line.
     * @param color The color of the line.
     * @param thickness The thickness of the line.
     */
    public static void drawLine(Vector2f start, Vector2f end, Colors color, float thickness) {
        DrawLineEx(start.asRaylibVector(), end.asRaylibVector(), thickness, color.getColor());
    }

    /**
     * Draws a string at a given position, with a font size.
     *
     * @param text The string to draw.
     * @param fontSize The font size of the text.
     * @param pos The position to draw the text at.
     */
    public static void drawString(String text, float fontSize, Vector2f pos) {
        DrawText(text, (int) pos.x, (int) pos.y, (int) fontSize, Colors.BLACK.getColor());
    }

    /**
     * Draws a string at a given position, with a font and font size.
     *
     * @param text The string to draw.
     * @param fontSize The font size of the text.
     * @param pos The position to draw the text at.
     * @param font The font to draw the text with.
     */
    public static void drawString(String text, float fontSize, Vector2f pos, Font font) {
        DrawTextEx(font.asRaylibFont(), text, pos.asRaylibVector(), fontSize, 2, Colors.BLACK.getColor());
    }

    /**
     * Fills the background with a given color.
     *
     * @param color The color to fill with.
     */
    public static void fillBackground(Colors color) { ClearBackground(color.getColor()); }
}