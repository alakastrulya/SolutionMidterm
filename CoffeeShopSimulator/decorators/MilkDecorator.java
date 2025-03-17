package CoffeeShopSimulator.decorators;

import CoffeeShopSimulator.factory.Coffee;

public class MilkDecorator implements Coffee {
    Coffee coffee;

    public MilkDecorator(Coffee coffee) {
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
        coffee.makeCoffee();
    }

    @Override
    public void pourIntoGlasses() {
        coffee.pourIntoGlasses();
    }
}
