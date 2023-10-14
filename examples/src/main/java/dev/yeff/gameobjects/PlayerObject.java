package dev.yeff.gameobjects;

import dev.yeff.components.PlayerComponent;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.TransformComponent;
import dev.yeff.orbital.ecs.components.render.SpriteComponent;
import dev.yeff.orbital.resources.Sprite;
import dev.yeff.orbital.scenes.Scene;
import org.joml.Vector2f;

public class PlayerObject extends GameObject {
    public PlayerObject(Scene scene, String id, Vector2f center, Sprite sprite) {
        super(scene, id);
        addComponent(new TransformComponent(center, new Vector2f(120.0f, 120.0f)));
        addComponent(new SpriteComponent(sprite));
        addComponent(new PlayerComponent());
    }
}
