package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();

        List<Car> cars = inputView.readCars();

        int roundCount = inputView.readRoundCount();

        Racing racing = new Racing(cars, roundCount);
        racing.play();

        ResultCalculator resultCalculator = new ResultCalculator();
        List<Car> winners = resultCalculator.getWinners(cars);

        OutputView outputView = new OutputView();
        outputView.printWinners(winners);
    }

}
