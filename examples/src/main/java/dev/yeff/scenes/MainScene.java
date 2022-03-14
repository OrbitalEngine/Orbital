package dev.yeff.scenes;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.scenes.Scene;

public class MainScene implements Scene {
    @Override
    public void init(Game game) {
        System.out.println("main scene initialized");
    }

    @Override
    public void update(Game game, float fps) {
        System.out.println(fps);
    }
}
