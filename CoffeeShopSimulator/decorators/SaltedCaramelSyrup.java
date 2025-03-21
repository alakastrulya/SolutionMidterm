package CoffeeShopSimulator.decorators;

import CoffeeShopSimulator.factory.Coffee;

public class SaltedCaramelSyrup extends SyrupDecorator {

    public SaltedCaramelSyrup(Coffee coffee) {
        // constructor updates price and description via parent
        super(coffee);
        this.price = coffee.getPrice() + addCost();
        this.description = coffee.getDescription() + addingDescription();
    }

    // the additional cost for salted caramel syrup
    private int addCost() {
        return 200;
    }

    // the extra description
    private String addingDescription() {
        return " with salted caramel Syrup";
    }

    @Override
    public Coffee makeCoffee() {
        // customizes the making process with salted caramel
        coffee.makeCoffee();
        System.out.println("adding salted caramel syrup");
        return this;
    }

    @Override
    public void pourIntoGlasses() {
        // uses the default pouring behavior
        coffee.pourIntoGlasses();
    }
}