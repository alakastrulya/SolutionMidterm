package CoffeeShopSimulator;

public class EspressoCoffee implements Coffee {

    @Override
    public String getName() {
        return "Espresso Coffee";
    }

    @Override
    public int getPrice() {
        // the base price for espresso
        return 500;
    }

    @Override
    public String getDescription() {
        return "Super puper espresso coffee";
    }

    @Override
    public void makeCoffee() {
        // simulates making the coffee
        System.out.println("make a Espresso Coffee");
    }

    @Override
    public void pourIntoGlasses() {
        // simulates pouring the coffee into glasses
        System.out.println("pour into glasses the Espresso coffee ");
    }
}
