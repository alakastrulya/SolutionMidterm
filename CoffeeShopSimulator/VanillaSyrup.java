package CoffeeShopSimulator;

public class VanillaSyrup extends SyrupDecorator{

    public VanillaSyrup(Coffee coffee) {
        super(coffee);
    }

    public int addCost(){
        // the cost of vanilla syrup
        return 100;
    }

    public String addingDescription() {
        return " with Vanilla Syrup";
    }

    @Override
    public int getPrice() {
        // decorator pattern adds vanilla cost to base price
        return super.getPrice() + addCost();
    }

    @Override
    public String getDescription() {
        // decorator extends description 
        return super.getDescription() + addingDescription();
    }
}
