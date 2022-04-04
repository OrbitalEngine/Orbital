package dev.yeff.orbital.ecs;

public abstract class Component {
    public GameObject parent = null;

    public abstract void update();

    public abstract void init();
}