package service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static constants.GameConstants.*;
import static constants.GameConstants.ZERO;

public class BaseballGameImpl implements BaseballGame {


    @Override
    public List<Integer> computerNumbers() {
        Random random = new Random();

        return Stream.generate(() -> random.nextInt(MAX_NUMBER) + MIN_NUMBER)
                .distinct()
                .limit(NUMBER_COUNT)
                .collect(Collectors.toList());
    }

    @Override
    public List<Integer> userNumbers(final String input) {
        if (isValidInput(input)) {
            return parseInputToNumbers(input);
        }
        return Collections.emptyList();
    }

    private boolean isValidInput(String input) {
        return input.matches(DIGIT_NUMBER_PATTERN);
    }

    private List<Integer> parseInputToNumbers(String input) {
        return input.chars()
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public long[] compareNumbers(List<Integer> computer, List<Integer> user) {
        long ballCount = IntStream.range(ZERO, computer.size())
                .filter(number -> user.contains(computer.get(number)) && !computer.get(number).equals(user.get(number)))
                .count();

        long strikeCount = IntStream.range(ZERO, computer.size())
                .filter(number -> computer.get(number).equals(user.get(number)))
                .count();

        return new long[]{ballCount, strikeCount};
    }
}
