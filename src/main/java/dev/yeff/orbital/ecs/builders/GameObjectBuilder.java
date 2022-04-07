package dev.yeff.orbital.ecs.builders;

import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.*;

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
        if (!object.hasComponent(SpriteComponent.class)
                && !object.hasComponent(LineComponent.class)
                && !object.hasComponent(TextComponent.class))
            return withComponent(shape);
        else
            throw new IllegalStateException("Cannot add shape component to object with other render component");
    }

    public GameObjectBuilder withSprite(SpriteComponent sprite) {
        if (!object.hasComponent(RenderShapeComponent.class)
                && !object.hasComponent(LineComponent.class)
                && !object.hasComponent(TextComponent.class))
            return withComponent(sprite);
        else
            throw new IllegalStateException("Cannot add sprite component to object with other render component");
    }

    public GameObjectBuilder withLine(LineComponent line) {
        if (!object.hasComponent(RenderShapeComponent.class)
                && !object.hasComponent(SpriteComponent.class)
                && !object.hasComponent(TextComponent.class))
            return withComponent(line);
        else
            throw new IllegalStateException("Cannot add line component to object with other render component");
    }

    public GameObjectBuilder withText(TextComponent line) {
        if (!object.hasComponent(RenderShapeComponent.class)
                && !object.hasComponent(SpriteComponent.class)
                && !object.hasComponent(LineComponent.class))
            return withComponent(line);
        else
            throw new IllegalStateException("Cannot add line component to object with other render component");
    }

    public GameObject build() {
        return object;
    }
}
