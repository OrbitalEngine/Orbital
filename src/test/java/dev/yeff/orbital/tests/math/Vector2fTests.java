package dev.yeff.orbital.tests.math;

import dev.yeff.orbital.math.Mathf;
import dev.yeff.orbital.math.Vector2f;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("tests vec2f class and vec2f math calculations")
public class Vector2fTests implements WithAssertions {
    @DisplayName("creating a vector with default values")
    @Test
    public void testCreateVector_withDefaultValues() {
        Vector2f vector2f = new Vector2f();

        assertThat(vector2f.x).isEqualTo(0.0f);
        assertThat(vector2f.y).isEqualTo(0.0f);
    }

    @DisplayName("creating a vector with custom values")
    @Test
    public void testCreateVector_withCustomValues() {
        Vector2f vector2f = new Vector2f(5.0f, 7.0f);

        assertThat(vector2f.x).isEqualTo(5.0f);
        assertThat(vector2f.y).isEqualTo(7.0f);
    }

    @DisplayName("adding two vectors together")
    @Test
    public void testVectorMath_addVectors() {
        Vector2f firstVector = new Vector2f(5.0f, 5.0f);
        Vector2f otherVector = new Vector2f(5.0f, 5.0f);

        firstVector.add(otherVector);

        assertThat(firstVector.x).isEqualTo(10.0f);
        assertThat(firstVector.y).isEqualTo(10.0f);
    }

    @DisplayName("subtract two vectors from each other")
    @Test
    public void testVectorMath_subtractVectors() {
        Vector2f firstVector = new Vector2f(5.0f, 5.0f);
        Vector2f otherVector = new Vector2f(5.0f, 5.0f);

        firstVector.subtract(otherVector);

        assertThat(firstVector.x).isEqualTo(0.0f);
        assertThat(firstVector.y).isEqualTo(0.0f);
    }

    @DisplayName("multiplying two vectors together")
    @Test
    public void testVectorMath_multiplyVectors() {
        Vector2f firstVector = new Vector2f(5.0f, 5.0f);
        Vector2f otherVector = new Vector2f(5.0f, 5.0f);

        firstVector.multiply(otherVector);

        assertThat(firstVector.x).isEqualTo(25.0f);
        assertThat(firstVector.y).isEqualTo(25.0f);
    }

    @DisplayName("dividing two vectors from each other")
    @Test
    public void testVectorMath_divideVectors() {
        Vector2f firstVector = new Vector2f(5.0f, 5.0f);
        Vector2f otherVector = new Vector2f(5.0f, 5.0f);

        firstVector.divide(otherVector);

        assertThat(firstVector.x).isEqualTo(1.0f);
        assertThat(firstVector.y).isEqualTo(1.0f);
    }

    @DisplayName("generating random vectors with int min and max")
    @Test
    public void testVectorMath_genRandomVector_withIntMinMaxValueRange() {
        Mathf.setRandomSeed(10);

        Vector2f randomVector = Mathf.generateRandomVec(1, 10);

        assertThat(randomVector.x).isEqualTo(2.0f);
        assertThat(randomVector.y).isEqualTo(10.0f);
    }

    @DisplayName("generating random vectors with vector min and max")
    @Test
    public void testVectorMath_genRandomVector_withVectorMinMaxValueRange() {
        Mathf.setRandomSeed(10);

        Vector2f randomVector = Mathf.generateRandomVec(new Vector2f(5, 5), new Vector2f(10, 10));

        assertThat(randomVector.x).isEqualTo(10.0f);
        assertThat(randomVector.y).isEqualTo(8.0f);
    }

    @DisplayName("normalizing a vector")
    @Test
    public void testVectorMath_normalizeVector() {
        Vector2f vector2f = new Vector2f(50, 0);
        Vector2f normalized = Mathf.normalize(vector2f);

        assertThat(normalized.x).isEqualTo(1.0f);
        assertThat(normalized.y).isEqualTo(0.0f);
    }
}
