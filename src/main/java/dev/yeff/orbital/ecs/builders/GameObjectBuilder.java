package dev.yeff.orbital.ecs.builders;

import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.RenderShapeComponent;
import dev.yeff.orbital.ecs.components.SpriteComponent;
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
        return withComponent(transform);
    }

    public GameObjectBuilder withShape(RenderShapeComponent shape) {
        if (!object.hasComponent(SpriteComponent.class))
            return withComponent(shape);
        else
            throw new IllegalStateException("Cannot add shape component to object with sprite component");
    }

    public GameObjectBuilder withSprite(SpriteComponent sprite) {
        if (!object.hasComponent(RenderShapeComponent.class))
            return withComponent(sprite);
        else
            throw new IllegalStateException("Cannot add sprite component to object with shape component");
    }

    public GameObject build() {
        return object;
    }
}
