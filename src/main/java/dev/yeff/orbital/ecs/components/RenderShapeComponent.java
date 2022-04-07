package dev.yeff.orbital.ecs.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.graphics.Shapes;

/**
 * Component storing data to render a primitive shape.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class RenderShapeComponent extends Component {
    public Shapes shape;
    public Colors color;

    public RenderShapeComponent(Shapes shape, Colors color) {
        this.shape = shape;
        this.color = color;
    }

    @Override
    public void update(Game game) {

    }

    @Override
    public void init(Game game) {

    }
}
