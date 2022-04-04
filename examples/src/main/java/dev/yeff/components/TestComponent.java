package dev.yeff.components;

import dev.yeff.orbital.ecs.Component;
import dev.yeff.orbital.util.Log;

public class TestComponent extends Component {
    public String e;

    @Override
    public void init() {
        Log.info(getClass(), "init test component");
        e = "hello";
    }

    @Override
    public void update() {

    }
}
