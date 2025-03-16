package OnlinePaymentGateway;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // prompt user for payment type
        System.out.println("Enter payment type (creditcard, paypal, crypto): ");
        String paymentType = scanner.nextLine();

        //factory method to create payment object
        PaymentFactory paymentFactory = choosePaymentFactory(paymentType);
        PaymentMethod payment = paymentFactory.createTransaction();

        // prompt user for amount
        System.out.println("Enter the amount to pay: ");
        int amount = scanner.nextInt();

        // run tests with payment object and amount
        PaymentTest test = new PaymentTest();
        test.runTests(payment, amount);

        //The output
        //Enter payment type (creditcard, paypal, crypto):
        //paypal
        //Enter the amount to pay:
        //10000
        //Payment type: PayPalAdapter
        //PayPal API: Transaction for 10000 for account user@paypal
        //Transaction success: 10000
        //PayPal API: Transaction5000 from user@paypal to client456@paypal.com
        //Transaction success
        //PayPal API: Payment 7500 for services Water Company from user@paypal
        //Pay utilities success
        //Transaction story:
        //Payment type: PayPal, amount: 10000, status: Ended
        //Payment type: PayPal Transfer, amount: 5000, status: Ended
        //Payment type: PayPal Utilities, amount: 7500, status: Ended

    }

    // choose factory based on payment type
    static PaymentFactory choosePaymentFactory(String paymentType) {
        if (paymentType.equalsIgnoreCase("creditcard")) {
            return new CreditCardPaymentFactory(); // factory for credit card
        } else if (paymentType.equalsIgnoreCase("paypal")) {
            return new PayPalPaymentFactory(); // factory for
        } else if (paymentType.equalsIgnoreCase("crypto")) {
            return new CryptoPaymentFactory(); // factory for crypto
        } else {
            throw new IllegalArgumentException("Invalid payment type");
        }
    }
}
