package CoffeeShopSimulator.decorators;


import CoffeeShopSimulator.factory.Coffee;

public class SyrupDecorator implements Coffee {
    Coffee coffee;

    public SyrupDecorator(Coffee coffee) {
        // stores the coffee to be decorated
    this.coffee = coffee;
}

    @Override
    public String getName() {
        return coffee.getName();
    }

    @Override
    public int getPrice() {
        return coffee.getPrice();
    }

    @Override
    public String getDescription() {
        return coffee.getDescription();
    }

    @Override
    public void makeCoffee() {
        // delegates coffee making
        coffee.makeCoffee();
    }

    @Override
    public void pourIntoGlasses() {
        coffee.pourIntoGlasses();
    }
}
