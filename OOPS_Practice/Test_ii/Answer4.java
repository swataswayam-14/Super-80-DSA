package Test_ii;

interface X {
    default void show() {
        System.out.println("X");
    }
}

interface Y {
    default void show() {
        System.out.println("Y");
    }
}

class Z implements X, Y {
    @Override
    public void show() {
        X.super.show(); // calls X's default method or Y.super.show() for Y's method
    }
}

/*
also we can combine : 

@Override
public void show() {
    X.super.show();
    Y.super.show();
}

 */

public class Answer4 {
    public static void main(String[] args) {
        Z  z = new Z();
        z.show();
        SmartPhone phone = new SmartPhone();
        phone.start();
    }
}


// real world analogy 

interface Camera {
    default void start() {
        System.out.println("Starting camera...");
    }
}

interface GPS {
    default void start() {
        System.out.println("Starting gps...");
    }
}

class SmartPhone implements Camera, GPS {
    @Override 
    public void start() {
        Camera.super.start();
        GPS.super.start();
        System.out.println("The smartphone started...");
    }
}
