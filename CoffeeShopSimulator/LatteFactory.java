package CoffeeShopSimulator;


public class LatteFactory implements CoffeeFactory{
    // factory method creates latte coffee instance
    @Override
    public Coffee chooseCoffee() {
        return new LatteCoffee();
    }
}
