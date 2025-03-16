package OnlinePaymentGateway;

public class CryptoPayment implements PaymentMethod {
    private String walletAddress;

    // constructor takes wallet address
    public CryptoPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    // process a regular payment
    public int processPayment(int amount) {
        // check amount and wallet validity
        if (amount > 0 && walletAddress != null && !walletAddress.isEmpty()) {
            System.out.println("Crypto Processed payment of " + amount + " from wallet " + walletAddress);
            return amount; // return amount on success
        } else {
            System.out.println("Crypto Payment failed");
            return 0; // failure
        }
    }

    @Override
    // transfer money to another client
    public boolean transferMoneyToAnotherClient(String toAccountId, int amount) {
        // check amount, recipient address, and own wallet
        if (amount > 0 && toAccountId != null && !toAccountId.isEmpty() &&
                walletAddress != null && !walletAddress.isEmpty()) {
            System.out.println("Crypto Transferred " + amount + " from " + walletAddress + " to " + toAccountId);
            return true; // success
        } else {
            System.out.println("Crypto Transfer failed");
            return false; // failure
        }
    }

    @Override
    // pay apartment utilities
    public boolean paymentOfApartmentUtilities(int amount, String utilityProvider) {
        // check amount, provider, and wallet
        if (amount > 0 && utilityProvider != null && !utilityProvider.isEmpty() &&
                walletAddress != null && !walletAddress.isEmpty()) {
            System.out.println("Crypto paid " + amount + " for " + utilityProvider + " from " + walletAddress);
            return true; // success
        } else {
            System.out.println("Crypto Utility payment failed");
            return false; // failure
        }
    }
}