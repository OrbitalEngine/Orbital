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

        List<Float> lerpedAnswers = List.of(
          25.0f,
          50.0f,
          10.0f,
          10.0f
        );

        for (int i = 0; i < lerpedValues.size(); i++) {
            assertThat(lerpedValues.get(i)).isEqualTo(lerpedAnswers.get(i));
        }
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

        List<Float> invLerpedAnswers = List.of(
          0.0f,
          -0.5f,
          3.0f,
          1.0f
        );

        for (int i = 0; i < invLerpedValues.size(); i++) {
            assertThat(invLerpedValues.get(i)).isEqualTo(invLerpedAnswers.get(i));
        }
    }

    @DisplayName("calculate clamped value between two values")
    @Test
    public void testMathFunctions_clamp() {
        List<Float> clampedValues = List.of(
                Mathf.clamp(10.0f, 5.0f, 6.0f),
                Mathf.clamp(4.0f, 10.0f, 20.0f),
                Mathf.clamp(-5.0f, -1.0f, 1.0f)
        );

        List<Float> clampedAnswers = List.of(
                6.0f,
                10.0f,
                -1.0f
        );

        for (int i = 0; i < clampedValues.size(); i++) {
            assertThat(clampedValues.get(i)).isEqualTo(clampedAnswers.get(i));
        }
    }
}