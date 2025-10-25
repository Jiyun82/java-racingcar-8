package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        CarFactory carFactory = new CarFactory();
        List<Car> cars = carFactory.createCars(input);

        System.out.println("시도할 횟수는 몇 회인가요?");
        int roundCount;
        try {
            roundCount = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("양의 정수를 입력해주세요.");
        }

        Racing racing = new Racing(cars, roundCount);
        racing.play();

        ResultCalculator resultCalculator = new ResultCalculator();
        List<Car> winners = resultCalculator.getWinners(cars);
    }

}
