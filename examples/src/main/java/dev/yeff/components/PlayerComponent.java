package dev.yeff.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.components.render.SpriteComponent;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.resources.Sprite;

public class PlayerComponent extends Component {
    public TransformComponent transform;
    public Sprite sprite;
    private boolean spriteFlipped;

    private static final float SPRITE_SPEED = 13.0f;

    @Override
    public void init(Game game) {
        transform = parent.getComponent(TransformComponent.class);
        sprite = parent.getComponent(SpriteComponent.class).sprite;
    }

    @Override
    public void update(Game game) {
        if (Input.getKeyboard().isKeyDown(Keys.W)) {
            transform.position.y -= SPRITE_SPEED;
        }
        if (Input.getKeyboard().isKeyDown(Keys.S)) {
            transform.position.y += SPRITE_SPEED;
        }
        if (Input.getKeyboard().isKeyDown(Keys.A)) {
            if (spriteFlipped) {
                spriteFlipped = false;
                sprite.flipX();
            }

            transform.position.x -= SPRITE_SPEED;
        }
        if (Input.getKeyboard().isKeyDown(Keys.D)) {
            if (!spriteFlipped) {
                spriteFlipped = true;
                sprite.flipX();
            }

            transform.position.x += SPRITE_SPEED;
        }
    }
}
