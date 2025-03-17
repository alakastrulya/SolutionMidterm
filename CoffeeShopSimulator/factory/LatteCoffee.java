package CoffeeShopSimulator.factory;

public class LatteCoffee implements Coffee {
    @Override
    public String getName() {
        return "Latte Coffee";
    }

    @Override
    public int getPrice() {
        // base price for latte
        return 1200;
    }

    @Override
    public String getDescription() {
        return "favourite Latte Coffee";
    }

    @Override
    public void makeCoffee() {
        // simulates making the coffee
        System.out.println("make a Latte Coffee");
    }

    @Override
    public void pourIntoGlasses() {
        // simulates pouring the coffee into glasses
        System.out.println("pour into glasses a Latte Coffee");
    }
}
