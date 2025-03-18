package OnlinePaymentGateway.factory;

public class CryptoPayment extends PaymentMethod {
    // constructor with balance
    public CryptoPayment(String walletAddress, int initialBalance) {
        super(walletAddress, initialBalance);
    }

    @Override
    // not used, default processPayment handles balance
    protected int processPaymentImpl(int amount) {
        return 0; // balance tracked in parent
    }

    @Override
    // transfer with balance check
    public boolean transferMoneyToAnotherClient(String toAccountId, int amount) {
        if (amount > 0 && amount <= balance && toAccountId != null && !toAccountId.isEmpty()) {
            balance -= amount;
            System.out.println("Crypto: Transferred " + amount + " from " + identifier + " to " + toAccountId);
            return true;
        } else {
            System.out.println("Crypto: Transfer failed");
            return false;
        }
    }

    @Override
    // crypto doesn’t support utilities directly
    public boolean paymentOfApartmentUtilities(int amount, String utilityProvider) {
        System.out.println("Crypto: Utility payments not supported directly. Please transfer to a card first.");
        return false;
    }
}