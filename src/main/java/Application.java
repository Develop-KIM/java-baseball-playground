import service.BaseballGame;
import service.BaseballGameImpl;
import ui.input.InputView;
import ui.input.InputViewImpl;
import ui.output.ResultView;
import ui.output.ResultViewImpl;

public class Application {

    public static void main(String[] args) {
    InputView inputView = new InputViewImpl();
    ResultView resultView = new ResultViewImpl();
    BaseballGame baseballGame = new BaseballGameImpl();

    Baseball baseball = new Baseball(inputView, resultView, baseballGame);
    baseball.play();
    }
}
