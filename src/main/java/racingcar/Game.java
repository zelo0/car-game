package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    private Scanner scanner;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        String[] carNames = takeInputCars(scanner);
        List<Car> cars = makeCars(carNames);
        try {
            int trial = takeInputTrial(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다");
        }

    }

    private int takeInputTrial(Scanner scanner) {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputTrial = scanner.nextLine();
        try {
            return Integer.parseInt(inputTrial);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> makeCars(String[] carNames) {
        return Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    private String[] takeInputCars(Scanner scanner) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = scanner.nextLine();
        String[] names = input.split(",");
//        System.out.println("names = " + Arrays.toString(names));
        try {
            checkIfFiveMoreLetters(names);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이름은 5글자 이하로 작성해주세요");
        }
        return names;
    }

    private void checkIfFiveMoreLetters(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
