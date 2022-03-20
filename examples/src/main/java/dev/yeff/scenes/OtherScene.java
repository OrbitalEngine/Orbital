package dev.yeff.scenes;

import com.raylib.Raylib;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;

import static com.raylib.Raylib.GetScreenHeight;
import static com.raylib.Raylib.GetScreenWidth;

public class OtherScene implements Scene {
    private Raylib.Vector2 pos;
    private Sprite sprite;

    @Override
    public void init(Game game) {
        Log.info(MainScene.class, "other scene initialized");

        // forgive me, gods of programming
        pos = new Raylib.Vector2().x(game.getWidth() / 3).y(game.getHeight() / 4);
        sprite = ResourceManager.getSprite("C:\\Users\\aditc\\dev\\Orbital\\examples\\src\\main\\resources\\fastj_icon.png");
    }

    @Override
    public void update(Game game, float fps) {
        if (Input.getKeyboard().isKeyDown(Keys.W)) pos.y(pos.y() - 5);
        if (Input.getKeyboard().isKeyDown(Keys.S)) pos.y(pos.y() + 5);
        if (Input.getKeyboard().isKeyDown(Keys.A)) pos.x(pos.x() - 5);
        if (Input.getKeyboard().isKeyDown(Keys.D)) pos.x(pos.x() + 5);

        sprite.resize(new Raylib.Vector2().x(300).y(300));
        game.getRenderer().drawTexture(sprite, pos);
    }

    @Override
    public void dispose(Game game) {
        ResourceManager.disposeSprite("C:\\Users\\aditc\\dev\\Orbital\\examples\\src\\main\\resources\\fastj_icon.png");
        Log.info(MainScene.class, "disposed other scene");
    }
}
