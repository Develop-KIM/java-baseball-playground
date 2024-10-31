package messages;

public enum InputViewMessages {
    USER_INPUT("숫자를 입력해 주세요 : "),
    REPLAY_OR_EXIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    REPLAY("1");

    private final String message;

    InputViewMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
