package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.ecs.components.render.RenderShapeComponent;
import dev.yeff.orbital.graphics.Color;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.resources.Font;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;
import org.joml.Vector2f;

import java.util.Optional;

public class MenuScene extends Scene {
    private Font font;
    private GameObject greeting;
    private GameObject test;

    @Override
    public void init(Game game) {
//        test = new GameObjectBuilder(this, "Test")
//                .withTransform(game.getScreenCenter(), new Vector2f(90.0f))
//                .withShape(Shapes.RECTANGLE, Color.RED)
//                .build();

        addGameObject(game, test);

        Log.info(getClass(), "Loaded menu scene");
    }

    @Override
    public void update(Game game, float fps) {
        if (Input.getKeyboard().isKeyDown(Keys.NUM_1))
            game.loadScene("Main");
        if (Input.getKeyboard().isKeyDown(Keys.NUM_2))
            game.loadScene("Collision");

        if (Input.getMouse().isMouseDown(Keys.MOUSE_MIDDLE)) {
            test.getComponent(RenderShapeComponent.class).color = Optional.of(Color.GREEN);
        } else {
            test.getComponent(RenderShapeComponent.class).color = Optional.of(Color.RED);
        }
    }

    @Override
    public void dispose(Game game) {
        Log.info(getClass(), "menu scene disposed");
    }
}
