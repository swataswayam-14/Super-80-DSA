public class OOPS_i {
    //function overloading , overriding

    public int add (int a, int b, int c) {
        return a+b+c;
    }
    public int add(int a, int b) {
        return a+b;
    }
    public float add(float a, float b) {
        return a+b; // not an error
    }

    //compilation
    public static void main(String[] args) {
        Vehicle vehicles[] = { // upcasting
            new Car("brown", 4),
            new MotorCycle("Black", 0)
        };

        for(Vehicle vehicle : vehicles) {
            vehicle.displayInfo();
            if(vehicle instanceof Car) {
                ((Car)vehicle).drift(); // downcasting 
            } else if (vehicle instanceof MotorCycle) {
                ((MotorCycle)vehicle).wheelie();
            }
        }
    }


}

class Vehicle {
    private String color;
    Vehicle(String color) {
        this.color = color;
    }
    void displayInfo() {
        System.out.println("The vehicle is of the color " + color);
    }
}

class Car extends Vehicle {
    private int noOfDoors;
    Car(String color, int noOfDoors) {
        super(color);
        this.noOfDoors = noOfDoors;
    }
    @override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Car has "+this.noOfDoors+" number of doors");
    }

    void drift(){
        System.out.println("Car drifting");
    }
}
class MotorCycle extends Vehicle {
    private int fuelType;
    MotorCycle(String color, int fuelType) {
        super(color);
        this.fuelType = fuelType;
    }
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("MotorCycle has "+this.fuelType+" type of fuel tank");
    }
    void wheelie() {
        System.out.println("Bike is wheeling");
    }
}


abstract class Shape {

    private String color;

    Shape(String color) {
        this.color = color;
    }

    abstract void findArea();
    abstract void findPerimeter();

    void displayColor() {
        System.out.println("The color of the shape is " + this.color);
    }
}

class Rectangle extends Shape {
    private int length;
    private int breadth;

    Rectangle(String color, int length, int breadth) {
        super(color);
        this.length = length;
        this.breadth = breadth;
    }

    @Override
    void findArea() {
        System.out.println("The area of the figure is " + this.length * this.breadth);
    }

    @Override
    void findPerimeter(){
        System.out.println("The preimeter of the figure is " + (this.length + this.breadth) * 2);
    }
}

interface Drawable {
    void draw();

    default void resize() {
        System.out.println("Resizing the figure....");
    }

    static void printInfo() {
        System.out.println("Info bruhhhh");
    }
}


