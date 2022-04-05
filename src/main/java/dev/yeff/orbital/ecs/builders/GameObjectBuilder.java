package dev.yeff.orbital.ecs.builders;

import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.TransformComponent;

public class GameObjectBuilder {
    private GameObject object;

    public GameObjectBuilder() {
        object = new GameObject();
    }

    public GameObjectBuilder withComponent(Component component) {
        object.addComponent(component);
        return this;
    }

    public GameObjectBuilder withTransform(TransformComponent transform) {
        object.addComponent(transform);
        return this;
    }

    public GameObject build() {
        return object;
    }
}
