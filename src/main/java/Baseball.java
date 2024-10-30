import java.util.*;

public class Baseball {

    private static final int MAX_NUMBER = 9;
    private static final int MIN_NUMBER = 1;
    private static final int NUMBER_COUNT = 3;

    public List<Integer> baseball() {
        Random random = new Random();
        Set<Integer> computer = new HashSet<>();

        while (computer.size() < NUMBER_COUNT) {
            computer.add(random.nextInt(MAX_NUMBER) + MIN_NUMBER);
        }

        return new ArrayList<>(computer);
    }
}
