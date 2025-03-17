package CoffeeShopSimulator.factory;

// factory method pattern creates a cappuccino coffee
public class CappuccinoFactory implements CoffeeFactory {
    @Override
    public Coffee chooseCoffee() {
        return new CappuccinoCoffee();
    }
}
