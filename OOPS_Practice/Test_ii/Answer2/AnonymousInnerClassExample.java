package Test_ii.Answer2;
//e commerce example

interface Payment{
    void pay(double amount);
}

public class AnonymousInnerClassExample {
    public static void main(String[] args) {
        Payment p = new Payment() {
            @Override
            public void pay(double amount) {
                System.out.println("Paid: $"+amount+" via UPI");
            }
        };
        p.pay(25);
    }
}
//use case : quick callbacks or event handling without creating a separate class