package CoffeeShopSimulator;

public class ChocolateSyrup extends SyrupDecorator{

    public ChocolateSyrup(Coffee coffee) {
        // constructor passes the coffee to the parent decorator
        super(coffee);
    }

    public int addCost(){
        // additional cost for chocolate syrup
        return 150;
    }

    public String addingDescription() {
        return " with Chocolate Syrup";
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
