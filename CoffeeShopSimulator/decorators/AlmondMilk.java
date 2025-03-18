package CoffeeShopSimulator.decorators;

import CoffeeShopSimulator.factory.Coffee;

public class AlmondMilk extends MilkDecorator {

    public AlmondMilk(Coffee coffee) {
        // constructor updates price and description via parent
        super(coffee);
        this.price = coffee.getPrice() + addCost();
        this.description = coffee.getDescription() + addingDescription();
    }

    // the additional cost for almond milk
    private int addCost() {
        return 400;
    }

    // the extra description for almond milk
    private String addingDescription() {
        return " with Almond milk";
    }

    @Override
    public Coffee makeCoffee() {
        // customizes the making process with almond milk
        coffee.makeCoffee();
        System.out.println("adding almond milk");
        return this;
    }

    @Override
    public void pourIntoGlasses() {
        // uses the default pouring behavior
        coffee.pourIntoGlasses();
    }
}