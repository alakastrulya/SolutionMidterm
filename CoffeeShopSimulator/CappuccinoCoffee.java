package CoffeeShopSimulator;

//implementations of the interface coffee
public class CappuccinoCoffee implements Coffee{
    @Override
    public String getName() {
        return "Cappuccino Coffee";
    }

    @Override
    public int getPrice() {
        return 1000;
    }

    @Override
    public String getDescription() {
        return "tasty Cappuccino Coffee";
    }

    @Override
    public void makeCoffee() {
        // simulates making the coffee
        System.out.println("make a Cappuccino Coffee");
    }

    @Override
    public void pourIntoGlasses() {
        // simulates pouring the coffee into glasses
        System.out.println("pour into glasses a Cappuccino Coffee");
    }
}
