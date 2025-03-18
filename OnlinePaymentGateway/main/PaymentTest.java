package OnlinePaymentGateway.main;

import OnlinePaymentGateway.factory.CreditCardPayment;
import OnlinePaymentGateway.factory.CreditCardPaymentFactory;
import OnlinePaymentGateway.factory.CryptoPayment;
import OnlinePaymentGateway.factory.PaymentFactory;
import OnlinePaymentGateway.factory.PaymentMethod;

import java.util.Scanner;

public class PaymentTest {
    private TransactionLogger logger;
    private Scanner scanner;

    public PaymentTest() {
        this.logger = new TransactionLogger();
        this.scanner = new Scanner(System.in);
    }

    // main test method
    public void runTests(PaymentMethod payment, String userId) {
        String paymentType = payment.getClass().getSimpleName();
        System.out.println("Payment type: " + paymentType);

        while (true) {
            System.out.println("\n Payment Options ");
            System.out.println("1 - Process Payment\n (This simulates the situation where the user has a PayPal balance (eg 100000) and spends it directly.)");
            System.out.println("2 - Transfer Money");
            System.out.println("3 - Pay Utilities");
            System.out.println("4 - Show Transaction History");
            System.out.println("5 - Exit");
            System.out.print("enter choice (1-5): ");
            String action = scanner.nextLine().trim();

            switch (action) {
                case "1": // process payment
                    handlePayment(payment, paymentType);
                    break;
                case "2": // transfer money
                    handleTransfer(payment, paymentType);
                    break;
                case "3": // pay utilities
                    handleUtilities(payment, paymentType, userId);
                    break;
                case "4": // show history
                    logger.printLog();
                    break;
                case "5": // exit
                    System.out.println("=== Exiting Payment System ===");
                    return;
                default:
                    System.out.println("invalid choice! enter 1-5:");
            }
        }
    }

    // handle payment action
    private void handlePayment(PaymentMethod payment, String paymentType) {
        System.out.print("enter amount to pay: ");
        int amount = Integer.parseInt(scanner.nextLine().trim());
        int result = payment.processPayment(amount);
        processAndLogResult(paymentType, amount, result > 0,
                "Transaction success: " + result, "Transaction failed");
    }

    // handle transfer action
    private void handleTransfer(PaymentMethod payment, String paymentType) {
        System.out.print("enter recipient ID (e.g., user2@payment): ");
        String toAccountId = scanner.nextLine().trim();
        System.out.print("enter amount to transfer: ");
        int amount = Integer.parseInt(scanner.nextLine().trim());
        boolean success = payment.transferMoneyToAnotherClient(toAccountId, amount);
        processAndLogResult(paymentType + " Transfer", amount, success,
                "Transaction success", "Transaction failed");
    }

    // handle utility payment with crypto transfer option
    private void handleUtilities(PaymentMethod payment, String paymentType, String userId) {
        System.out.print("enter amount to pay: ");
        int amount = Integer.parseInt(scanner.nextLine().trim());
        System.out.print("enter utility provider (e.g., Water Company): ");
        String provider = scanner.nextLine().trim();

        if (payment instanceof CryptoPayment) {
            System.out.println("crypto cannot pay utilities directly. transfer to a card?");
            System.out.print("enter 1 to transfer to card, 0 to cancel: ");
            if (scanner.nextLine().trim().equals("1")) {
                PaymentFactory cardFactory = new CreditCardPaymentFactory(scanner, userId);
                CreditCardPayment card = (CreditCardPayment) cardFactory.createTransaction();
                boolean transferSuccess = payment.transferMoneyToAnotherClient(card.getIdentifier(), amount);
                if (transferSuccess) {
                    System.out.println("transferred " + amount + " to " + card.getCardType() + " (" + card.getBankName() + ")");
                    boolean utilitySuccess = card.paymentOfApartmentUtilities(amount, provider);
                    processAndLogResult(paymentType + " Transfer to Card", amount, transferSuccess,
                            "Transfer to card success", "Transfer to card failed");
                    processAndLogResult(paymentType + " Utilities via Card", amount, utilitySuccess,
                            "Pay utilities success", "Pay utilities failed");
                } else {
                    processAndLogResult(paymentType + " Transfer to Card", amount, false,
                            "Transfer to card success", "Transfer to card failed");
                }
            } else {
                System.out.println("utility payment cancelled");
            }
        } else {
            boolean success = payment.paymentOfApartmentUtilities(amount, provider);
            processAndLogResult(paymentType + " Utilities", amount, success,
                    "Pay utilities success", "Pay utilities failed");
        }
    }

    // log and print result
    private void processAndLogResult(String paymentType, int amount, boolean success, String successMessage, String failureMessage) {
        logger.logTransaction(paymentType, amount, success);
        if (success) {
            System.out.println(successMessage);
        } else {
            System.out.println(failureMessage);
        }
    }
}