package dev.yeff.orbital.ecs.builders;

import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.*;
import dev.yeff.orbital.ecs.components.render.*;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.math.Vector2f;
import dev.yeff.orbital.resources.Font;
import dev.yeff.orbital.resources.Sprite;

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
     * Adds multiple {@code Component}'s to the object to be built in one function call.
     *
     * @param components All the components to add.
     * @return The builder instance.
     */
    public GameObjectBuilder withComponents(Component... components) {
        GameObjectBuilder builder = this;

        for (Component c : components)
            builder = withComponent(c);

        return builder;
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
     * Adds a {@code TransformComponent} to the object to be built.
     *
     * @param position The position of the object.
     * @param scale The scale of the object.
     * @return The builder instance.
     */
    public GameObjectBuilder withTransform(Vector2f position, Vector2f scale) {
        return withComponent(new TransformComponent(position, scale));
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
     * Adds a {@code RenderShapeComponent} to the object to be built.
     *
     * @param shape The shape of the object.
     * @param color The color of the shape.
     * @return The builder instance.
     */
    public GameObjectBuilder withShape(Shapes shape, Colors color) {
        if (!object.hasComponent(DrawableComponent.class))
            return withComponent(new RenderShapeComponent(shape, color));
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
     * Adds a {@code SpriteComponent} to the object to be built.
     *
     * @param sprite The sprite of the object.
     * @return The builder instance.
     */
    public GameObjectBuilder withSprite(Sprite sprite) {
        if (!object.hasComponent(DrawableComponent.class))
            return withComponent(new SpriteComponent(sprite));
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
     * Adds a {@code LineComponent} to the object to be built.
     *
     * @param start The starting point of the line.
     * @param end The ending point of the line.
     * @param thickness The thickness of the line.
     * @param color The color of the line.
     * @return The builder instance.
     */
    public GameObjectBuilder withLine(Vector2f start, Vector2f end, float thickness, Colors color) {
        if (!object.hasComponent(DrawableComponent.class))
            return withComponent(new LineComponent(thickness, start, end, color));
        else
            throw new IllegalStateException("Cannot add line component to object with other render component");
    }

    /**
     * Adds a {@code LineComponent} to the object to be built.
     *
     * @param start The starting point of the line.
     * @param end The ending point of the line.
     * @param thickness The thickness of the line.
     * @return The builder instance.
     */
    public GameObjectBuilder withLine(Vector2f start, Vector2f end, float thickness) {
        if (!object.hasComponent(DrawableComponent.class))
            return withComponent(new LineComponent(thickness, start, end));
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
     * Adds a {@code TextComponent} to the object to be built.
     *
     * @param text The text.
     * @param font The font of the text.
     * @param fontSize The size of the text.
     * @return The builder instance.
     */
    public GameObjectBuilder withText(String text, Font font, float fontSize) {
        if (!object.hasComponent(DrawableComponent.class))
            return withComponent(new TextComponent(fontSize, text, font));
        else
            throw new IllegalStateException("Cannot add line component to object with other render component");
    }

    /**
     * Adds a {@code TextComponent} to the object to be built.
     *
     * @param text The text.
     * @param fontSize The size of the text.
     * @return The builder instance.
     */
    public GameObjectBuilder withText(String text, float fontSize) {
        if (!object.hasComponent(DrawableComponent.class))
            return withComponent(new TextComponent(fontSize, text, null));
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
