package racingcar;

import utils.RandomUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Game {
    private Scanner scanner;
    private int trial;
    private List<Car> cars;

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        String[] carNames = takeInputCars(scanner);
        this.cars = makeCars(carNames);
        try {
            this.trial = takeInputTrial(scanner);
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 시도 횟수는 숫자여야 합니다");
        }

        moveCarsNTimes(this.trial);
        printFinalWinner();
    }

    private void printFinalWinner() {
        int maxPosition = 0;

        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }

        int finalMaxPosition = maxPosition;
        List<String> winners = cars.stream().filter(car -> car.getPosition() == finalMaxPosition)
                .map(Car::getName).collect(Collectors.toList());

        String winnersString = String.join(", ", winners);
        System.out.println();
        System.out.println("최종 우승자 : " + winnersString);
    }

    private void moveCarsNTimes(int times) {
        for (int i = 0; i < times; i++) {
            moveCarsOneTime();
            printCarsPosition();
        }
    }

    private void printCarsPosition() {
        System.out.println();
        System.out.println("실행 결과");
        for (Car car : cars) {
            car.printPosition();
        }
    }

    private void moveCarsOneTime() {
        for (Car car : cars) {
            car.moveForward();
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
