package OnlinePaymentGateway.factory;

public class CreditCardPayment extends PaymentMethod {
    private String cardType; // "Visa" or "MasterCard"
    private String bankName; // "Sberbank" or "Kaspi"

    // constructor with card type and bank
    public CreditCardPayment(String identifier, int initialBalance, String cardType, String bankName) {
        super(identifier, initialBalance);
        this.cardType = cardType;
        this.bankName = bankName;
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
            System.out.println(cardType + " (" + bankName + "): Transferred " + amount + " from " + identifier + " to " + toAccountId);
            return true;
        } else {
            System.out.println(cardType + " (" + bankName + "): Transfer failed due to insufficient funds or invalid account");
            return false;
        }
    }

    @Override
    // pay utilities with balance check
    public boolean paymentOfApartmentUtilities(int amount, String utilityProvider) {
        if (amount > 0 && amount <= balance && utilityProvider != null && !utilityProvider.isEmpty()) {
            balance -= amount;
            System.out.println(cardType + " (" + bankName + "): Paid " + amount + " for " + utilityProvider + " from " + identifier);
            return true;
        } else {
            System.out.println(cardType + " (" + bankName + "): Utility payment failed");
            return false;
        }
    }

    // getter for card type
    public String getCardType() {
        return cardType;
    }

    // getter for bank name
    public String getBankName() {
        return bankName;
    }
}