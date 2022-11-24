package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarGroup {
    private List<Car> cars;

    public void makeCars(String[] carNames) {
        this.cars = Arrays.stream(carNames).map(Car::new).collect(Collectors.toList());
    }

    public void printFinalWinner() {
        final int finalMaxPosition = getMaxPosition();

        List<String> winners = cars.stream().filter(car -> car.getPosition() == finalMaxPosition)
                .map(Car::getName).collect(Collectors.toList());

        String winnersString = String.join(", ", winners);
        System.out.println();
        System.out.println("최종 우승자 : " + winnersString);
    }

    public void moveCarsNTimes(int times) {
        for (int i = 0; i < times; i++) {
            moveCarsOneTime();
            printCarsPosition();
        }
    }

    private int getMaxPosition() {
        int maxPosition = 0;

        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
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
}
