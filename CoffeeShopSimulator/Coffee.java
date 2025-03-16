package CoffeeShopSimulator;

// interface for all coffee types
public interface Coffee {
    String getName();
    int getPrice();
    String getDescription();
    void makeCoffee();
    void pourIntoGlasses();
}
