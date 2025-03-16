package CoffeeShopSimulator;

public class Main {
    public static void main(String[] args) {
        CoffeeFactory coffeeFactoryLatte = chooseCoffeeFactory("latte");
        Coffee coffee = new ChocolateSyrup(coffeeFactoryLatte.chooseCoffee());

        System.out.println("Price of the " +coffee.getName()+": ");
        System.out.println(coffee.getPrice());
        coffee.makeCoffee();
        coffee.pourIntoGlasses();
        System.out.println("Description of the coffee");
        System.out.println(coffee.getDescription());

        CoffeeFactory coffeeFactoryCappuccino = chooseCoffeeFactory("cappuccino");
        Coffee coffeeSecond = new VanillaSyrup(coffeeFactoryCappuccino.chooseCoffee());

        System.out.println("Price of the " +coffeeSecond.getName()+": ");
        System.out.println(coffeeSecond.getPrice());
        coffeeSecond.makeCoffee();
        coffeeSecond.pourIntoGlasses();
        System.out.println("Description of the coffee");
        System.out.println(coffeeSecond.getDescription());

        CoffeeFactory coffeeFactoryEspresso = chooseCoffeeFactory("espresso");
        Coffee coffeeThird = new SaltedCaramelSyrup(coffeeFactoryEspresso.chooseCoffee());

        System.out.println("Price of the " +coffeeThird.getName()+": ");
        System.out.println(coffeeThird.getPrice());
        coffeeThird.makeCoffee();
        coffeeThird.pourIntoGlasses();
        System.out.println("Description of the coffee");
        System.out.println(coffeeThird.getDescription());

        // The output of the code:
        //Price of the Latte Coffee:
        //1350
        //make a Latte Coffee
        //pour into glasses a Latte Coffee
        //Description of the coffee
        //favourite Latte Coffee with Chocolate Syrup
        //Price of the Cappuccino Coffee:
        //1100
        //make a Cappuccino Coffee
        //pour into glasses a Cappuccino Coffee
        //Description of the coffee
        //tasty Cappuccino Coffee with Vanilla Syrup
        //Price of the Espresso Coffee:
        //700
        //make a Espresso Coffee
        //pour into glasses the Espresso coffee
        //Description of the coffee
        //Super puper espresso coffee with Salted caramel Syrup
    }
    static CoffeeFactory chooseCoffeeFactory(String coffeeType) {
        if(coffeeType.equalsIgnoreCase("cappuccino")) {
            return new CappuccinoFactory();
        }else if(coffeeType.equalsIgnoreCase("espresso")) {
            return new EspressoFactory();
        }else if(coffeeType.equalsIgnoreCase("latte")) {
            return new LatteFactory();
        }else {
            throw new IllegalArgumentException("Invalid coffee type");
        }
    }
}
