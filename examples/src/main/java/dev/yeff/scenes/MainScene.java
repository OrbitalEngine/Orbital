package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;

import static com.raylib.Jaylib.RED;
import static com.raylib.Raylib.*;

public class MainScene implements Scene {
    private Sprite fastj;
    private Vector2 pos;

    @Override
    public void init(Game game) {
        System.out.println("main scene initialized");

        // forgive me, gods of programming
        fastj = ResourceManager.getSprite("C:\\Users\\aditc\\dev\\Orbital\\examples\\src\\main\\resources\\fastj_icon.png");
        pos = new Vector2().x(GetScreenWidth() / 3).y(GetScreenHeight() / 4);
    }

    @Override
    public void update(Game game, float fps) {
        if (Input.getKeyboard().isKeyDown(Keys.W)) pos.y(pos.y() - 5);
        if (Input.getKeyboard().isKeyDown(Keys.S)) pos.y(pos.y() + 5);
        if (Input.getKeyboard().isKeyDown(Keys.A)) pos.x(pos.x() - 5);
        if (Input.getKeyboard().isKeyDown(Keys.D)) pos.x(pos.x() + 5);
        if (Input.getMouse().isMouseDown(Keys.MOUSE_MIDDLE)) pos.x(GetScreenWidth() / 3).y(GetScreenHeight() / 4);

        game.getRenderer().drawTexture(fastj, pos);
    }

    @Override
    public void dispose(Game game) {
        ResourceManager.disposeSprite("C:\\Users\\aditc\\dev\\Orbital\\examples\\src\\main\\resources\\fastj_icon.png");
        System.out.println(ResourceManager.spriteExists("C:\\Users\\aditc\\dev\\Orbital\\examples\\src\\main\\resources\\fastj_icon.png"));
    }
}
