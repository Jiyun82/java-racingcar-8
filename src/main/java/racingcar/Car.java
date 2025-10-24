package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private static final int MOVE_THRESHOLD = 4;

    private final String name;

    private int moveCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void moveIfPossible() {
        if (canMove()) {
            move();
        }
    }

    private void move() {
        moveCount++;
    }

    public void printProgress() {
        System.out.print(name + " : ");
        for (int i = 0; i < moveCount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    private boolean canMove() {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        return randomValue >= MOVE_THRESHOLD;
    }

    private void validateName(String name) {
        if (name.length() > 5 || name.length() < 1) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }
    }

}
