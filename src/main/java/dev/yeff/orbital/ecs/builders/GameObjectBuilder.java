package dev.yeff.orbital.ecs.builders;

import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.*;

/**
 * Builder class which provides functions to build a {@code GameObject}.
 *
 * @author YeffyCodeGit
 */
public class GameObjectBuilder {
    private GameObject object;

    public GameObjectBuilder() {
        object = new GameObject();
    }

    /**
     * Adds a {@code Component} to the object to be built.
     *
     * @param component The component to add to the object.
     * @return The builder instance.
     */
    public GameObjectBuilder withComponent(Component component) {
        object.addComponent(component);
        return this;
    }

    /**
     * Adds a {@code TransformComponent} to the object to be built.
     *
     * @param transform The transform component to add.
     * @return The builder instance.
     */
    public GameObjectBuilder withTransform(TransformComponent transform) {
        return withComponent(transform);
    }

    /**
     * Adds a {@code RenderShapeComponent} to the object to be built.
     *
     * @param shape The shape component to add.
     * @return The builder instance.
     */
    public GameObjectBuilder withShape(RenderShapeComponent shape) {
        if (!object.hasComponent(DrawableComponent.class))
            return withComponent(shape);
        else
            throw new IllegalStateException("Cannot add shape component to object with other render component");
    }

    /**
     * Adds a {@code SpriteComponent} to the object to be built.
     *
     * @param sprite The sprite component to add.
     * @return The builder instance.
     */
    public GameObjectBuilder withSprite(SpriteComponent sprite) {
        if (!object.hasComponent(DrawableComponent.class))
            return withComponent(sprite);
        else
            throw new IllegalStateException("Cannot add sprite component to object with other render component");
    }

    /**
     * Adds a {@code LineComponent} to the object to be built.
     *
     * @param line The line component to add.
     * @return The builder instance.
     */
    public GameObjectBuilder withLine(LineComponent line) {
        if (!object.hasComponent(DrawableComponent.class))
            return withComponent(line);
        else
            throw new IllegalStateException("Cannot add line component to object with other render component");
    }

    /**
     * Adds a {@code TextComponent} to the object to be built.
     *
     * @param text The text component to add.
     * @return The builder instance.
     */
    public GameObjectBuilder withText(TextComponent text) {
        if (!object.hasComponent(DrawableComponent.class))
            return withComponent(text);
        else
            throw new IllegalStateException("Cannot add line component to object with other render component");
    }

    /**
     * Returns the created {@code GameObject}.
     *
     * @return The created GameObject
     */
    public GameObject build() {
        return object;
    }
}
