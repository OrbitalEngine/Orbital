package dev.yeff.components;

import dev.yeff.orbital.ecs.components.render.RenderShapeComponent;
import dev.yeff.orbital.graphics.Shapes;
import dev.yeff.orbital.physics.collision.CollisionChecker;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.GameObject;

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
        if (CollisionChecker.isColliding(obj, parent)) {
            obj.getComponent(RenderShapeComponent.class).shape = Shapes.CIRCLE_OUTLINE;
        } else {
            obj.getComponent(RenderShapeComponent.class).shape = Shapes.CIRCLE;
        }
    }
}
