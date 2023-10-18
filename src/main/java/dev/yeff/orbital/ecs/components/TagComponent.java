package dev.yeff.orbital.ecs.components;

import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;

/**
 * Acts as a unique identifier for every {@code GameObject}.
 *
 * @author YeffyCodeGit
 */
public class TagComponent extends Component {
    public String tagName;

    public TagComponent(String tagName) {
        if (tagName.isBlank() || tagName.isEmpty()) {
            throw new IllegalStateException("Tag name cannot be blank or empty.");
        }

        this.tagName = tagName;
    }

    @Override
    public void init(Game game) {

    }

    @Override
    public void update(Game game) {

    }
}
