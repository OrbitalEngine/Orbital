package dev.yeff.orbital.ecs;

import dev.yeff.orbital.Game;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * Stores and uses components to manage object functionality. Used to simplify application code.
 *
 * @author YeffyCodeGit
 * @version 0.0.1
 */
public class GameObject {
    @Getter
    private List<Component> components;

    public GameObject() {
        components = new ArrayList<>();
    }

    /**
     * Gets a component from the object.
     *
     * @param component The component to get.
     * @return The component, null if the object does not have it.
     */
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

    /**
     * Removes a component from the object.
     *
     * @param component The component to remove.
     */
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

    /**
     * Checks if the object has a component.
     *
     * @param component The component to check.
     * @return If the component is on the object or not.
     */
    public <T extends Component> boolean hasComponent(Class<T> component) {
        for (Component c : components) {
            if (component.isAssignableFrom(c.getClass()))
                return true;
        }

        return false;
    }

    /**
     * Adds a new component to the object.
     *
     * @param component The component to add.
     */
    public void addComponent(Component component) {
        components.add(component);

        // set the parent of the component after adding
        component.parent = this;
    }

    /**
     * Initializes all the components on the object at the time of initialization. If other components are added after init is called, they are initialized on adding.
     *
     * @param game The game instance.
     */
    public void init(Game game) {
        for (Component c : components) {
            c.init(game);
        }
    }

    /**
     * Updates all the components on the object every frame.
     *
     * @param game The game instance.
     */
    public void update(Game game) {
        for (Component c : components) {
            c.update(game);
        }
    }
}
