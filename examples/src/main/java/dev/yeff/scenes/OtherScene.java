package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.scenes.Scene;
import dev.yeff.orbital.util.Log;

public class OtherScene implements Scene {
    @Override
    public void init(Game game) {
        Log.info(OtherScene.class, "other scene init");
    }

    @Override
    public void update(Game game, float fps) {
        Log.info(OtherScene.class, fps);
    }

    @Override
    public void dispose(Game game) {
        Log.info(OtherScene.class, "other scene dispose");
    }
}
