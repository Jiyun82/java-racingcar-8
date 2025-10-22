package racingcar;

public class Car {

    private final String name;

    private int moveCount;

    public Car(String name) {
        validateName(name);
        this.name = name;
        this.moveCount = 0;
    }

    public String getName() {
        return name;
    }

    public int getMoveCount() {
        return moveCount;
    }

    private void validateName(String name) {
        if(name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

}
