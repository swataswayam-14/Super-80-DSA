package Test_ii.DesignPatterns;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid "+amount+" via credit card");
    }
}

class UPIPayment implements PaymentStrategy {
    public void pay(int amount) {
        System.out.println("Paid "+amount+" via upi");
    }
}

public class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void pay(int amount) {
        strategy.pay(amount);
    }
}

/* ================================================================
   5. Strategy Pattern
   ---------------------------------------------------------------
   What: Defines a family of algorithms, encapsulates each one, and makes them interchangeable.
   Real-world analogy: Choosing a travel mode — bus, train, flight — depending on cost/time.
   Use case: Payment methods, sorting algorithms, compression strategies.
================================================================ */