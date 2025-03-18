package CoffeeShopSimulator;

import CoffeeShopSimulator.factory.CappuccinoFactory;
import CoffeeShopSimulator.factory.EspressoFactory;
import CoffeeShopSimulator.factory.LatteFactory;
import CoffeeShopSimulator.factory.Coffee;
import CoffeeShopSimulator.factory.CoffeeFactory;
import CoffeeShopSimulator.decorators.ChocolateSyrup;
import CoffeeShopSimulator.decorators.VanillaSyrup;
import CoffeeShopSimulator.decorators.SaltedCaramelSyrup;
import CoffeeShopSimulator.decorators.CoconutMilk;
import CoffeeShopSimulator.decorators.AlmondMilk;
import CoffeeShopSimulator.decorators.CowsMilk;
import CoffeeShopSimulator.decorators.WhippedCream;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // welcome message
        System.out.println("welcome to the coffee shop!");

        // choose coffee type with prices
        CoffeeFactory coffeeFactory = chooseCoffeeFactory(scanner);
        Coffee coffee = coffeeFactory.chooseCoffee();
        System.out.println("you selected: " + coffee.getName());

        //choose milk type
        coffee = addMilk(coffee, scanner);

        //choose syrup
        coffee = addSyrup(coffee, scanner);

        //choose whipped cream
        coffee = addWhippedCream(coffee, scanner);

        //make and display final coffee
        System.out.println("\n your order:");
        System.out.println("price of the " + coffee.getName() + ": " + coffee.getPrice() + " tenge");
        System.out.println("description: " + coffee.getDescription());
        Coffee preparedCoffee = coffee.makeCoffee();
        preparedCoffee.pourIntoGlasses();

        scanner.close();
    }

    static CoffeeFactory chooseCoffeeFactory(Scanner scanner) {

        System.out.println("choose your coffee type:");
        System.out.println("1 - cappuccino (1000 tenge)");
        System.out.println("2 - espresso (600 tenge)");
        System.out.println("3 - latte (1100 tenge)");
        System.out.print("enter your choice (1-3): ");
        String input = scanner.nextLine().trim();

        //selecting the right factory method
        switch (input) {
            case "1":
                return new CappuccinoFactory();
            case "2":
                return new EspressoFactory();
            case "3":
                return new LatteFactory();
            default:
                // defaults to latte for invalid input
                System.out.println("invalid choice, defaulting to latte");
                return new LatteFactory();
        }
    }

    static Coffee addMilk(Coffee coffee, Scanner scanner) {
        // choosing milk type
        System.out.println("\nadd milk?");
        System.out.println("1 - coconut (200 tenge)");
        System.out.println("2 - almond (150 tenge)");
        System.out.println("3 - cows (0 tenge)");
        System.out.println("4 - none (0 tenge)");
        System.out.print("enter your choice (1-4): ");
        String milk = scanner.nextLine().trim();

        switch (milk) {
            case "1":
                // decorator pattern
                coffee = new CoconutMilk(coffee);
                System.out.println("added coconut milk");
                break;
            case "2":
                coffee = new AlmondMilk(coffee);
                System.out.println("added almond milk");
                break;
            case "3":
                coffee = new CowsMilk(coffee);
                System.out.println("added cows milk");
                break;
            case "4":
                System.out.println("no milk added");
                break;
            default:
                System.out.println("invalid choice, no milk added");
        }
        return coffee;
    }

    static Coffee addSyrup(Coffee coffee, Scanner scanner) {
        //user can add only one syrup
        System.out.println("\nadd a syrup?");
        System.out.println("1 - chocolate (150 tenge)");
        System.out.println("2 - vanilla (100 tenge)");
        System.out.println("3 - saltedcaramel (200 tenge)");
        System.out.println("4 - none (0 tenge)");
        System.out.print("enter your choice (1-4): ");
        String syrup = scanner.nextLine().trim();

        switch (syrup) {
            case "1":
                coffee = new ChocolateSyrup(coffee);
                System.out.println("added chocolate syrup");
                break;
            case "2":
                coffee = new VanillaSyrup(coffee);
                System.out.println("added vanilla syrup");
                break;
            case "3":
                coffee = new SaltedCaramelSyrup(coffee);
                System.out.println("added salted caramel syrup");
                break;
            case "4":
                // skips syrup addition
                System.out.println("no syrup added");
                break;
            default:
                System.out.println("invalid choice, no syrup added");
        }
        return coffee;
    }

    static Coffee addWhippedCream(Coffee coffee, Scanner scanner) {
        // allows user to add whipped cream
        System.out.println("\nadd whipped cream?");
        System.out.println("1 - yes (200 tenge)");
        System.out.println("2 - no (0 tenge)");
        System.out.print("enter your choice (1-2): ");
        String whippedCream = scanner.nextLine().trim();

        switch (whippedCream) {
            case "1":
                // decorator pattern with whipped cream
                coffee = new WhippedCream(coffee);
                System.out.println("added whipped cream");
                break;
            case "2":
                System.out.println("no whipped cream added");
                break;
            default:
                System.out.println("invalid choice, no whipped cream added");
        }
        return coffee;
    }
}