package service;

import java.util.List;

public interface BaseballGame {
    List<Integer> computerNumbers();
    List<Integer> userNumbers(String input);
    long[] compareNumbers(List<Integer> computer, List<Integer> user);
}
