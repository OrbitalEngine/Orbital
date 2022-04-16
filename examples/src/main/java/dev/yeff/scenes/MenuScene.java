package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.ecs.components.LineComponent;
import dev.yeff.orbital.ecs.components.TextComponent;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.graphics.Renderer;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keyboard;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Font;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;

public class MenuScene extends Scene {
    private Font font;
    private GameObject greeting;
    private GameObject testLine;

    @Override
    public void init(Game game) {
        font = ResourceManager.getFont(getClass(), "fonts/Roboto-Regular.ttf");

        greeting = new GameObjectBuilder()
                .withTransform(new Vector2f(game.getSize().x / 4, game.getSize().y / 3), new Vector2f(0, 0))
                .withText("This is a Orbital demo, \npress Spacebar to go to the actual 'game'.", null, 60.0f)
                .build();

        testLine = new GameObjectBuilder()
                .withTransform(new Vector2f(0, 0), new Vector2f(0, 0))
                .withLine(new Vector2f(18, 42), new Vector2f(game.getSize().x - 18, 42), 2.0f)
                .build();

        addGameObject(game, greeting);
        addGameObject(game, testLine);

        Log.info(getClass(), "Loaded menu scene");

        Log.info(getClass(), Input.getKeyboard().getClipboardContents());
    }

    @Override
    public void update(Game game, float fps) {
        if (Input.getKeyboard().isKeyDown(Keys.NUM_1))
            game.loadScene("Main");

        if (Input.getKeyboard().isKeyDown(Keys.C))
            Input.getKeyboard().setClipboardContents("[THIS WAS COPIED FROM THE ENGINE]");
    }

    @Override
    public void dispose(Game game) {
        ResourceManager.disposeFont(font);
        Log.info(getClass(), "menu scene disposed");
    }
}
