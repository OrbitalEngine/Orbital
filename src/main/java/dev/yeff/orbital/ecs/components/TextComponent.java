package dev.yeff.orbital.ecs.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.resources.Font;

public class TextComponent extends Component {
    public float fontSize;
    public String text;
    public Font font;

    public TextComponent(float fontSize, String text, Font font) {
        this.text = text;
        this.font = font;
        this.fontSize = fontSize;
    }

    @Override
    public void init(Game game) {

    }

    @Override
    public void update(Game game) {

    }
}
