1. Object-Oriented Principles

Q: Explain the four main principles of OOP with real-world examples, and then answer:

Why is composition often preferred over inheritance in large-scale systems?
Also, give a short Java code example showing composition solving an issue inheritance couldn’t.


2. Constructor & Initialization Order
Q: In Java, consider the code:

```java
class Parent {
    int x = 10;
    Parent() { System.out.println("Parent constructor: x = " + x); }
}

class Child extends Parent {
    int x = 20;
    Child() { System.out.println("Child constructor: x = " + x); }
}

public class Test {
    public static void main(String[] args) {
        new Child();
    }
}
```

Predict the exact output and explain why that order happens, referencing object construction sequence and variable shadowing.