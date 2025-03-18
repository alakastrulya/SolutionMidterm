package OnlinePaymentGateway.adapter;

import OnlinePaymentGateway.adapter.PayPalAPI;
import OnlinePaymentGateway.factory.PaymentMethod;

public class PayPalAdapter extends PaymentMethod {
    private PayPalAPI payPalAPI; // external API

    // constructor without balance
    public PayPalAdapter(String accountId) {
        super(accountId);
        this.payPalAPI = new PayPalAPI();
    }

    @Override
    // override for API-based payment
    protected int processPaymentImpl(int amount) {
        boolean success = payPalAPI.executeTransaction(identifier, amount);
        if (success) {
            return amount;
        } else {
            System.out.println("PayPal: Payment failed");
            return 0;
        }
    }

    @Override
    // transfer money
    public boolean transferMoneyToAnotherClient(String toAccountId, int amount) {
        return payPalAPI.transferMoneyToAnotherClient(identifier, toAccountId, amount);
    }

    @Override
    public boolean paymentOfApartmentUtilities(int amount, String utilityProvider) {
        return payPalAPI.paymentOfApartmentUtilities(identifier, amount, utilityProvider);
    }
}