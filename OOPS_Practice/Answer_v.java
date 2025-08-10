public class Answer_v {
    public static void main(String[] args) {
        C c = new C();
        c.greet();
    }
    
}



interface A {
    default void greet() {
        System.out.println("Hello from A");
    }
}

interface B {
    default void greet() {
        System.out.println("Hello from B");
    }
}

class C implements A, B {
    @Override
    public void greet() {
        A.super.greet(); // explicitly call one 
        System.out.println("Hello from C");
    }
}





/*
Interface now have default and static methods because : 

-> problem before java 8 : if a new method was added to an existing interface, all implementing classes had to implement it - breaking backward compatibility

solution with default methods : 
Interfaces can now provide a default implementation for new methods, so existing implementing class don't break

static methods in interfaces: 
- allow utility/helper methods tied to the interface without requiring an implementing class
 */



//abstract class : partial implementation + shared state
// interfaces : defining contracts without shared state , optional implementation using default methods

//java avoids the diamond problem by forcing the implementing class to choose how to handle conflicting default methods