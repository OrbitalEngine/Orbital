package dev.yeff.gameobjects;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.annotations.Collision;
import dev.yeff.orbital.ecs.annotations.Tag;
import dev.yeff.orbital.ecs.annotations.Transform;
import dev.yeff.orbital.ecs.annotations.Vector;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.ecs.components.render.SpriteComponent;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;

@Tag(tagName = "Player")
@Transform(
        position = @Vector(x = 975.0f / 2.0f, y = 900.0f / 2.0f),
        scale = @Vector(x = 120.0f, y = 120.0f)
)
@Collision(shape = Shapes.RECTANGLE, colliderScale = @Vector(x = 120.0f, y = 120.0f))
public class PlayerObject extends GameObject {
    private static final float SPRITE_SPEED = 13.0f;
    private boolean spriteFlipped;
    private Sprite sprite;
    private TransformComponent transform;

    public PlayerObject(Scene scene, Game game, Sprite spriteResource) {
        super(scene, game);
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
