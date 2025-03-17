package CoffeeShopSimulator.decorators;

import CoffeeShopSimulator.factory.Coffee;

public class CowsMilk extends MilkDecorator {
    public CowsMilk(Coffee coffee) {
        super(coffee);
    }
    public int addCost(){
        // additional cost for milk
        return 50;
    }

    public String addingDescription() {
        return " with Cows milk";
    }

    @Override
    public int getPrice() {
        // decorator pattern adds extra cost to the coffee price
        return super.getPrice() + addCost();
    }

    @Override
    public String getDescription() {
        // decorator pattern extends the description dynamically
        return super.getDescription() + addingDescription();
    }
}
