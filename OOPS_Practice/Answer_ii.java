public class Answer_ii {
    static class Parent {
        int x = 10;
        Parent() {
            System.out.println("parent constructor called " + x);
        }
    }

    static class Child extends Parent {
        int x = 20;
        Child() {
            System.out.println("child constructor called " + x);
        }
    }
    public static void main(String[] args) {
        Child c = new Child();
    }
}

/*
Memory allocation -> default values
Parent field initialization -> parent constructor
child field intialization -> child constructor
 */

 //the parent constructor runs before the child constructor because java always calls super() implicitly.

//before the parent constructor body executes : all parent variables are initialised to 10 , now Parent() executes and prints 
//then child , control comes to child constructor

//before executing Child() body , all child instance variables are assigned their explicit value that is 20 