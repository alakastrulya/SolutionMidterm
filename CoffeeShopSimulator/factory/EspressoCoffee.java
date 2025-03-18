package CoffeeShopSimulator.factory;

public class EspressoCoffee extends Coffee {
    // constructor calls the parent constructor with specific values
    public EspressoCoffee() {
        super("Espresso Coffee", 600, "Lovely Espresso Coffee");
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
