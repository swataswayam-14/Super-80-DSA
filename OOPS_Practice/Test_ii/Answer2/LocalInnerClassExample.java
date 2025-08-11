package Test_ii.Answer2;

class ShippingService {
    public void calculateShipping(double weight) {
        //local inner class
        class ShippingCalculator {
            double ratePerKg = 5.0;
            public double getCost() {
                return weight * ratePerKg;
            }
        }
        ShippingCalculator calc = new ShippingCalculator();
        System.out.println("Shipping cost: $"+calc.getCost());
    }
}



public class LocalInnerClassExample {
    public static void main(String[] args) {
        ShippingService service = new ShippingService();
        service.calculateShipping(3.5);
    }
}
