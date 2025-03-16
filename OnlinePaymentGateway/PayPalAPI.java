package OnlinePaymentGateway;

public class PayPalAPI {
    // mock external API for PayPal
    public boolean executeTransaction(String accountId, int amount) {
        if (amount > 0 && accountId != null && !accountId.isEmpty()) {
            System.out.println("PayPal API: Transaction for " + amount + " for account " + accountId);
            return true; // success
        } else {
            System.out.println("PayPal API: Transaction failed");
            return false; // failure
        }
    }

    // transfer money to another client
    public boolean transferMoneyToAnotherClient(String fromAccountId, String toAccountId, int amount) {
        if (amount > 0 && fromAccountId != null && toAccountId != null &&
                !fromAccountId.isEmpty() && !toAccountId.isEmpty()) {
            System.out.println("PayPal API: Transaction" + amount + " from " + fromAccountId + " to " + toAccountId);
            return true; // success
        } else {
            System.out.println("PayPal API: Transaction failed");
            return false; // failure
        }
    }

    // pay utilities
    public boolean paymentOfApartmentUtilities(String accountId, int amount, String utilityProvider) {
        if (amount > 0 && accountId != null && utilityProvider != null && !accountId.isEmpty() && !utilityProvider.isEmpty()) {
            System.out.println("PayPal API: Payment " + amount + " for services " + utilityProvider + " from " + accountId);
            return true; // success
        } else {
            System.out.println("PayPal API: Transaction failed");
            return false; // failure
        }
    }
}