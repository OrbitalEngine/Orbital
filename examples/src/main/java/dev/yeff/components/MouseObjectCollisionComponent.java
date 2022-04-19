package dev.yeff.components;

import dev.yeff.orbital.Collider;
import dev.yeff.orbital.Game;
import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.ecs.GameObject;
import dev.yeff.orbital.ecs.components.render.RenderShapeComponent;
import dev.yeff.orbital.graphics.Shapes;

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
        if (Collider.circleWithCircle(obj, parent)) {
            obj.getComponent(RenderShapeComponent.class).shape = Shapes.CIRCLE_OUTLINE;
        } else {
            obj.getComponent(RenderShapeComponent.class).shape = Shapes.CIRCLE;
        }
    }
}
