package racingcar;

public class CarTestFactory {

    public Car createCar(String name, int moveCount) {
        Car car = new Car(name);
        while(car.getMoveCount() != moveCount) {
            car.moveIfPossible();
        }
        return car;
    }

}
