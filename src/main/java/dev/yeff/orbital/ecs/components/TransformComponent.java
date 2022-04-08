package dev.yeff.orbital.ecs.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.math.Vector2f;

/**
 * Stores data about object position and scale.
 *
 * @author YeffyCodeGit
 */
public class TransformComponent extends Component {
    public Vector2f position;
    public Vector2f scale;

    public TransformComponent(Vector2f position, Vector2f scale) {
        this.position = position;
        this.scale = scale;
    }

    public TransformComponent(float x, float y, float scaleX, float scaleY) {
        this.position = new Vector2f(x, y);
        this.scale = new Vector2f(scaleX, scaleY);
    }

    public TransformComponent(float position, float scale) {
        this.position = new Vector2f(position, position);
        this.scale = new Vector2f(scale, scale);
    }

    public TransformComponent(Vector2f position, float scale) {
        this.position = new Vector2f(position);
        this.scale = new Vector2f(scale, scale);
    }

    public TransformComponent(float position, Vector2f scale) {
        this.position = new Vector2f(position, position);
        this.scale = new Vector2f(scale);
    }

    public TransformComponent() {
        this.position = new Vector2f();
        this.scale = new Vector2f();
    }

    @Override
    public void init(Game game) {

    }

    @Override
    public void update(Game game) {

    }
}
