package CoffeeShopSimulator.decorators;

import CoffeeShopSimulator.factory.Coffee;

public class VanillaSyrup extends SyrupDecorator {

    public VanillaSyrup(Coffee coffee) {
        // constructor updates price and description
        super(coffee);
        this.price = coffee.getPrice() + addCost();
        this.description = coffee.getDescription() + addingDescription();
    }

    // the additional cost for vanilla syrup
    private int addCost() {
        return 100;
    }

    // the extra description
    private String addingDescription() {
        return " with Vanilla Syrup";
    }

    @Override
    public Coffee makeCoffee() {
        // customizes the making process with Vanilla syrup
        coffee.makeCoffee();
        System.out.println("adding Vanilla syrup");
        return this;
    }

    @Override
    public void pourIntoGlasses() {
        // uses the default pouring behavior
        coffee.pourIntoGlasses();
    }
}