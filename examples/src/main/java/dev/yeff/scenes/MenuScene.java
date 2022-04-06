package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.ecs.components.TextComponent;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.graphics.Renderer;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Font;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;

public class MenuScene extends Scene {
    private Font font;
    private GameObject greeting;

    @Override
    public void init(Game game) {
        font = ResourceManager.getFont(getClass(), "fonts/Roboto-Regular.ttf");

        greeting = new GameObjectBuilder()
                .withTransform(new TransformComponent(new Vector2f(game.getSize().x / 4, game.getSize().y / 3), new Vector2f(0, 0)))
                .withComponent(new TextComponent(60.0f, "This is a Orbital demo, \npress Spacebar to go to the actual 'game'.", null))
                .build();

        addGameObject(game, greeting);

        Log.info(getClass(), "Loaded menu scene");
    }

    @Override
    public void update(Game game, float fps) {
        if (Input.getKeyboard().isKeyDown(Keys.SPACE))
            game.loadScene("Main");
    }

    @Override
    public void dispose(Game game) {
        ResourceManager.disposeFont(font);
        Log.info(getClass(), "menu scene disposed");
    }
}
