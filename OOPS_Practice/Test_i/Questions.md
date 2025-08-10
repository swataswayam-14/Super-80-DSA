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




3. Method Overloading vs Overriding
Q: Give a Java example where overloading seems to behave like overriding due to autoboxing and widening conversion, but the output surprises most people.
Explain the method resolution process at compile time vs runtime.


4. Polymorphism & Dynamic Method Dispatch
Q: Given:

```java
class A {
    void show() { System.out.println("A"); }
}
class B extends A {
    void show() { System.out.println("B"); }
}
class C extends B {
    void show() { System.out.println("C"); }
}
A obj = new C();
obj.show();

```

What will be printed?
Now modify so that show() is static in all classes — what will change and why?
Explain in detail method hiding vs overriding.


Answer : here it will print C
if its static , then the reference function will print, reference is A , hence it will print : A



5. Abstract Class vs Interface
Q: Explain 5 key differences between abstract classes and interfaces in Java.
Then answer: Why can interfaces now have default and static methods after Java 8, and how does it solve the diamond problem?
Give a short diamond problem code example.