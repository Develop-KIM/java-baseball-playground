package messages;

public enum ResultViewMessages {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    GAME_OVER_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    SPACE(" ");

    private final String message;

    ResultViewMessages(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}