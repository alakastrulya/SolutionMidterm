package CoffeeShopSimulator.decorators;

import CoffeeShopSimulator.factory.Coffee;
import CoffeeShopSimulator.decorators.SyrupDecorator;

public class ChocolateSyrup extends SyrupDecorator {
    public ChocolateSyrup(Coffee coffee) {
        // constructor updates price and description via parent
        super(coffee);
        this.price = coffee.getPrice() + addCost();
        this.description = coffee.getDescription() + addingDescription();
    }

    // the additional cost for chocolate syrup
    private int addCost() {
        return 150;
    }

    // the extra description
    private String addingDescription() {
        return " with Chocolate Syrup";
    }

    @Override
    public Coffee makeCoffee() {
        // customizes the making process with chocolate syrup
        coffee.makeCoffee();
        System.out.println("adding chocolate syrup");
        return this;
    }

    @Override
    public void pourIntoGlasses() {
        // uses the default pouring behavior from the wrapped coffee
        coffee.pourIntoGlasses();
    }
}