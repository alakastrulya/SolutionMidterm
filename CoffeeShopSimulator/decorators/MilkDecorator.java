package CoffeeShopSimulator.decorators;

import CoffeeShopSimulator.factory.Coffee;

public abstract class MilkDecorator extends Coffee {
    protected Coffee coffee;

    // constructor wraps an existing coffee object
    public MilkDecorator(Coffee coffee) {
        super(coffee.getName(), coffee.getPrice(), coffee.getDescription());
        this.coffee = coffee;
    }

    @Override
    public Coffee makeCoffee() {
        // making to the wrapped coffee and returns the decorated object
        coffee.makeCoffee();
        System.out.println("adding milk");
        return this;
    }

    @Override
    public void pourIntoGlasses() {
        coffee.pourIntoGlasses();
    }
}