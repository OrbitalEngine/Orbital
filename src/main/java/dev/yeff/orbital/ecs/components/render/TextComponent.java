package dev.yeff.orbital.ecs.components.render;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.graphics.Color;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.Font;

import static dev.yeff.orbital.graphics.Renderer.drawString;

/**
 * Stores data to render a string of text, with an optional font.
 *
 * @author YeffyCodeGit
 */
public class TextComponent extends DrawableComponent {
    public float fontSize;
    public String text;
    public Font font;
    public Color color;

    public TextComponent(float fontSize, String text, Font font, Color color) {
        this.text = text;
        this.font = font;
        this.fontSize = fontSize;
        this.color = color;
    }

    public TextComponent(float fontSize, String text, Font font) {
        this.text = text;
        this.font = font;
        this.fontSize = fontSize;
        this.color = Color.BLACK;
    }

    public TextComponent(float fontSize, String text, Color color) {
        this.text = text;
        this.font = null;
        this.fontSize = fontSize;
        this.color = color;
    }

    public TextComponent(float fontSize, String text) {
        this.text = text;
        this.font = null;
        this.fontSize = fontSize;
        this.color = Color.BLACK;
    }

    @Override
    public void init(Game game) {

    }

    @Override
    public void update(Game game) {
        Vector2f position = parent.getComponent(TransformComponent.class).position;

        if (font != null)
            drawString(text, fontSize, position, font);
        else
            drawString(text, fontSize, position);
    }
}
