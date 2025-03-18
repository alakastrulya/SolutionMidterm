package CoffeeShopSimulator.decorators;

import CoffeeShopSimulator.factory.Coffee;

public class WhippedCream extends SyrupDecorator {
    public WhippedCream(Coffee coffee) {
        // constructor updates price and description
        super(coffee);
        this.price = coffee.getPrice() + addCost();
        this.description = coffee.getDescription() + addingDescription();
    }

    // the additional cost for whipped cream
    private int addCost() {
        return 200;
    }

    // the extra description
    private String addingDescription() {
        return " with Whipped Cream";
    }

    @Override
    public Coffee makeCoffee() {
        // customizes the making process
        coffee.makeCoffee();
        System.out.println("adding whipped cream");
        return this;
    }

    @Override
    public void pourIntoGlasses() {
        // uses the default pouring behavior
        coffee.pourIntoGlasses();
    }
}