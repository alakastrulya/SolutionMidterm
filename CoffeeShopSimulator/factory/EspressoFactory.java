package CoffeeShopSimulator.factory;

public class EspressoFactory implements CoffeeFactory {
    @Override
    public Coffee chooseCoffee() {
        // factory method encapsulates espresso coffee
        return new EspressoCoffee();
    }
}
