package racingcar;

import java.util.Scanner;

public class Game {
    private Scanner scanner;
    private CarGroup carGroup = new CarGroup();

    public Game(Scanner scanner) {
        this.scanner = scanner;
    }

    public void start() {
        int trial;

        User user = new User(scanner);
        String[] carNames = user.takeInputCars();
        carGroup.makeCars(carNames);
        trial = user.takeInputTrial();
        carGroup.moveCarsNTimes(trial);
        carGroup.printFinalWinner();
    }

}
