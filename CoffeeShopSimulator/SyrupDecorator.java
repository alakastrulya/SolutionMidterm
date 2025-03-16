package CoffeeShopSimulator;


public class SyrupDecorator implements Coffee{
    Coffee coffee;

    public SyrupDecorator(Coffee coffee) {
        // stores the coffee to be decorated
    this.coffee = coffee;
}

    @Override
    public String getName() {
        // delegates name to the wrapped coffee
        return coffee.getName();
    }

    @Override
    public int getPrice() {
        //decorator delegates price to coffee
        return coffee.getPrice();
    }

    @Override
    public String getDescription() {
        // decorator delegates description
        return coffee.getDescription();
    }

    @Override
    public void makeCoffee() {
        // delegates coffee making
        coffee.makeCoffee();
    }

    @Override
    public void pourIntoGlasses() {
        // delegates pouring the coffee
        coffee.pourIntoGlasses();
    }
}
