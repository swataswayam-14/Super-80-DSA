package MIDSEM;

import java.text.SimpleDateFormat;
import java.util.Date;
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
            sc.close();
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


    //Question paper - 2
    static void swap(int a , int b) {
        System.out.println("The first number is "+a+" The second number is "+b);
        a = a+b;
        a = a-b;
        b = a-b;
        System.out.println("The first number is "+a+" The second number is "+b);
    }
    static void calculator() {
        Scanner sc = new Scanner(System.in);
        double num1 = sc.nextDouble();
        double num2 = sc.nextDouble();
        char operator = sc.next().charAt(0);
        double result = 0;
        sc.close();
        switch (operator) {
            case '+':
                result = num1 + num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '%':
                result = num1 % num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            default:
                System.out.println("Operator not permitted");
                break;
        }
        System.out.println("The result of "+operator+" operation is "+result);
    }
    //program to check palindrome
    static boolean checkPalindrome() {
        Scanner sc = new Scanner(System.in);
        String original = sc.nextLine();
        String reversed = new StringBuilder(original).reverse().toString();
        sc.close();
        if (original.equals(reversed)) {
            return true;
        }
        return false;
    }
    static void displayCurrentTime() {
        SimpleDateFormat formatter = new SimpleDateFormat("hh:mm:ss a");
        Date date = new Date();
        System.out.println("Current time: "+formatter.format(date));
    }

    //Question paper - 3
    static void bmiCalculator() {
        System.out.println("Enter height: ");
        Scanner sc = new Scanner(System.in);
        double height = sc.nextDouble();
        System.out.println("Enter weight: ");
        double weight = sc.nextDouble();
        double bmi = weight / (height * height);
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 24.9) {
            System.out.println("Normal");
        } else if (bmi < 29.9) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
        sc.close();
    }
    //program to find the day of the week
    static void dayOfWeek() {
        System.out.println("Enter a number b/w (1-7)");
        Scanner sc = new Scanner(System.in);
        int date = sc.nextInt();
        sc.close();
        switch (date) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
                
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
            default:
                System.out.println("Not a valid number");
                break;
        }
    }
    static void guessingGame() {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int randomNumber = random.nextInt(100) + 1; // 1-100
        boolean found = false;
        do {
            System.out.print("Enter a number between 1 - 100: ");
            int guess = sc.nextInt();
            if (guess == randomNumber) {
                System.out.println("You got the number");
                found = true;
            } else if (guess < randomNumber) {
                System.out.println("Your guess is smaller");
            } else {
                System.out.println("Your guess is larger");
            }

        } while (!found);
        sc.close();
    }
    //word count and character count
    static void countWordsAndCharacter(String sentence){
        String[] words = sentence.split(" ");
        int wordCount = words.length;
        int charCount = sentence.replace(" ", "").length();
        System.out.println("Words: "+wordCount);
        System.out.println("Chars: "+charCount);
    }
}
