package racingcar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarFactoryTest {

    @Test
    @DisplayName("입력된 문자열을 쉼표로 구분하여 자동차 객체들을 생성한다.")
    void shouldCreateCarsWhenInputIsCommaSeparated() {
        // given
        String input = "pobi,woni, hello";
        CarFactory carFactory = new CarFactory();

        // when
        List<Car> cars = carFactory.createCars(input);

        // then
        assertThat(cars).hasSize(3);
        assertThat(cars)
                .extracting(Car::getName)
                .containsExactly("pobi", "woni", "hello");
    }

    @Test
    @DisplayName("이름이 공백이라면 예외를 던진다.")
    void shouldThrowExceptionWhenNameIsBlank() {
        String input = "pobi,,jun";
        CarFactory carFactory = new CarFactory();

        assertThatThrownBy(() -> carFactory.createCars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("이름이 6자 이상이라면 예외를 던진다.")
    void shouldThrowExceptionWhenNameIsTooLong() {
        String input = "pobi,woni,helloworld";
        CarFactory carFactory = new CarFactory();

        assertThatThrownBy(() -> carFactory.createCars(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
