package dev.yeff.orbital.tests.math;

import dev.yeff.orbital.math.Mathf;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("tests math calculation functions")
public class MathTests implements WithAssertions {
    @DisplayName("calculate linear interpolation")
    @Test
    public void testMathFunctions_lerp() {
        List<Float> lerpedValues = List.of(
                Mathf.lerp(0.0f, 50.0f, 0.5f),
                Mathf.lerp(10.0f, 50.0f, 1.0f),
                Mathf.lerp(10.0f, 0.0f, 0.0f),
                Mathf.lerp(0.0f, 10.0f, 1.0f)
        );

        assertThat(lerpedValues.get(0)).isEqualTo(25.0f);
        assertThat(lerpedValues.get(1)).isEqualTo(50.0f);
        assertThat(lerpedValues.get(2)).isEqualTo(10.0f);
        assertThat(lerpedValues.get(3)).isEqualTo(10.0f);
    }

    @DisplayName("calculate linear interpolation point from linear interpolation result")
    @Test
    public void testMathFunctions_inverseLerp() {
        List<Float> invLerpedValues = List.of(
                Mathf.inverseLerp(10.0f, 20.0f, 10.0f),
                Mathf.inverseLerp(10.0f, 20.0f, 5.0f),
                Mathf.inverseLerp(10.0f, 20.0f, 40.0f),
                Mathf.inverseLerp(10.0f, 20.0f, 20f)
        );

        assertThat(invLerpedValues.get(0)).isEqualTo(0.0f);
        assertThat(invLerpedValues.get(1)).isEqualTo(-0.5f);
        assertThat(invLerpedValues.get(2)).isEqualTo(3.0f);
        assertThat(invLerpedValues.get(3)).isEqualTo(1.0f);
    }
}