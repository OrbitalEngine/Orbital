package dev.yeff.scenes;

import dev.yeff.components.PlayerComponent;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.audio.AudioManager;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.builders.GameObjectBuilder;
import dev.yeff.orbital.graphics.Renderer;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.Music;
import dev.yeff.orbital.resources.ResourceManager;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;

public class MainScene extends Scene {
    private GameObject player;
    private Sprite sprite;
    private Music music;

    private static final float SPRITE_SPEED = 12.0f;

    @Override
    public void init(Game game) {
        Log.info(getClass(), "main scene initialized");
        sprite = ResourceManager.getSprite(getClass(), "assets/character_0000.png");
        music = ResourceManager.getMusicStream(getClass(), "audio/bensound-epic.mp3");

        music.loop(true);
        AudioManager.playMusic(music);


        player = new GameObjectBuilder(this)
                .withId("Player")
                .withTransform(game.getScreenCenter(), new Vector2f(120.0f, 120.0f))
                .withSprite(sprite)
                .withComponent(new PlayerComponent())
                .build();

        addGameObject(game, player);

        Log.info(getClass(), String.format("FPS: %f, Frame Time: %f", game.getFps(), game.getFrameTime()));
    }

    @Override
    public void update(Game game, float fps) {
    }

    @Override
    public void dispose(Game game) {
        ResourceManager.disposeMusicStream(music);
        Log.info(getClass(), "disposed main scene");
    }
}
