package OnlinePaymentGateway;

public class PayPalPaymentFactory implements PaymentFactory {
    @Override
    // factory method to create PayPalAdapter
    public PaymentMethod createTransaction() {
        // return adapter for integration with external API
        return new PayPalAdapter("user@paypal");
    }
}