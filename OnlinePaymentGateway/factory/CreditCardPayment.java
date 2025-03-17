package OnlinePaymentGateway.factory;

public class CreditCardPayment implements PaymentMethod {
    private String cardNumber;
    private int balance;

    // constructor takes card number and initial balance
    public CreditCardPayment(String cardNumber, int initialBalance) {
        this.cardNumber = cardNumber;
        this.balance = initialBalance;
    }

    @Override
    // process a regular payment
    public int processPayment(int amount) {
        // check if amount is positive, within balance, and card number is valid
        if (amount > 0 && amount <= balance && cardNumber != null && !cardNumber.isEmpty()) {
            balance -= amount; // reduce balance
            System.out.println("Credit Card processed payment of " + amount + " from card " + cardNumber);
            return amount; // return amount on success
        } else {
            System.out.println("Credit Card Payment failed");
            return 0; // return 0 on failure
        }
    }

    @Override
    // transfer money to another client
    public boolean transferMoneyToAnotherClient(String toAccountId, int amount) {
        // check conditions amount, balance, and valid data
        if (amount > 0 && amount <= balance && toAccountId != null && !toAccountId.isEmpty() &&
                cardNumber != null && !cardNumber.isEmpty()) {
            balance -= amount; // reduce balance
            System.out.println("Credit Card: Transferred " + amount + " from " + cardNumber + " to " + toAccountId);
            return true; // success
        } else {
            System.out.println("Credit Card: Transfer failed due to insufficient funds or invalid account");
            return false; // failure
        }
    }

    @Override
    // pay apartment utilities
    public boolean paymentOfApartmentUtilities(int amount, String utilityProvider) {
        // check conditions with amount, balance, and valid provider
        if (amount > 0 && amount <= balance && utilityProvider != null && !utilityProvider.isEmpty() &&
                cardNumber != null && !cardNumber.isEmpty()) {
            balance -= amount; // reduce balance
            System.out.println("Credit Card paid " + amount + " for " + utilityProvider + " from " + cardNumber);
            return true;
        } else {
            System.out.println("Credit Card Utility payment failed");
            return false;
        }
    }
}