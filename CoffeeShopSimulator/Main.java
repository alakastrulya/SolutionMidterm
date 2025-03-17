package CoffeeShopSimulator;

import CoffeeShopSimulator.decorators.*;
import CoffeeShopSimulator.factory.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("welcome to the comfort coffee shop!");

        //choosing coffee type
        CoffeeFactory coffeeFactory = chooseCoffeeFactory(in);
        Coffee coffee = coffeeFactory.chooseCoffee();
        System.out.println("you selected: " + coffee.getName());

        //customize with syrup
        coffee = addSyrups(coffee, in);

        //customize with milk
        coffee = addMilk(coffee, in);

        //display final order
        System.out.println("\n--- your final order ---");
        System.out.println("price of the " + coffee.getName() + ": " + coffee.getPrice());
        System.out.println("description: " + coffee.getDescription());
        coffee.makeCoffee();
        coffee.pourIntoGlasses();

        //




    }

    static CoffeeFactory chooseCoffeeFactory(Scanner in) {
        //selecting the factory method
        System.out.println("choose your coffee type (cappuccino/espresso/latte): ");
        String coffeeType = in.nextLine().trim().toLowerCase();

        if (coffeeType.equals("cappuccino")) {
            return new CappuccinoFactory();
        } else if (coffeeType.equals("espresso")) {
            return new EspressoFactory();
        } else if (coffeeType.equals("latte")) {
            return new LatteFactory();
        } else {
            System.out.println("invalid choice, defaulting to latte");
            return new LatteFactory();
        }
    }


    static Coffee addSyrups(Coffee coffee, Scanner in) {
        while (true) {
            System.out.println("\nadd a syrup? (chocolate/vanilla/saltedcaramel/none): ");
            String syrup = in.nextLine().trim().toLowerCase();

            switch (syrup) {
                case "chocolate":
                    coffee = new ChocolateSyrup(coffee);
                    System.out.println("added chocolate syrup");
                    break;
                case "vanilla":
                    coffee = new VanillaSyrup(coffee);
                    System.out.println("added vanilla syrup");
                    break;
                case "saltedcaramel":
                    coffee = new SaltedCaramelSyrup(coffee);
                    System.out.println("added salted caramel syrup");
                    break;
                case "none":
                    System.out.println("no more syrups added");
                    return coffee;
                default:
                    System.out.println("invalid syrup, try again");
            }
            return coffee;
        }
    }

    static Coffee addMilk(Coffee coffee, Scanner in) {
        //user сan add only one milk type
        System.out.println("\ndo you want with special milk? (coconut/almond/cows/none): ");
        String milk = in.nextLine().trim().toLowerCase();

        switch (milk) {
            case "coconut":
                coffee = new CoconutMilk(coffee);
                System.out.println("added coconut milk");
                break;
            case "almond":
                coffee = new AlmondMilk(coffee);
                System.out.println("added almond milk");
                break;
            case "cows":
                coffee = new CowsMilk(coffee);
                System.out.println("added cows milk");
                break;
            case "none":
                System.out.println("no milk added");
                break;
            default:
                System.out.println("invalid milk type, no milk added");
        }
        return coffee;
    }

}