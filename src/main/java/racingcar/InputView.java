package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputView {

    public List<Car> readCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        CarFactory carFactory = new CarFactory();
        return carFactory.createCars(input);
    }

    public int readRoundCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("양의 정수를 입력해주세요.");
        }
    }

}
