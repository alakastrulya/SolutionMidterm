package CoffeeShopSimulator;

public class SaltedCaramelSyrup extends SyrupDecorator{

    public SaltedCaramelSyrup(Coffee coffee) {
        super(coffee);
    }

    public int addCost(){
        // additional cost for salted caramel syrup
        return 200;
    }

    public String addingDescription() {
        return " with Salted caramel Syrup";
    }

    @Override
    public int getPrice() {
        // additional cost for salted caramel
        return super.getPrice() + addCost();
    }

    @Override
    public String getDescription() {
        // decorator pattern appends salted caramel
        return super.getDescription() + addingDescription();
    }
}
