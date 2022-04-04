package dev.yeff.orbital.ecs;

import dev.yeff.orbital.Game;

public abstract class Component {
    public GameObject parent = null;

    public abstract void update(Game game);

    public abstract void init(Game game);
}