package racingcar;

public class Validator {

    private void checkIfFiveMoreLetters(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
