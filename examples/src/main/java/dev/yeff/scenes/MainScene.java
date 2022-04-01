package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.audio.AudioManager;
import dev.yeff.orbital.graphics.Renderer;
import dev.yeff.orbital.io.Input;
import dev.yeff.orbital.io.Keys;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.Music;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;

public class MainScene implements Scene {
    private Vector2f pos;
    private Sprite sprite;
    private Music music;
    private boolean spriteFlipped;

    private static final float SPRITE_SPEED = 12.0f;

    @Override
    public void init(Game game) {
        Log.info(MainScene.class, "main scene initialized");
        Log.info(MainScene.class, String.valueOf(getClass().getClassLoader().getResource("assets/character_0000.png")));

        sprite = ResourceManager.getSprite(getClass(), "assets/character_0000.png");
        music = ResourceManager.getMusicStream(getClass(), "audio/bensound-epic.mp3");

        music.loop(true);
        AudioManager.playMusic(music);

        sprite.resize(new Vector2f(120, 120));
        pos = game.getScreenCenter();
    }

    @Override
    public void update(Game game, float fps) {
        if (Input.getKeyboard().isKeyDown(Keys.W)) {
            pos.y -= SPRITE_SPEED;
        }
        if (Input.getKeyboard().isKeyDown(Keys.S)) {
            pos.y += SPRITE_SPEED;
        }
        if (Input.getKeyboard().isKeyDown(Keys.A)) {
            if (spriteFlipped) {
                spriteFlipped = false;
                sprite.flipX();
            }

            pos.x -= SPRITE_SPEED;
        }
        if (Input.getKeyboard().isKeyDown(Keys.D)) {
            if (!spriteFlipped) {
                spriteFlipped = true;
                sprite.flipX();
            }

            pos.x += SPRITE_SPEED;
        }

        Renderer.drawTexture(sprite, pos);

        Log.info(MainScene.class, pos);
    }

    @Override
    public void dispose(Game game) {
        ResourceManager.disposeSprite(sprite);
        ResourceManager.disposeMusicStream(music);
        Log.info(MainScene.class, "disposed main scene");
    }
}
