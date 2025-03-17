package CoffeeShopSimulator.decorators;

import CoffeeShopSimulator.factory.Coffee;

public class CoconutMilk extends MilkDecorator {

    public CoconutMilk(Coffee coffee) {
        super(coffee);
    }
    public int addCost(){
        // additional cost for milk
        return 200;
    }

    public String addingDescription() {
        return " with Coconut milk";
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
