package service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class BaseballGameTest {

    private BaseballGame baseballGame;

    @BeforeEach
    void setUp() {
        baseballGame = new BaseballGameImpl();
    }

    @Test
    @DisplayName("랜덤으로 숫자 1 ~ 9까지 확인")
    void randomNumberRange() {
        List<Integer> result = baseballGame.computerNumbers();

        assertTrue(result.stream()
                .allMatch(number -> number >= 1 && number <= 9)
        );
    }

    @Test
    @DisplayName("생성된 숫자의 개수가 3인지 확인")
    void checkSize() {
        List<Integer> result = baseballGame.computerNumbers();

        assertEquals(3, result.size());
    }


    @ParameterizedTest
    @MethodSource("provideTestCases")
    @DisplayName("볼, 스트라이크 판별 확인")
    void compareNumbers(List<Integer> computer, List<Integer> user, long[] expectedResult) {
        assertArrayEquals(expectedResult, baseballGame.compareNumbers(computer, user));
    }

    private static Stream<Arguments> provideTestCases() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3), List.of(3, 1, 2), new long[]{3, 0}),
                Arguments.of(List.of(1, 2, 3), List.of(1, 2, 3), new long[]{0, 3}),
                Arguments.of(List.of(1, 2, 3), List.of(1, 3, 2), new long[]{2, 1}),
                Arguments.of(List.of(1, 2, 3), List.of(2, 1, 4), new long[]{2, 0}),
                Arguments.of(List.of(1, 2, 3), List.of(4, 5, 6), new long[]{0, 0})
        );
    }
}