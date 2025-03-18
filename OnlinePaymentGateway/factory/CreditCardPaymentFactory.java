package OnlinePaymentGateway.factory;

import java.util.Scanner;

public class CreditCardPaymentFactory implements PaymentFactory {
    private Scanner scanner;
    private String userId;

    // constructor to pass scanner and userId
    public CreditCardPaymentFactory(Scanner scanner, String userId) {
        this.scanner = scanner;
        this.userId = userId;
    }

    @Override
    // create credit card with user selection
    public PaymentMethod createTransaction() {
        System.out.println("choose card type (1 - Visa, 2 - MasterCard):");
        String cardChoice = scanner.nextLine().trim();
        String cardType = cardChoice.equals("1") ? "Visa" : "MasterCard";
        System.out.println("choose bank (1 - Sberbank, 2 - Kaspi):");
        String bankChoice = scanner.nextLine().trim();
        String bankName = bankChoice.equals("1") ? "Sberbank" : "Kaspi";
        return new CreditCardPayment(userId + "_" + cardType, 100000, cardType, bankName);
    }
}