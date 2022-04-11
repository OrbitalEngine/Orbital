package dev.yeff.orbital.ecs.components;

import dev.yeff.orbital.Game;
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

    public TextComponent(float fontSize, String text, Font font) {
        this.text = text;
        this.font = font;
        this.fontSize = fontSize;
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
