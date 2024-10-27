package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
    }

    @Test
    void size() {
        assertThat(numbers.size()).isEqualTo(5);
    }

    @Test
    void contains() {
        assertThat(numbers.contains(1)).isTrue();
        assertThat(numbers.contains(2)).isTrue();
        assertThat(numbers.contains(6)).isFalse();
        assertThat(numbers.contains(null)).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void containsTrue(Integer number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @ValueSource(ints = {6})
    void containsFalse(Integer number) {
        assertThat(numbers.contains(number)).isFalse();
    }

    @ParameterizedTest
    @CsvSource({
            "1, true",
            "2, true",
            "6, false",
            "7, false"
    })
    void containsCsv(Integer number, boolean expected) {
        assertThat(numbers.contains(number)).isEqualTo(expected);
    }

}
