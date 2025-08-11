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

