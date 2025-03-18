package OnlinePaymentGateway.factory;

public class PayPalPayment extends PaymentMethod {
    public PayPalPayment(String email, int initialBalance) {
        super(email, initialBalance);
    }

    @Override
    protected int processPaymentImpl(int amount) {
        return 0; // balance tracked in parent
    }

    @Override
    // transfer with balance check
    public boolean transferMoneyToAnotherClient(String toAccountId, int amount) {
        if (amount > 0 && amount <= balance && toAccountId != null && !toAccountId.isEmpty()) {
            balance -= amount;
            System.out.println("PayPal: Transferred " + amount + " from " + identifier + " to " + toAccountId);
            return true;
        } else {
            System.out.println("PayPal: Transfer failed due to insufficient funds or invalid account");
            return false;
        }
    }

    @Override
    // pay utilities with balance check
    public boolean paymentOfApartmentUtilities(int amount, String utilityProvider) {
        if (amount > 0 && amount <= balance && utilityProvider != null && !utilityProvider.isEmpty()) {
            balance -= amount;
            System.out.println("PayPal: Paid " + amount + " for " + utilityProvider + " from " + identifier);
            return true;
        } else {
            System.out.println("PayPal: Utility payment failed");
            return false;
        }
    }
}