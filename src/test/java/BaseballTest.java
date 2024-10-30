import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class BaseballTest {

    private Baseball baseball;

    @BeforeEach
    void setUp() {
        baseball = new Baseball();
    }

    @Test
    @DisplayName("랜덤으로 숫자 1 ~ 9까지 확인")
    void randomNumberRange() {
        List<Integer> result = baseball.baseball();

        for (int number : result) {
            assertTrue(number >= 1 && number <= 9, number + "는 1에서 9 사이의 숫자가 아닙니다.");
        }
    }

    @Test
    @DisplayName("생성된 숫자의 개수가 3인지 확인")
    void checkSize() {
        List<Integer> result = baseball.baseball();

        assertEquals(3, result.size());
    }
}