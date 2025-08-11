package Test_ii;

public class Answer_i {
    int a = 10; // instance variable (belongs to object)
    static int b = 20; // static variable (belongs to class)

    public static void main(String[] args) {
        //System.out.println(a); Compilation error
        Answer_i t = new Answer_i();
        System.out.println(t.b); // legal but discouraged
    }
}


//print(a) gives compilation error because : 
/*
main is static , so it runs before any object of the class is created
instance variable a exists only inside an object

A static method does not have a this reference, so it cannot directly access non static fields.


Reason why t.b is legal but discouraged : 

-> b is static, meaning only one copy exists for the entire class
-> even when accessed through instance : t.b : still refers to the class level variable

-> discouraged because it can cause confusion


Answer_i.b is preferred
t.a is the way



->> Static methods cannot access instance variales directly because : 
    + static methods belong to the class , not an object
    + they execute without an instance , hence no this.
    + instance variable require an object to exist.
    + Accessing them without an object would be meaningless.


->> Instance methods can access static members as : 
    + when we call an instance method, an object already exists, so we can 
        -> access its own instance variables
        -> access static members (shared by all objects).
    + static members are always available because they belong to the class and are loaded into memory at class load time.
 */