1. Static vs Instance Context

```java
class Test {
    int a = 10;
    static int b = 20;

    public static void main(String[] args) {
        System.out.println(a); // Compilation error? Why?
        Test t = new Test();
        System.out.println(t.b); // Why is this legal but discouraged?
    }
}

```

Explain:

Why can static methods not access instance variables directly?

Why can instance methods access static members without issue?


2. Inner Classes
Q: What are the differences between:

Member inner class

Static nested class

Local inner class

Anonymous inner class

Show a Java example where an anonymous inner class is used to override a method on the fly.

3. Final Keyword Deep Dive
Q: Explain how final behaves differently when applied to:

Variables

Methods

Classes
Then answer:

If a reference variable is declared final, can the object it points to be modified? Give a Java example.


4. Multiple Inheritance & Interfaces

```java
interface X {
    default void show() { System.out.println("X"); }
}
interface Y {
    default void show() { System.out.println("Y"); }
}
class Z implements X, Y {
    // How to resolve?
}
```
How do you resolve this default method conflict? Why does Java not allow multiple inheritance with classes but allows it with interfaces?




5. Covariant Return Types
Q: What are covariant return types in Java?
Show an example where overriding a method changes the return type to a more specific type, and explain why it is legal.