package Test_ii.Answer2;

//cannot access outer instance variable directly.

class MathUtils {
    static class Calculator {
        public int add(int a, int b) {
            return a+b;
        }
    }
}

public class StaticNestedClassExample {
    public static void main(String[] args) {
        MathUtils.Calculator calc = new MathUtils.Calculator();
        System.out.println(calc.add(2, 7));
    }
}

//real use case : grouping utility/helper classes logically without needing an instance of the outer class