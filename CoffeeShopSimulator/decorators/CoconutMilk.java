package CoffeeShopSimulator.decorators;

import CoffeeShopSimulator.factory.Coffee;
import CoffeeShopSimulator.decorators.MilkDecorator;

public class CoconutMilk extends MilkDecorator {
    public CoconutMilk(Coffee coffee) {
        // constructor updates price and description via parent
        super(coffee);
        this.price = coffee.getPrice() + addCost();
        this.description = coffee.getDescription() + addingDescription();
    }

    // the additional cost for coconut milk
    private int addCost() {
        return 200;
    }

    // the extra description for coconut milk
    private String addingDescription() {
        return " with Coconut milk";
    }

    @Override
    public Coffee makeCoffee() {
        // customizes the making process with coconut milk
        coffee.makeCoffee();
        System.out.println("adding coconut milk");
        return this;
    }

    @Override
    public void pourIntoGlasses() {
        // uses the default pouring behavior
        coffee.pourIntoGlasses();
    }
}