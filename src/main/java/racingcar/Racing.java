package racingcar;

import java.util.List;

public class Racing {

    private final List<Car> cars;

    private final int roundCount;

    public Racing(List<Car> cars, int roundCount) {
        validateRoundCount(roundCount);
        this.cars = cars;
        this.roundCount = roundCount;
    }

    public void play() {
        for (int i = 0; i < roundCount; i++) {
            playRound();
            printRoundProgress();
        }
    }

    private void playRound() {
        for (Car car : cars) {
            car.moveIfPossible();
        }
    }

    private void printRoundProgress() {
        for (Car car : cars) {
            car.printProgress();
        }
        System.out.println();
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount < 1) {
            throw new IllegalArgumentException("양의 정수를 입력해주세요.");
        }
    }
}
