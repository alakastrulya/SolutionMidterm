package CoffeeShopSimulator.factory;


public class CappuccinoCoffee extends Coffee {
    // constructor calls the coffee constructor with specific values
    public CappuccinoCoffee() {
        super("Cappuccino Coffee", 1000, "tasty Cappuccino Coffee");
    }

    @Override
    public Coffee makeCoffee() {
        // simulates making the coffee and returns this object
        System.out.println("making a Cappuccino Coffee");
        return this; 
    }

    @Override
    public void pourIntoGlasses() {
        // simulates pouring the coffee into glasses
        System.out.println("pouring Cappuccino Coffee into glasses");
    }
}