package dev.yeff.components;

import dev.yeff.orbital.CollisionChecker;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.render.SpriteComponent;
import dev.yeff.orbital.resources.ResourceManager;

public class MouseObjectCollisionComponent extends Component {
    private GameObject obj;

    public MouseObjectCollisionComponent(GameObject obj) {
        this.obj = obj;
    }

    @Override
    public void init(Game game) {

    }

    @Override
    public void update(Game game) {
        if (CollisionChecker.circleWithCircle(obj, parent)) {
            obj.getComponent(SpriteComponent.class).sprite = ResourceManager.getSprite(getClass(), "assets/character_0006.png");
        } else {
            obj.getComponent(SpriteComponent.class).sprite = ResourceManager.getSprite(getClass(), "assets/character_0000.png");
        }
    }
}
