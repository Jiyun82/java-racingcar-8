package racingcar;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingTest {

    @Test
    @DisplayName("각 라운드를 진행한 뒤 진행 상황을 출력한다.")
    void shouldPrintProgressAfterEachRound() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("one"));
        cars.add(new Car("two"));
        cars.add(new Car("three"));

        int roundCount = 3;
        Racing racing = new Racing(cars, roundCount);

        // System.out 가로챔
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        racing.play();

        String output = outContent.toString();

        for (Car car : cars) {
            assertTrue(output.contains(car.getName()));
        }

        // System.out 복원
        System.setOut(System.out);
    }

    @Test
    @DisplayName("roundCount가 0 또는 음수라면 예외를 던진다.")
    void shouldThrowExceptionWhenRoundCountIsZeroOrNegative() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("one"));

        assertThatThrownBy(() -> new Racing(cars, 0))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new Racing(cars, -10))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
