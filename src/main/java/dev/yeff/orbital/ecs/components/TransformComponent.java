package dev.yeff.orbital.ecs.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.math.Vector2f;

public class TransformComponent extends Component {
    public Vector2f position;

    public TransformComponent(Vector2f position) {
        this.position = position;
    }

    public TransformComponent(float x, float y) {
        this.position = new Vector2f(x, y);
    }

    public TransformComponent() {
        this.position = new Vector2f();
    }

    @Override
    public void init(Game game) {

    }

    @Override
    public void update(Game game) {

    }
}
