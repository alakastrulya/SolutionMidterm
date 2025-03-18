package CoffeeShopSimulator.decorators;

import CoffeeShopSimulator.factory.Coffee;


public class SyrupDecorator extends Coffee {
    protected Coffee coffee;

    // constructor wraps an existing coffee object
    public SyrupDecorator(Coffee coffee) {
        super(coffee.getName(), coffee.getPrice(), coffee.getDescription());
        this.coffee = coffee;
    }

    @Override
    public Coffee makeCoffee() {
        // delegates making to the wrapped coffee and returns the decorated object
        coffee.makeCoffee();
        System.out.println("adding syrup");
        return this;
    }

    @Override
    public void pourIntoGlasses() {
        // delegates pouring to the wrapped coffee
        coffee.pourIntoGlasses();
    }
}