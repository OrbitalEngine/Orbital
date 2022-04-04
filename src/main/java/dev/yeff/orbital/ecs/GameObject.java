package dev.yeff.orbital.ecs;

import dev.yeff.orbital.Game;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class GameObject {
    @Getter
    private List<Component> components;

    public GameObject() {
        components = new ArrayList<>();
    }

    public <T extends Component> T getComponent(Class<T> component) {
        for (Component c : components) {
            // if c can be assigned to the component
            if (component.isAssignableFrom(c.getClass())) {
                try {
                    // cast c to the type of the component
                    return component.cast(c);
                } catch (ClassCastException e) {
                    throw new IllegalStateException(e.toString());
                }
            }
        }

        return null;
    }

    public <T extends Component> void removeComponent(Class<T> component) {
        for (int i = 0; i < components.size(); i++) {
            Component c = components.get(i);

            // if c can be assigned to the component
            if (component.isAssignableFrom(c.getClass())) {
                components.remove(i);
                return;
            }
        }
    }

    public void addComponent(Component component) {
        components.add(component);

        // set the parent of the component after adding
        component.parent = this;
    }

    public void init(Game game) {
        for (Component c : components) {
            c.init(game);
        }
    }

    public void update(Game game) {
        for (Component c : components) {
            c.update(game);
        }
    }
}
