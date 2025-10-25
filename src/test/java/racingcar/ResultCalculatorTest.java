package racingcar;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ResultCalculatorTest {

    @Test
    @DisplayName("한 명 또는 여러명의 최종 우승자를 계산한다.")
    void shouldReturnSingleOrMultipleWinners() {
        CarTestFactory carTestFactory = new CarTestFactory();

        List<Car> cars = new ArrayList<>();
        cars.add(carTestFactory.createCar("one", 5));
        cars.add(carTestFactory.createCar("two", 3));
        cars.add(carTestFactory.createCar("three", 7));

        List<Car> cars2 = new ArrayList<>();
        cars2.add(carTestFactory.createCar("four", 3));
        cars2.add(carTestFactory.createCar("five", 3));
        cars2.add(carTestFactory.createCar("six", 3));

        ResultCalculator resultCalculator = new ResultCalculator();
        List<Car> winners = resultCalculator.getWinners(cars);
        List<Car> winners2 = resultCalculator.getWinners(cars2);

        assertThat(winners)
                .extracting(Car::getName)
                .containsExactly("three");

        assertThat(winners2)
                .extracting(Car::getName)
                .containsExactly("four", "five", "six");
    }
}
