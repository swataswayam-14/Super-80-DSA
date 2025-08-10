public class Answer_viii {
    public static void main(String[] args) {
        PaymentService cardService = new PaymentService(new CreditCardPayment(10000));
        PaymentService upiService = new PaymentService(new UPIPayment(25000));

        cardService.processPaymentDebit(10);
        upiService.processPaymentCredit(1000);
    }
}

interface Payment{
    void debit(int amount);
    void credit(int amount);
}

class CreditCardPayment implements Payment {
    private int amount;
    CreditCardPayment(int amount) {
        this.amount = amount;
    }
    public void debit(int amount) {
        this.amount = this.amount - amount;
        System.out.println(amount+" debitted from credit card");
    }
    public void credit(int amount) {
        this.amount = this.amount + amount;
        System.out.println(amount+" Creditted to credit card");
    }
}
class UPIPayment  implements Payment {
    private int amount;
    UPIPayment (int amount) {
        this.amount = amount;
    }
    public void debit(int amount) {
        this.amount = this.amount - amount;
        System.out.println(amount+" debitted from UPI");
    }
    public void credit(int amount) {
        this.amount = this.amount + amount;
        System.out.println(amount+" Creditted to UPI");
    }
}

class PaymentService {
    private Payment paymentMethod; 
    public PaymentService(Payment paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
    public void processPaymentDebit(int amount) {
        paymentMethod.debit(amount);
    }
    public void processPaymentCredit(int amount) {
        paymentMethod.credit(amount);
    }
}