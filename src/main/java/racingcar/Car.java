package racingcar;

import utils.RandomUtils;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    // 추가 기능 구현
    public void moveForward() {
        int randomN = RandomUtils.nextInt(0, 9);
        if (randomN >= 4) {
            this.position += randomN;
        }
    }

    public void printPosition() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public int getPosition() {
        return position;
    }

    public String  getName() {
        return name;
    }
}
