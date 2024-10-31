import service.BaseballGame;
import ui.input.InputView;
import ui.output.ResultView;

import java.util.*;

import static constants.GameConstants.*;
import static messages.InputViewMessages.REPLAY;

public class Baseball {

    private final InputView inputView;
    private final ResultView resultView;
    private final BaseballGame baseballGame;

    public Baseball(InputView inputView, ResultView resultView, BaseballGame baseballGame) {
        this.inputView = inputView;
        this.resultView = resultView;
        this.baseballGame = baseballGame;
    }

    public void play() {
        boolean continuePlaying = true;

        while (continuePlaying) {
            runGameLoop();
            continuePlaying = askForReplay();
        }
        inputView.close();
    }

    private boolean askForReplay() {
        return inputView.askReplay().equals(REPLAY.toString());
    }

    private void runGameLoop() {
        List<Integer> computerNumbers = baseballGame.computerNumbers();
        boolean gameEnded = false;

        while (!gameEnded) {
            List<Integer> userNumbers = baseballGame.userNumbers(inputView.userInput());
            if (userNumbers.isEmpty()) {
                continue;
            }
            long[] results = baseballGame.compareNumbers(computerNumbers, userNumbers);
            resultView.displayResult((int) results[1], (int) results[0]);

            gameEnded = checkGameEndCondition(results);
        }
    }

    private boolean checkGameEndCondition(long[] results) {
        boolean isGameEnded = results[1] == NUMBER_COUNT;
        if (isGameEnded) {
            resultView.gameOver();
        }
        return isGameEnded;
    }
}
