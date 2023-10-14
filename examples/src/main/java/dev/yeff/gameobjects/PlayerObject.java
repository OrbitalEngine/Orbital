package dev.yeff.gameobjects;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.ObjectId;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.ecs.components.render.SpriteComponent;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;
import org.joml.Vector2f;

@ObjectId(id = "Player")
public class PlayerObject extends GameObject {
    private static final float SPRITE_SPEED = 13.0f;
    private boolean spriteFlipped;
    private Sprite sprite;
    private TransformComponent transform;

    public PlayerObject(Scene scene, Game game, Sprite spriteResource) {
        super(scene, game);
        addComponent(new TransformComponent(game.getScreenCenter(), new Vector2f(120.0f, 120.0f)));
        addComponent(new SpriteComponent(spriteResource));

        this.sprite = spriteResource;
        transform = getComponent(TransformComponent.class);
    }

    @Override
    public void init(Game game) {

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
