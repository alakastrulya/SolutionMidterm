package OnlinePaymentGateway.factory;

public class PayPalPaymentFactory implements PaymentFactory {
    private String userId;

    public PayPalPaymentFactory(String userId) {
        this.userId = userId;
    }

    @Override
    // create PayPalPayment instance with initial balance
    public PaymentMethod createTransaction() {
        return new PayPalPayment(userId, 100000);
    }
}