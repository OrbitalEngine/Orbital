package dev.yeff.orbital.graphics;

import com.raylib.Raylib;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.render.*;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.resources.Font;
import dev.yeff.orbital.util.RaylibUtil;
import org.joml.Vector2f;

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
    public static void performRenders(Game game) {
        for (GameObject go : renderObjects) {
            go.getComponent(DrawableComponent.class).update(game);
        }
    }

    /**
     * Draws a {@code Sprite} to the screen at a given position.
     *
     * @param sprite The sprite to draw.
     * @param pos The position to draw it at.
     */
    public static void drawTexture(Sprite sprite, Vector2f pos) {
        DrawTextureV(sprite.getRawTex(), RaylibUtil.getAsRaylibVec2(pos), RAYWHITE);
    }

    /**
     * Draws a circle at a given position.
     *
     * @param color The color of the circle.
     * @param pos The position to draw the circle at.
     * @param radius The radius of the circle.
     */
    public static void drawCircle(Color color, Vector2f pos, float radius) {
        DrawCircleV(RaylibUtil.getAsRaylibVec2(pos), radius, RaylibUtil.getRaylibColor(color));
    }

    /**
     * Draws a circle at a given position.
     *
     * @param gradient The gradient to draw the circle with.
     * @param pos THe position to draw the circle at.
     * @param radius The radius of the circle.
     */
    public static void drawCircleGradient(Gradient gradient, Vector2f pos, float radius) {
        DrawCircleGradient(
                (int) pos.x, 
                (int) pos.y, 
                radius, 
                RaylibUtil.getRaylibColor(gradient.getStartingColor()),
                RaylibUtil.getRaylibColor(gradient.getEndingColor())
        );
    }

    /**
     * Draws an outline of a circle at a given position.
     *
     * @param color The color of the outline.
     * @param pos The position to draw the circle outline at.
     * @param radius The radius of the circle.
     */
    public static void drawCircleOutline(Color color, Vector2f pos, float radius) {
        DrawCircleLines((int) pos.x, (int) pos.y, radius, RaylibUtil.getRaylibColor(color));
    }

    /**
     * Draws a rectangle at a given position.
     *
     * @param color The color of the rectangle.
     * @param pos The position to draw the rectangle at.
     * @param size The width and height of the rectangle.
     */
    public static void drawRect(Color color, Vector2f pos, Vector2f size) {
        DrawRectangleV(RaylibUtil.getAsRaylibVec2(pos), RaylibUtil.getAsRaylibVec2(size), RaylibUtil.getRaylibColor(color));
    }

    /**
     * Draws a rectangle at a given position.
     *
     * @param gradient The gradient to draw the circle with.
     * @param pos The position to draw the rectangle at.
     * @param size The width and height of the rectangle.
     */
    public static void drawRectGradient(Gradient gradient, Vector2f pos, Vector2f size) {
        DrawRectangleGradientH(
                (int) pos.x,
                (int) pos.y,
                (int) size.x,
                (int) size.y,
                RaylibUtil.getRaylibColor(gradient.getStartingColor()),
                RaylibUtil.getRaylibColor(gradient.getEndingColor())
        );
    }


    /**
     * Draws a rectangle at a given position.
     *
     * @param color The color of the rectangle.
     * @param pos The position to draw the rectangle at.
     * @param size The size of the rectangle.
     */
    public static void drawRect(Color color, Vector2f pos, float size) {
        DrawRectangleV(RaylibUtil.getAsRaylibVec2(pos), new Raylib.Vector2().x(size).y(size), RaylibUtil.getRaylibColor(color));
    }

    /**
     * Draws an outline of a rectangle at a given position.
     *
     * @param pos The position of the rectangle outline at.
     * @param size The width and height of the rectangle.
     * @param color The color of the outline.
     */
    public static void drawRectOutline(Vector2f pos, Vector2f size, Color color) {
        DrawRectangleLines((int) pos.x, (int) pos.y, (int) size.x, (int) size.y, RaylibUtil.getRaylibColor(color));
    }

    /**
     * Draws an outline of a rectangle at a given position.
     *
     * @param pos The position of the rectangle outline at.
     * @param size The size of the rectangle.
     * @param color The color of the outline.
     */
    public static void drawRectOutline(Vector2f pos, float size, Color color) {
        DrawRectangleLines((int) pos.x, (int) pos.y, (int) size, (int) size, RaylibUtil.getRaylibColor(color));
    }

    /**
     * Draws a straight line from a given starting and ending point.
     *
     * @param start The starting point of the line.
     * @param end The ending point of the line.
     * @param color The color of the line.
     */
    public static void drawLine(Vector2f start, Vector2f end, Color color) {
        DrawLine((int) start.x, (int) start.y, (int) end.x, (int) end.y, RaylibUtil.getRaylibColor(color));
    }

    /**
     * Draws a straight line from a given starting and ending point, with a thickness.
     *
     * @param start The starting point of the line.
     * @param end The ending point of the line.
     * @param color The color of the line.
     * @param thickness The thickness of the line.
     */
    public static void drawLine(Vector2f start, Vector2f end, Color color, float thickness) {
        DrawLineEx(RaylibUtil.getAsRaylibVec2(start), RaylibUtil.getAsRaylibVec2(end), thickness, RaylibUtil.getRaylibColor(color));
    }

    /**
     * Draws a string at a given position, with a font size.
     *
     * @param text The string to draw.
     * @param fontSize The font size of the text.
     * @param pos The position to draw the text at.
     */
    public static void drawString(String text, float fontSize, Vector2f pos) {
        DrawText(text, (int) pos.x, (int) pos.y, (int) fontSize, RaylibUtil.getRaylibColor(new Color(0, 0, 0)));
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
        DrawTextEx(font.asRaylibFont(), text, RaylibUtil.getAsRaylibVec2(pos), fontSize, 2, RaylibUtil.getRaylibColor(new Color(0, 0, 0)));
    }

    /**
     * Fills the background with a given color.
     *
     * @param color The color to fill with.
     */
    public static void fillBackground(Color color) { ClearBackground(RaylibUtil.getRaylibColor(color)); }
}