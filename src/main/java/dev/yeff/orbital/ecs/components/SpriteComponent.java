package dev.yeff.orbital.ecs.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.resources.Sprite;

/**
 * Stores data to render a sprite component.
 *
 * @author YeffyCodeGit
 */
public class SpriteComponent extends Component {
    public Sprite sprite;

    public SpriteComponent(Sprite sprite) {
        this.sprite = sprite;
    }

    @Override
    public void init(Game game) {

    }

    @Override
    public void update(Game game) {

    }
}
