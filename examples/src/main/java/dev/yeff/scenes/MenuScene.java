package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.graphics.Color;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.math.Mathf;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Font;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;

public class MenuScene extends Scene {
    private Font font;
    private GameObject greeting;
    private GameObject test;

    @Override
    public void init(Game game) {
        font = ResourceManager.getFont(getClass(), "fonts/Roboto-Regular.ttf");

        greeting = new GameObjectBuilder(this)
                .withId("Greeting Text")
                .withTransform(new Vector2f(game.getSize().x / 4, game.getSize().y / 3), new Vector2f(0, 0))
                .withText("This is a Orbital demo, \npress Spacebar to go to the actual 'game'.", null, 60.0f)
                .build();

//        test = new GameObjectBuilder(this, "Test")
//                .withTransform(game.getScreenCenter(), new Vector2f(80.0f))
//                .withShape(Shapes.RECTANGLE, new Color(255, 0, 0, 255))
//                .build();

        addGameObject(game, greeting);
//        addGameObject(game, test);

        Log.info(getClass(), "Loaded menu scene");
    }

    @Override
    public void update(Game game, float fps) {
        if (Input.getKeyboard().isKeyDown(Keys.NUM_1))
            game.loadScene("Main");
        if (Input.getKeyboard().isKeyDown(Keys.NUM_2))
            game.loadScene("Collision");
    }

    @Override
    public void dispose(Game game) {
        ResourceManager.disposeFont(font);
        Log.info(getClass(), "menu scene disposed");
    }
}
