package dev.yeff.scenes;

import dev.yeff.orbital.Collider;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.ecs.components.RenderShapeComponent;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.scenes.Scene;

public class ThirdScene extends Scene {
    private GameObject centerObj;
    private GameObject collidingObj;
    private boolean colliding;

    @Override
    public void init(Game game) {
        centerObj = new GameObjectBuilder()
                .withTransform(game.getScreenCenter(), new Vector2f(200.0f, 200.0f))
                .withShape(Shapes.RECTANGLE, Colors.RED)
                .build();

        collidingObj = new GameObjectBuilder()
                .withTransform(game.getScreenCenter(), new Vector2f(50.0f, 50.0f))
                .withShape(Shapes.CIRCLE, Colors.GREEN)
                .build();

        addGameObject(game, centerObj);
        addGameObject(game, collidingObj);
    }

    @Override
    public void update(Game game, float fps) {
        collidingObj.getComponent(TransformComponent.class).position = new Vector2f(
                Input.getMouse().getMousePos().x - collidingObj.getComponent(TransformComponent.class).scale.x / 2,
                Input.getMouse().getMousePos().y - collidingObj.getComponent(TransformComponent.class).scale.y / 2
        );

        colliding = Collider.isColliding(centerObj, collidingObj);

        if (colliding)
            centerObj.getComponent(RenderShapeComponent.class).color = Colors.GREEN;
        else
            centerObj.getComponent(RenderShapeComponent.class).color = Colors.RED;
    }

    @Override
    public void dispose(Game game) {

    }
}
