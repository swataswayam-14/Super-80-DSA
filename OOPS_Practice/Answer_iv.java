public class Answer_iv {
    public static void main(String[] args) {
        A obj = new C();
        obj.show();  
        /*
         * Overriding : subclass provides its own version of a non static method with same signature
         * Compilrer decides method existence based on reference type (A in this case)
         * JVM decides method implementation at runtime based on object type (C)
         * Since obj points to C's object , C's show() function runs
         */


        D obj2 = new F();
        obj2.show(); // A

        /*
         * Static method cannot be overriden, they are hidden
         * static method resolution happens at compile time based on the reference type, not the object type
         * Since obj is declared as A, the compiler binds A.show() , object type C is ignored
         */

         //Method hiding -> no polymorphism -> compiler chooses method based on variable type



         //instance method -> implementation depends on object type
         //static method -> implementation depends on reference type
    }
}
class A {
    void show() { System.out.println("A"); }
}
class B extends A {
    void show() { System.out.println("B"); }
}
class C extends B {
    void show() { System.out.println("C"); }
}



class D {
    static void show() { System.out.println("A"); }
}
class E extends D {
    static void show() { System.out.println("B"); }
}
class F extends E {
    static void show() { System.out.println("C"); }
}
