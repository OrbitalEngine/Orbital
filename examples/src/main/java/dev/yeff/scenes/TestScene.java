package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.graphics.Color;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;

public class TestScene extends Scene {
    private int i = 0;
    private GameObject object;

    @Override
    public void init(Game game) {
        object = new GameObjectBuilder(this, "Object")
                .withTransform(game.getScreenCenter(), new Vector2f(50.0f))
                .withShape(Shapes.CIRCLE, Color.RED)
                .build();

        addGameObject(game, object);
    }

    @Override
    public void update(Game game, float fps) {
        i++;

        if (i == 129) {
            removeGameObject("Object");
        }

        Log.info(getClass(), i);
    }

    @Override
    public void dispose(Game game) {

    }
}
