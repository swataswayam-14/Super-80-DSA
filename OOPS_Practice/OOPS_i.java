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

        MathOperation addition = (a, b) -> a+b;
        int sum = addition.operate(2, 3);

        MathOperation multiplication = (a,b) -> a*b;
        int product = multiplication.operate(5, 3);

        addition.printResult(sum);
        multiplication.printResult(product);


        Employee.displayCompanyInfo();

        Employee emp1 = new Employee("Billu", 60, 21000000);
        Employee emp2 = new Employee("Harvey", 171, 18000000);

        emp1.displayEmployeeInfo();;
        emp2.displayEmployeeInfo();

    }
    @FunctionalInterface
    interface MathOperation {
        int operate(int a, int b);
        default void printResult(int result) {
            System.out.println(result);
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


//overloading and overriding

class Animal {
    public void makeSound() {
        System.out.println("Animal making a sound");
    }
    public void sleep() {
        System.out.println("The animal is sleeping");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() { //overriding
        System.out.println("Cat is making a sound");
    }

    public void makeSound(String str) { //overloading
        System.out.println("The cat is trying to make a sound " + str);
    }
}



class Employee {
    //static belongs to the class, shared among all the instances , 
    //instance belong to specific object instance 
    // static -> in method area
    // instance -> in heap

    private String name;
    private int employeeId;
    private double salary;

    private static int totalEmployees = 0;
    private static String companyName = "TechCorp";

    static {
        System.out.println("Employee class loaded!");
        companyName = "TechCorp Inc.";
    }

    {
        //instance block (executed before constructor)
        totalEmployees++;
        System.out.println("Creating a new employee");
    }
    public Employee(String name, int employeeId, double salary) {
        this.name = name;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    public void displayEmployeeInfo() {
        System.out.println("name: "+name+ " ID: "+ employeeId+", salary: "+salary);
        System.out.println("Company: "+companyName);
    }

    //static method (can only access static members directly)
    public static void displayCompanyInfo() {
        System.out.println("Company: "+companyName);
        System.out.println("Total Employees: "+totalEmployees);
    }

    public static int getTotalEmployee() {
        return totalEmployees;
    }
    public void companyWithTotal() {
        System.out.println("This employee's salary: " + this.salary);
        System.out.println("Total Employees: "+totalEmployees);
    }
}