package ui.output;

import static constants.GameConstants.ZERO;
import static messages.ResultViewMessages.*;

public class ResultViewImpl implements ResultView {

    @Override
    public void gameOver() {
        System.out.println(GAME_OVER_MESSAGE);
    }

    @Override
    public void displayResult(int strike, int ball) {
        StringBuilder resultMessage = new StringBuilder();

        if (ball > ZERO) {
            resultMessage.append(ball).append(BALL);
        }
        if (strike > ZERO) {
            hasContent(resultMessage);
            resultMessage.append(strike).append(STRIKE);
        }
        if (resultMessage.length() == ZERO) {
            resultMessage.append(NOTHING);
        }
        System.out.println(resultMessage.toString().trim());
    }

    private static void hasContent(StringBuilder resultMessage) {
        if (resultMessage.length() > ZERO) {
            resultMessage.append(SPACE);
        }
    }
}
