package dev.yeff.orbital.ecs.components.render;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.graphics.Color;
import dev.yeff.orbital.math.Vector2f;

import static dev.yeff.orbital.graphics.Renderer.drawLine;

/**
 * Component storing data to render a line.
 *
 * @author YeffyCodeGit
 */
public class LineComponent extends DrawableComponent {
    public float thickness;
    public Vector2f start;
    public Vector2f end;
    public Color color;

    public LineComponent(float thickness, Vector2f start, Vector2f end, Color color) {
        this.thickness = thickness;
        this.start = start;
        this.end = end;
        this.color = color;
    }

    public LineComponent(float thickness, Vector2f start, Vector2f end) {
        this.thickness = thickness;
        this.start = start;
        this.end = end;
        this.color = new Color(0, 0, 0, 0);
    }

    @Override
    public void init(Game game) {

    }


    @Override
    public void update(Game game) {
        drawLine(start, end, color, thickness);
    }
}
