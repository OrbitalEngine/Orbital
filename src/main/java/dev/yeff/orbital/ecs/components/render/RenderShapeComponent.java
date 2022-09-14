package dev.yeff.orbital.ecs.components.render;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.graphics.Color;
import dev.yeff.orbital.graphics.Gradient;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.math.Vector2f;

import java.util.Optional;

import static dev.yeff.orbital.graphics.Renderer.*;


/**
 * Component storing data to render a primitive shape.
 *
 * @author YeffyCodeGit
 */
public class RenderShapeComponent extends DrawableComponent {
    public Shapes shape;
    public Optional<Color> color;
    public Optional<Gradient> gradient;

    public RenderShapeComponent(Shapes shape, Color color) {
        this.shape = shape;
        this.color = Optional.of(color);
        this.gradient = Optional.empty();
    }

    public RenderShapeComponent(Shapes shape, Gradient gradient) {
        this.shape = shape;
        this.color = Optional.empty();
        this.gradient = Optional.of(gradient);
    }

    @Override
    public void update(Game game) {
        Vector2f scale = parent.getComponent(TransformComponent.class).scale;
        Vector2f position = parent.getComponent(TransformComponent.class).position;

        if (shape == Shapes.CIRCLE) {
            color.ifPresent(value -> drawCircle(value, position, scale.x));
            gradient.ifPresent(value -> drawCircleGradient(value, position, scale.x));
        } else if (shape == Shapes.RECTANGLE) {
            color.ifPresent(value -> drawRect(value, position, scale));
            gradient.ifPresent(value -> drawRectGradient(value, position, scale));
        } else if (shape == Shapes.CIRCLE_OUTLINE) {
            color.ifPresent(value -> drawCircleOutline(value, position, scale.x));
        } else if (shape == Shapes.RECTANGLE_OUTLINE) {
            color.ifPresent(value -> drawRectOutline(position, scale, value));
        }
    }

    @Override
    public void init(Game game) {

    }
}
