package racingcar;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {

    public List<Car> createCars(String input) {

        String[] names = input.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

}
