package OnlinePaymentGateway.factory;

public abstract class PaymentMethod {
    protected String identifier; // identifier (card number, wallet, email)
    protected int balance; // balance (-1 if not tracked)

    public PaymentMethod(String identifier, int initialBalance) {
        this.identifier = identifier;
        this.balance = initialBalance;
    }

    // constructor without balance (e.g., for PayPal)
    public PaymentMethod(String identifier) {
        this.identifier = identifier;
        this.balance = -1; // balance not tracked
    }

    // default payment processing with balance check
    public int processPayment(int amount) {
        if (balance >= 0) { // balance tracked
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("processed payment of " + amount + " from " + identifier);
                return amount;
            } else {
                System.out.println("payment failed: insufficient funds or invalid amount");
                return 0;
            }
        } else { // balance not tracked, delegate to subclass
            return processPaymentImpl(amount);
        }
    }

    // abstract method for custom payment logic
    protected abstract int processPaymentImpl(int amount);

    // abstract transfer method
    public abstract boolean transferMoneyToAnotherClient(String toAccountId, int amount);

    // abstract utility payment method
    public abstract boolean paymentOfApartmentUtilities(int amount, String utilityProvider);

    // getter for balance
    public int getBalance() {
        return balance;
    }

    // getter for identifier
    public String getIdentifier() {
        return identifier;
    }
}