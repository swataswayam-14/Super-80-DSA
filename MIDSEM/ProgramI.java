package MIDSEM;

import java.util.Random;
import java.util.Scanner;

public class ProgramI {
    //Explain the process of writing and executing a simple Java program. Write a Java program that takes input from the user and calculates the area of a circle. [5 Marks]
    public static float calcArea(float r) {
        return (float) (3.14*r*r);
    }
    //What are identifiers and variables in Java? Discuss naming conventions and the significance of named constants. Provide an example.
    //Identifiers are names used to identify variables, method, classes etc. ex: int age;
    //variables: variables are containers for storing data values.
    //Naming conventions:
        //  -variable names should start with a lowercase letter and use camelCase
        // -Constants are written in uppercase with words separated by underscores (e.g., MAX_HEIGHT).
    //Significance of Named Constants: Named constants (declared using final) prevent the accidental modification of a variable's value. They make the code easier to read and maintain.
    final double PI = 3.14159;//Named constant
    int age = 25; //variable

    //type conversion
    //1.Impicit (automatic conversion of smaller to larger data type)
    //2.Explicit (manual conversion using type casting)

    int intValue = 100;
    double doubleValue = intValue; //implicit conversion
    int newValue = (int) doubleValue; //explicit conversion
    //Write a program to check leap year using both if-else and switch.
    static boolean checkLeapUsingIfElse(int year) {
        if ((year % 4 == 0 &&  year % 100 != 0) || (year % 400 == 0)) {
            return true;
        }
        return false;
    }
    static boolean checkLeapUsingSwitch(int year) {
        switch (year % 4) {
            case 0:
                if (year % 100 == 0 && year % 400 != 0) {
                    return false;
                } else {
                    return true;
                }
            default:
                return false;
        }
    }
    //Range Checking Program:
    static void checkRange() {
        Scanner sc = new Scanner(System.in);
        boolean done = false;
        do {
            System.out.print("Enter number: ");
            int num = sc.nextInt();
            if (num >= 10 && num <= 50) {
                done = true;
                System.out.println("Number is within range");
            } else {
                done = false;
                System.out.println("Number is not in range, try again!");
            }
        } while (!done);
    }
    //Operator precedence and associativity:
    //Operator Precedence: Determines the order in which operators are evaluated in expressions.
    //Associativity: The direction in which operators of the same precedence level are evaluated.
    int result = 2 + 3 * 4; // 3 * 4 is evaluated first, then added to 2
    static int lotteryNumber() {
        Random random = new Random();
        int lotteryNum = random.nextInt(50) + 1; //1-50
        System.out.println("The lottery number is "+lotteryNum);
        return lotteryNum;
    }
}
