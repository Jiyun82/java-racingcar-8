package racingcar;

import java.util.ArrayList;
import java.util.List;

public class ResultCalculator {

    public List<Car> getWinners(List<Car> cars) {
        int max = -1;
        List<Car> winners = new ArrayList<>();

        for (Car car : cars) {
            if(car.getMoveCount() == max) {
                winners.add(car);
            } else if (car.getMoveCount() > max) {
                max = car.getMoveCount();
                winners.clear();
                winners.add(car);
            }
        }

        return winners;
    }

}
