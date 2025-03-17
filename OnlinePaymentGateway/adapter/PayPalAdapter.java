package OnlinePaymentGateway.adapter;

import OnlinePaymentGateway.factory.PaymentMethod;

public class PayPalAdapter implements PaymentMethod {
    private PayPalAPI payPalAPI; // reference to API
    private String accountId; // paypal account ID

    // constructor takes account ID and creates API instance
    public PayPalAdapter(String accountId) {
        this.payPalAPI = new PayPalAPI();
        this.accountId = accountId;
    }

    @Override
    // process payment via adapter
    public int processPayment(int amount) {
        // adapter calls external API method
        boolean success = payPalAPI.executeTransaction(accountId, amount);
        if (success) {
            return amount; // success
        } else {
            System.out.println("PayPal Adapter Payment failed");
            return 0; // failure
        }
    }

    @Override
    // transfer via adapter
    public boolean transferMoneyToAnotherClient(String toAccountId, int amount) {
        // adapter delegates to external API
        return payPalAPI.transferMoneyToAnotherClient(accountId, toAccountId, amount);
    }

    @Override
    // pay utilities via adapter
    public boolean paymentOfApartmentUtilities(int amount, String utilityProvider) {
        // adapter delegates to external API
        return payPalAPI.paymentOfApartmentUtilities(accountId, amount, utilityProvider);
    }
}
