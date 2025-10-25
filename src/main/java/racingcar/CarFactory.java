package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class CarFactory {

    public List<Car> createCars(String input) {
        List<String> names = Arrays.stream(input.split(","))
                .map(String::trim)
                .toList();

        HashSet<String> nameSet = new HashSet<>(names);
        if(nameSet.size() < names.size()) {
            throw new IllegalArgumentException("중복된 이름은 사용할 수 없습니다.");
        }

        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            cars.add(new Car(name.trim()));
        }
        return cars;
    }

}
