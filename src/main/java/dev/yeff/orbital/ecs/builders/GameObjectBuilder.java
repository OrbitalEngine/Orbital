package dev.yeff.orbital.ecs.builders;

import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.*;
import dev.yeff.orbital.ecs.components.collision.ColliderComponent;
import dev.yeff.orbital.ecs.components.render.*;
import dev.yeff.orbital.graphics.Color;
import dev.yeff.orbital.graphics.Gradient;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.resources.Font;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.joml.Vector2f;

/**
 * Builder class which provides functions to build a {@code GameObject}.
 *
 * @author YeffyCodeGit
 */
public class GameObjectBuilder {
  private GameObject object;
  private Scene scene;
  private String id;
  private List<Component> customComponents;
  private Optional<TransformComponent> transform;
  private Optional<DrawableComponent> renderComponent;
  private Optional<ColliderComponent> collider;

  public GameObjectBuilder(Scene scene) {
    this.scene = scene;
    customComponents = new ArrayList<>();
    transform = Optional.empty();
    renderComponent = Optional.empty();
    collider = Optional.empty();
  }

  public GameObjectBuilder(String id) {
    this.id = id;
    customComponents = new ArrayList<>();
    transform = Optional.empty();
    renderComponent = Optional.empty();
    collider = Optional.empty();
  }

  public GameObjectBuilder(Scene scene, String id) {
    this.scene = scene;
    this.id = id;
    customComponents = new ArrayList<>();
    transform = Optional.empty();
    renderComponent = Optional.empty();
    collider = Optional.empty();
  }

  /**
   * Sets the {@code Scene} for the object to be built.
   *
   * @param scene The scene to set.
   * @return The builder instance.
   */
  public GameObjectBuilder withScene(Scene scene) {
    this.scene = scene;
    return this;
  }

  /**
   * Sets the id of the object to be built.
   *
   * @param id The id of the object.
   * @return The builder instance.
   */
  public GameObjectBuilder withId(String id) {
    this.id = id;
    return this;
  }

  /**
   * Adds a {@code Component} to the object to be built.
   *
   * @param component The component to add to the object.
   * @return The builder instance.
   */
  public GameObjectBuilder withComponent(Component component) {
    customComponents.add(component);
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

    for (Component c : components) builder = withComponent(c);

    return builder;
  }

  /**
   * Adds a {@code TransformComponent} to the object to be built.
   *
   * @param transform The transform component to add.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withTransform(TransformComponent transform) {
    if (this.transform.isPresent()) {
      throw new IllegalStateException(
          "Object already has a transform component, cannot add another one.");
    } else {
      this.transform = Optional.of(transform);

      return withComponent(transform);
    }
  }

  /**
   * Adds a {@code TransformComponent} to the object to be built.
   *
   * @param position The position of the object.
   * @param scale The scale of the object.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withTransform(Vector2f position, Vector2f scale) {
    if (this.transform.isPresent()) {
      throw new IllegalStateException(
          "Object already has a transform component, cannot add another one.");
    } else {
      TransformComponent transform = new TransformComponent(position, scale);

      this.transform = Optional.of(transform);

      return withComponent(transform);
    }
  }

  /**
   * Adds a {@code ColliderComponent} to the object to be built.
   *
   * @param collider The collider component to add.
   * @return The builder instance.
   */
  public GameObjectBuilder withCollider(ColliderComponent collider) {
    if (this.collider.isPresent()) {
      throw new IllegalStateException(
          "Object already has a collider component, cannot add another one.");
    } else {
      this.collider = Optional.of(collider);

      return withComponent(collider);
    }
  }

  /**
   * Adds a {@code ColliderComponent} to the object to be built.
   *
   * @param collisionShape The shape of the collider.
   * @param collisionScale The scale of the collider.
   * @return The builder instance.
   */
  public GameObjectBuilder withCollider(Shapes collisionShape, Vector2f collisionScale) {
    if (this.collider.isPresent()) {
      throw new IllegalStateException(
          "Object already has a collider component, cannot add another one.");
    } else {
      ColliderComponent collider = new ColliderComponent(collisionShape, collisionScale);

      this.collider = Optional.of(collider);

      return withComponent(collider);
    }
  }

  /**
   * Adds a {@code ColliderComponent} to the object to be built.
   *
   * @param collisionShape The shape of the collider.
   * @return The builder instance.
   */
  public GameObjectBuilder withCollider(Shapes collisionShape) {
    if (this.collider.isPresent()) {
      throw new IllegalStateException(
          "Object already has a collider component, cannot add another one.");
    } else {
      if (this.transform.isPresent()) {
        TransformComponent transformComponent = transform.get();
        ColliderComponent collider =
            new ColliderComponent(collisionShape, transformComponent.scale);

        this.collider = Optional.of(collider);

        return withComponent(collider);
      } else {
        throw new IllegalStateException(
            "Object does not have a transform component, cannot infer scale.");
      }
    }
  }

  /**
   * Adds a {@code RenderShapeComponent} to the object to be built.
   *
   * @param shape The shape component to add.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withShape(RenderShapeComponent shape) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      this.renderComponent = Optional.of(shape);
      return withComponent(shape);
    }
  }

  /**
   * Adds a {@code RenderShapeComponent} to the object to be built.
   *
   * @param shape The shape of the object.
   * @param color The color of the shape.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withShape(Shapes shape, Color color) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      RenderShapeComponent shapeComponent = new RenderShapeComponent(shape, color);

      this.renderComponent = Optional.of(shapeComponent);

      return withComponent(shapeComponent);
    }
  }

  /**
   * Adds a {@code RenderShapeComponent} to the object to be built.
   *
   * @param shape The shape of the object.
   * @param gradient The color gradient of the shape.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withShape(Shapes shape, Gradient gradient) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      RenderShapeComponent shapeComponent = new RenderShapeComponent(shape, gradient);

      this.renderComponent = Optional.of(shapeComponent);

      return withComponent(shapeComponent);
    }
  }

  /**
   * Adds a {@code SpriteComponent} to the object to be built.
   *
   * @param sprite The sprite component to add.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withSprite(SpriteComponent sprite) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      this.renderComponent = Optional.of(sprite);

      return withComponent(sprite);
    }
  }

  /**
   * Adds a {@code SpriteComponent} to the object to be built.
   *
   * @param sprite The sprite of the object.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withSprite(Sprite sprite) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      SpriteComponent spriteComponent = new SpriteComponent(sprite);

      this.renderComponent = Optional.of(spriteComponent);

      return withComponent(spriteComponent);
    }
  }

  /**
   * Adds a {@code LineComponent} to the object to be built.
   *
   * @param line The line component to add.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withLine(LineComponent line) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      this.renderComponent = Optional.of(line);

      return withComponent(line);
    }
  }

  /**
   * Adds a {@code LineComponent} to the object to be built.
   *
   * @param start The starting point of the line.
   * @param end The ending point of the line.
   * @param thickness The thickness of the line.
   * @param color The color of the line.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withLine(Vector2f start, Vector2f end, float thickness, Color color) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      LineComponent line = new LineComponent(thickness, start, end, color);

      this.renderComponent = Optional.of(line);

      return withComponent(line);
    }
  }

  /**
   * Adds a {@code LineComponent} to the object to be built.
   *
   * @param start The starting point of the line.
   * @param end The ending point of the line.
   * @param thickness The thickness of the line.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withLine(Vector2f start, Vector2f end, float thickness) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      LineComponent line = new LineComponent(thickness, start, end);

      this.renderComponent = Optional.of(line);

      return withComponent(line);
    }
  }

  /**
   * Adds a {@code TextComponent} to the object to be built.
   *
   * @param text The text component to add.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withText(TextComponent text) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      this.renderComponent = Optional.of(text);

      return withComponent(text);
    }
  }

  /**
   * Adds a {@code TextComponent} to the object to be built.
   *
   * @param text The text.
   * @param font The font of the text.
   * @param fontSize The size of the text.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withText(String text, Font font, float fontSize) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      TextComponent textComponent = new TextComponent(fontSize, text, font);

      this.renderComponent = Optional.of(textComponent);

      return withComponent(textComponent);
    }
  }

  /**
   * Adds a {@code TextComponent} to the object to be built.
   *
   * @param text The text.
   * @param font The font of the text.
   * @param fontSize The size of the text.
   * @param color The color of the text.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withText(String text, Font font, float fontSize, Color color) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      TextComponent textComponent = new TextComponent(fontSize, text, font, color);

      this.renderComponent = Optional.of(textComponent);

      return withComponent(textComponent);
    }
  }

  /**
   * Adds a {@code TextComponent} to the object to be built.
   *
   * @param text The text.
   * @param fontSize The size of the text.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withText(String text, float fontSize) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      TextComponent textComponent = new TextComponent(fontSize, text);

      this.renderComponent = Optional.of(textComponent);

      return withComponent(textComponent);
    }
  }

  /**
   * Adds a {@code TextComponent} to the object to be built.
   *
   * @param text The text.
   * @param fontSize The size of the text.
   * @param color The color of the text.
   * @throws IllegalStateException If there was an error adding the component.
   * @return The builder instance.
   */
  public GameObjectBuilder withText(String text, float fontSize, Color color) {
    if (renderComponent.isPresent()) {
      throw new IllegalStateException(
          "Render component has already been added, cannot add another one.");
    } else {
      TextComponent textComponent = new TextComponent(fontSize, text, color);

      this.renderComponent = Optional.of(textComponent);

      return withComponent(textComponent);
    }
  }

  /**
   * Returns the created {@code GameObject}.
   *
   * @return The created GameObject
   */
//  public GameObject build() {
//    GameObject object = new GameObject(scene, id);
//
//    for (Component c : customComponents) object.addComponent(c);
//
//    return object;
//  }
}
