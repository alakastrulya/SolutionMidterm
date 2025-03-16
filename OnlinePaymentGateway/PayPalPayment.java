package OnlinePaymentGateway;

public class PayPalPayment implements PaymentMethod {
    private String email; // paypal account email
    private int balance; // balance in paypal account

    // constructor takes email and initial balance
    public PayPalPayment(String email, int initialBalance) {
        this.email = email;
        this.balance = initialBalance;
    }

    @Override
    // process a regular payment
    public int processPayment(int amount) {
        // check if amount is positive, within balance, and email is valid
        if (amount > 0 && amount <= balance && email != null && !email.isEmpty()) {
            balance -= amount; // reduce balance
            System.out.println("PayPal: Processed payment of " + amount + " from " + email);
            return amount; // return amount on success
        } else {
            System.out.println("PayPal: Payment failed due to insufficient funds or invalid email");
            return 0; // return 0 on failure
        }
    }

    @Override
    // transfer money to another client
    public boolean transferMoneyToAnotherClient(String toAccountId, int amount) {
        // check conditions: amount, balance, and valid recipient email
        if (amount > 0 && amount <= balance && toAccountId != null && !toAccountId.isEmpty() &&
                email != null && !email.isEmpty()) {
            balance -= amount; // reduce balance
            System.out.println("PayPal: Transferred " + amount + " from " + email + " to " + toAccountId);
            return true; // success
        } else {
            System.out.println("PayPal: Transfer failed due to insufficient funds or invalid account");
            return false; // failure
        }
    }

    @Override
    // pay apartment utilities
    public boolean paymentOfApartmentUtilities(int amount, String utilityProvider) {
        // check conditions: amount, balance, and valid provider
        if (amount > 0 && amount <= balance && utilityProvider != null && !utilityProvider.isEmpty() &&
                email != null && !email.isEmpty()) {
            balance -= amount; // reduce balance
            System.out.println("PayPal: Paid " + amount + " for " + utilityProvider + " from " + email);
            return true; // success
        } else {
            System.out.println("PayPal: Utility payment failed due to insufficient funds or invalid provider");
            return false; // failure
        }
    }
}