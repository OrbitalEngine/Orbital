package dev.yeff.orbital.ecs.components.collision;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.math.Vector2f;

public class ColliderComponent extends Component {
    public Shapes renderShape;
    public Vector2f colliderScale;

    public ColliderComponent(Shapes renderShape, Vector2f colliderScale) {
        this.renderShape = renderShape;
        this.colliderScale = colliderScale;
    }

    @Override
    public void init(Game game) {

    }

    @Override
    public void update(Game game) {

    }
}
