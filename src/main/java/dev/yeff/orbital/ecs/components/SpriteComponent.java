package dev.yeff.orbital.ecs.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.Sprite;

import static dev.yeff.orbital.graphics.Renderer.drawTexture;

/**
 * Stores data to render a sprite component.
 *
 * @author YeffyCodeGit
 */
public class SpriteComponent extends DrawableComponent {
    public Sprite sprite;

    public SpriteComponent(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public void init(Game game) {

    }

    @Override
    public void update(Game game) {
        Vector2f position = parent.getComponent(TransformComponent.class).position;
        Vector2f scale = parent.getComponent(TransformComponent.class).scale;

        sprite.resize(scale);

        drawTexture(sprite, position);
    }
}
