package ui.input;

import java.util.Scanner;

import static messages.InputViewMessages.REPLAY_OR_EXIT;
import static messages.InputViewMessages.USER_INPUT;


public class InputViewImpl implements InputView {


    private Scanner scanner;

    public InputViewImpl() {
        scanner = new Scanner(System.in);
    }

    public String userInput() {
        System.out.print(USER_INPUT);
        return scanner.nextLine();
    }

    public String askReplay() {
        System.out.println(REPLAY_OR_EXIT);
        return scanner.nextLine();
    }

    public void close() {
        scanner.close();
    }
}
