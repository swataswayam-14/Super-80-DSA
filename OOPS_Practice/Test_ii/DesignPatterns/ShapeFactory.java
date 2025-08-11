package Test_ii.DesignPatterns;

interface Shape {
    void draw();
}

class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Drawing a rectangle");
    }
}


public class ShapeFactory {
    public static Shape getShape(String type) {
        if(type.equalsIgnoreCase("circle")) return new Circle();;
        if(type.equalsIgnoreCase("rectangle")) return new Rectangle();
        throw new IllegalArgumentException("Unknown shape type");
    }
}


/* ================================================================
   1. Factory Pattern
   ---------------------------------------------------------------
   What: Provides an interface for creating objects, letting subclasses decide which class to instantiate.
   Real-world analogy: A car factory — you order a "sedan" or "SUV" and the factory produces it.
   Use case: Centralized object creation, avoiding "new" scattered all over the code.
================================================================ */