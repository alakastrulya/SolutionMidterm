package CoffeeShopSimulator.decorators;

import CoffeeShopSimulator.factory.Coffee;

public class CowsMilk extends MilkDecorator {
    public CowsMilk(Coffee coffee) {
        // constructor updates price and description
        super(coffee);
        this.price = coffee.getPrice() + addCost();
        this.description = coffee.getDescription() + addingDescription();
    }

    // the basic cost for cow's milk
    private int addCost() {
        return 0;
    }

    // the extra description for  cow's milk
    private String addingDescription() {
        return " with Coconut milk";
    }

    @Override
    public Coffee makeCoffee() {
        // customizes the making process with cow's milk
        coffee.makeCoffee();
        System.out.println("adding cow's milk");
        return this;
    }

    @Override
    public void pourIntoGlasses() {
        // uses the default pouring behavior
        coffee.pourIntoGlasses();
    }
}