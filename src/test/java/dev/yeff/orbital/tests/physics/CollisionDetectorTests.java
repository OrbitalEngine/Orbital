package dev.yeff.orbital.tests.physics;

import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("test collision detection between primitive shapes")
public class CollisionDetectorTests implements WithAssertions {
    @Test
    public void test_pointOnLineCollision_shouldReturnTrue() {
        assertThat(true).isTrue();
    }
}
