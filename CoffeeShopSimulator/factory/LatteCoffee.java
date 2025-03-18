package CoffeeShopSimulator.factory;

public class LatteCoffee extends Coffee {
    // constructor calls the parent constructor with specific values
    public LatteCoffee() {
        super("Latte Coffee", 1100, "favourite Latte Coffee");
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
