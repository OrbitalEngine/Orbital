package dev.yeff.scenes;

import dev.yeff.gameobjects.PlayerObject;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.ecs.components.TagComponent;
import dev.yeff.orbital.ecs.components.collision.ColliderComponent;
import dev.yeff.orbital.ecs.components.render.RenderShapeComponent;
import dev.yeff.orbital.graphics.Color;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.physics.collision.Collision;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;
import org.joml.Vector2f;

import java.util.Optional;

public class CollisionScene extends Scene {
    private GameObject obj2;
    private GameObject player;

    private Sprite sprite;

    @Override
    public void init(Game game) {
        sprite = ResourceManager.getSprite(getClass(), "assets/character_0000.png");

        player = new PlayerObject(this, game, sprite);
//
        obj2 = new GameObjectBuilder(this)
                .withTransform(game.getScreenCenter(), new Vector2f(80.0f))
                .withShape(Shapes.RECTANGLE, new Color(0, 255, 0))
                .withCollider(Shapes.RECTANGLE)
                .withComponent(new TagComponent("Object 2"))
                .build(game);

        addGameObject(game, obj2);
        addGameObject(game, player);

        System.out.printf("Collider Scale: %f", obj2.getComponent(ColliderComponent.class).colliderScale.x);
    }

    @Override
    public void update(Game game, float fps) {
        GameObject foundPlayer = findObject("Player");

        // TODO: found GameObjects do not seem to work

        if (Collision.isColliding(player, obj2)) {
            obj2.getComponent(RenderShapeComponent.class).color = Optional.of(new Color(255, 0, 0));
        } else {
            obj2.getComponent(RenderShapeComponent.class).color = Optional.of(new Color(0, 255, 0));
        }
    }

    @Override
    public void dispose(Game game) {
        ResourceManager.disposeSprite(sprite);
    }
}
