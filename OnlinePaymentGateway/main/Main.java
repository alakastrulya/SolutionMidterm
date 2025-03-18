package OnlinePaymentGateway.main;

import OnlinePaymentGateway.factory.CreditCardPaymentFactory;
import OnlinePaymentGateway.factory.CryptoPaymentFactory;
import OnlinePaymentGateway.factory.PayPalPaymentFactory;
import OnlinePaymentGateway.factory.PaymentFactory;
import OnlinePaymentGateway.factory.PaymentMethod;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // prompt for user ID
        System.out.println("Welcome to Online Payment System");
        System.out.println("enter your user ID (e.g., username@payment, must end with '@payment'):");
        String userId;
        while (true) {
            userId = scanner.nextLine().trim();
            if (userId.endsWith("@payment")) {
                break;
            } else {
                System.out.println("invalid ID! it must end with '@payment'. try again:");
            }
        }

        // select payment method using factory
        System.out.println("choose payment method (1 - Credit Card, 2 - PayPal, 3 - Crypto):");
        PaymentMethod paymentMethod = null;
        while (paymentMethod == null) {
            String choice = scanner.nextLine().trim();
            PaymentFactory factory = null;
            switch (choice) {
                case "1":
                    factory = new CreditCardPaymentFactory(scanner, userId);
                    break;
                case "2":
                    factory = new PayPalPaymentFactory(userId);
                    break;
                case "3":
                    factory = new CryptoPaymentFactory(userId);
                    break;
                default:
                    System.out.println("invalid choice! enter 1, 2, or 3:");
                    continue;
            }
            paymentMethod = factory.createTransaction();
        }

        // run tests with selected payment method
        PaymentTest test = new PaymentTest();
        test.runTests(paymentMethod, userId);

    }
}