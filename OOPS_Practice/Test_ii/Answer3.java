package Test_ii;

public class Answer3 {
    public static void main(String[] args) {
        final Car car = new Car("Harrier EV");

        car.model = "BE6E"; // allowed : modifying object's state
        System.out.println(car.model);

        //car = new Car("BMW"); : reassigning reference : Not allowed
        //compilation error
    }
}
/*
 * Final locks the reference, not the object's internal state
 * the object remains mutable unless the class itself is designed final (immutable)
 */

class Car {
    String model;
    public Car(String model) {
        this.model = model;
    }
}