package CoffeeShopSimulator.factory;

// abstract class for all coffee types with common parameters
public abstract class Coffee {
    protected String name;
    protected int price;
    protected String description;

    // constructor to initialize the coffee parameters
    public Coffee(String name, int price, String description) {
        this.name = name;
        this.price = price;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getDescription() {
        return description;
    }

    // abstract method to "make" the coffee and return the resulting object
    public abstract Coffee makeCoffee();

    // abstract method for pouring, remains void as it’s an action
    public abstract void pourIntoGlasses();
}