package dev.yeff.scenes;

import dev.yeff.components.MouseObjectCollisionComponent;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.ecs.components.collision.ColliderComponent;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.scenes.Scene;

public class CollisionScene extends Scene {
    private GameObject obj1;
    private GameObject obj2;

    @Override
    public void init(Game game) {
        obj1 = new GameObjectBuilder(this)
                .withId("Object 1")
                .withTransform(game.getScreenCenter(), new Vector2f(200.0f, 200.0f))
                .withComponent(new ColliderComponent())
                .withShape(Shapes.CIRCLE, Colors.LIME_GREEN)
                .build();

        obj2 = new GameObjectBuilder(this)
                .withId("Object 2")
                .withTransform(Input.getMouse().getMousePos(), new Vector2f(12.0f, 12.0f))
                .withComponent(new ColliderComponent())
                .withComponents(new MouseObjectCollisionComponent(obj1))
                .withShape(Shapes.CIRCLE, Colors.RED)
                .build();

        addGameObject(game, obj1);
        addGameObject(game, obj2);
    }

    @Override
    public void update(Game game, float fps) {
        obj2.getComponent(TransformComponent.class).position = Input.getMouse().getMousePos();
    }

    @Override
    public void dispose(Game game) {

    }
}
