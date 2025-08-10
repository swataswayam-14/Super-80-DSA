package Test_i;

public class Answer_i {
    //Four main principles of OOP

    /*
    1. Encapsulation : 
        -> defination : wrapping data(fields) and methods that operate on that data into a single unit (class) and restricting direct access to some of the object's component

        -> real world analogy : the balance , accountNumber is private and can be get / set via getter and setter methods
     */

}

class BankAccount{
    private int balance;
    private int accountNumber;

    BankAccount(int balance, int accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public int getBalance() {
        return this.balance;
    }
    public void setBalance(int amount) {
        this.balance = this.balance + amount;
    }
    public int getAccountNumber() {
        return this.accountNumber;
    }
}

/*

Abstraction : 

    1. Hiding complex internal implementation and showing only the essential features through interfaces or abstract classes.
    2. A car's driver only uses the steering, pedals and gear , they don't need to know the internal working of the engine

 */

interface Vehicle {
    void drive();
    void applyBreak();
}

class Car implements Vehicle {
    public void drive() {
        System.out.println("The car is driving");
    }
    public void applyBreak() {
        System.out.println("The car applied break");
    }
}


/*
    Inheritance
        -> where a new class acquires properties and behaviours of an existing class
        -> A dog class inherits Animal class
 */

 /*
  Polymorphism : 
    Method overriding (run time polymorphism) and Method overloading (compile time polymorphism)
  */


//Reason why composition is often prefered over inheritance in large-scale systems

/*
    -> Composition provides loose coupling - classes can be changed easily without affecting others
    -> Inheritance tighly couples classes (parent and child) , changes in the parent ripple into all its children
    -> composition supports run time flexibility , we can change behaviour by swapping out components
    -> multiple behaviour can be combined without the diamond problem that comes with multiple inheritance
    Testing is easier - dependencies can be mocked or replaced
 */


// Composition solving an issue that inheritance couldn't
/*
FlyingCar can both fly and drive , if FlyingCar extends Car, it inherits unnecessary behaviors

 */


class Engine {
    void start() {
        System.out.println("Engine starting...");
    }
}

class Wings {
    void fly() {
        System.out.println("Flying in the air...");
    }
}

class FlyingCar {
    private Engine engine;
    private Wings wings;

    FlyingCar(Engine engine, Wings wings) {
        this.engine = engine;
        this.wings = wings;
    }
    void drive() {
        engine.start();
        System.out.println("Driving on road");
    }
    void fly() {
        wings.fly();
    }
    public static void main(String[] args) {
        FlyingCar fy = new FlyingCar(new Engine(), new Wings());
        fy.drive();
        fy.fly();
    }
}