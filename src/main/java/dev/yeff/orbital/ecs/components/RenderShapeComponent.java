package dev.yeff.orbital.ecs.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.math.Vector2f;

import static dev.yeff.orbital.graphics.Renderer.*;


/**
 * Component storing data to render a primitive shape.
 *
 * @author YeffyCodeGit
 */
public class RenderShapeComponent extends DrawableComponent {
    public Shapes shape;
    public Colors color;

    public RenderShapeComponent(Shapes shape, Colors color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public void update(Game game) {
        Vector2f scale = parent.getComponent(TransformComponent.class).scale;
        Vector2f position = parent.getComponent(TransformComponent.class).position;

        switch (shape) {
            case CIRCLE: drawCircle(color, position, scale.x); break;
            case RECTANGLE: drawRect(color, position, scale); break;
            case CIRCLE_OUTLINE: drawCircleOutline(color, position, scale.x); break;
            case RECTANGLE_OUTLINE: drawRectOutline(position, scale, color); break;
            default: throw new IllegalStateException("unsupported render shape");
        }
    }

    @Override
    public void init(Game game) {

    }
}
