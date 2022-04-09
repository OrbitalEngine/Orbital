package dev.yeff.orbital.ecs.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.graphics.Colors;
import dev.yeff.orbital.math.Vector2f;

/**
 * Component storing data to render a line.
 *
 * @author YeffyCodeGit
 */
public class LineComponent extends DrawableComponent {
    public float thickness;
    public Vector2f start;
    public Vector2f end;
    public Colors color;

    public LineComponent(float thickness, Vector2f start, Vector2f end, Colors color) {
        this.thickness = thickness;
        this.start = start;
        this.end = end;
        this.color = color;
    }

    public LineComponent(float thickness, Vector2f start, Vector2f end) {
        this.thickness = thickness;
        this.start = start;
        this.end = end;
        this.color = Colors.BLACK;
    }

    @Override
    public void init(Game game) {

    }


    @Override
    public void update(Game game) {

    }
}
