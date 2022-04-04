package dev.yeff.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.graphics.Renderer;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Sprite;

public class PlayerComponent extends Component {
    public Vector2f pos;
    public Sprite sprite;
    private boolean spriteFlipped;

    private static final float SPRITE_SPEED = 13.0f;

    @Override
    public void init(Game game) {
        pos = game.getScreenCenter();
        sprite = ResourceManager.getSprite(getClass(), "assets/character_0000.png");

        sprite.resize(new Vector2f(120, 120));
    }

    @Override
    public void update(Game game) {
        if (Input.getKeyboard().isKeyDown(Keys.W)) {
            pos.y -= SPRITE_SPEED;
        }
        if (Input.getKeyboard().isKeyDown(Keys.S)) {
            pos.y += SPRITE_SPEED;
        }
        if (Input.getKeyboard().isKeyDown(Keys.A)) {
            if (spriteFlipped) {
                spriteFlipped = false;
                sprite.flipX();
            }

            pos.x -= SPRITE_SPEED;
        }
        if (Input.getKeyboard().isKeyDown(Keys.D)) {
            if (!spriteFlipped) {
                spriteFlipped = true;
                sprite.flipX();
            }

            pos.x += SPRITE_SPEED;
        }

        Renderer.drawTexture(sprite, pos);
    }
}
