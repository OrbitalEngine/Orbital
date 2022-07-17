package dev.yeff.scenes;

import dev.yeff.components.PlayerComponent;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.ecs.components.render.RenderShapeComponent;
import dev.yeff.orbital.graphics.Color;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.physics.collision.Collision;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;

public class CollisionScene extends Scene {
    private GameObject obj2;
    private GameObject player;

    private Sprite sprite;

    @Override
    public void init(Game game) {
        sprite = ResourceManager.getSprite(getClass(), "assets/character_0000.png");

        player = new GameObjectBuilder(this, "Player")
                .withTransform(game.getScreenCenter(), new Vector2f(60.0f))
                .withSprite(sprite)
                .withCollider(Shapes.RECTANGLE, new Vector2f(60.0f))
                .withComponent(new PlayerComponent())
                .build();

        obj2 = new GameObjectBuilder(this, "Object 1")
                .withTransform(game.getScreenCenter(), new Vector2f(80.0f))
                .withShape(Shapes.RECTANGLE, new Color(0, 255, 0))
                .withCollider(Shapes.RECTANGLE, new Vector2f(80.0f))
                .build();

        addGameObject(game, obj2);
        addGameObject(game, player);
    }

    @Override
    public void update(Game game, float fps) {
        if (Collision.isColliding(player, obj2)) {
            obj2.getComponent(RenderShapeComponent.class).color = new Color(255, 0, 0);
        } else {
            obj2.getComponent(RenderShapeComponent.class).color = new Color(0, 255, 0);
        }
    }

    @Override
    public void dispose(Game game) {
        ResourceManager.disposeSprite(sprite);
    }
}
