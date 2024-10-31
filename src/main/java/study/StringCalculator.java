package study;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

/*
사용자가 입력한 문자열 값에 따라 사칙연산을 수행할 수 있는 계산기를 구현해야 한다.
문자열 계산기는 사칙연산의 계산 우선순위가 아닌 입력 값에 따라 계산 순서가 결정된다.
즉, 수학에서는 곱셈, 나눗셈이 덧셈, 뺄셈 보다 먼저 계산해야 하지만 이를 무시한다.
예를 들어 "2 + 3 * 4 / 2"와 같은 문자열을 입력할 경우 2 + 3 * 4 / 2 실행 결과인 10을 출력해야 한다.
*/
public class StringCalculator {

    private final Map<String, BiFunction<Integer, Integer, Integer>> operators;

    public StringCalculator() {
        operators = new HashMap<>();
        operators.put("+", (first, second) -> first + second);
        operators.put("*", (first, second) -> first * second);
        operators.put("-", (first, second) -> first - second);
        operators.put("/", (first, second) -> first / second);
    }

    public int calculate(String input) {
        List<String> split = Arrays.asList(input.split(" "));
        int result = Integer.parseInt(split.get(0));

        for (int i = 1; i < split.size(); i+=2) {
            String operator = split.get(i);
            int numbers = Integer.parseInt(split.get(i + 1));

            if (operators.containsKey(operator)) {
                result = operators.get(operator).apply(result, numbers);
            }
        }
        return result;
    }
}