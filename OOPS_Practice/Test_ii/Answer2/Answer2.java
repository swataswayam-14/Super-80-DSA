package Test_ii.Answer2;

abstract class Greeting {
    abstract void sayHello();
}

public class Answer2 {
    public static void main(String[] args) {
        Greeting g = new Greeting() {
            @Override
            void sayHello() {
                System.out.println("Hello from anonymous inner class!");
            }
        };
        g.sayHello();
    }
}

