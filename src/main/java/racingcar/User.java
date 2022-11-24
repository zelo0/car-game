package racingcar;

import java.util.Scanner;

public class User {
    private final Scanner scanner;
    private static Validator validator = new Validator();

    public User(Scanner scanner) {
        this.scanner = scanner;
    }

    public int takeInputTrial() {
        String inputTrial;
        do {
            System.out.println("시도할 회수는 몇회인가요?");
            inputTrial = scanner.nextLine();
        } while (!isValidNumber(inputTrial));

        return Integer.parseInt(inputTrial);
    }

    public String[] takeInputCars() {
        String[] names;
        do {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = scanner.nextLine();
            names = input.split(",");
        } while (!isValidLength(names));

        return names;
    }

    private boolean isValidNumber(String input) {
        try {
            validator.validateNumber(input);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 한다.");
            return false;
        }
        return true;
    }

    private boolean isValidLength(String[] names) {
        try {
            validator.validateEqualOrLessFiveLetters(names);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 차 이름은  5글자 이하여야 한다.");
            return false;
        }
        return true;
    }

}
