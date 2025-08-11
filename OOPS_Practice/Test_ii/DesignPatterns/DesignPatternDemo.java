package Test_ii.DesignPatterns;

public class DesignPatternDemo {
    public static void main(String[] args) {
        Shape shape1 = ShapeFactory.getShape("CIRCLE");
        shape1.draw();

        Shape shape2 = ShapeFactory.getShape("RECTANGLE");
        shape2.draw();
        Logger logger = Logger.getInstance();
        logger.log("This is a log message from Singleton");

        House house = new House.Builder()
                        .setWalls("Brick Walls")
                        .setRoof("Concrete Roof")
                        .setGarden(true)
                        .build();
        System.out.println(house);

        NewsAgency agency = new NewsAgency();
        NewsChannel channel1 = new NewsChannel("Channel One");
        NewsChannel channel2 = new NewsChannel("Channel Two");
        agency.addObserver(channel1);
        agency.addObserver(channel2);
        agency.setNews("Breaking News: Observer Pattern in action!");

        PaymentContext payment = new PaymentContext(new CreditCardPayment());
        payment.pay(250);

        payment.setPaymentStrategy(new UPIPayment());
        payment.pay(100);
    }
}
