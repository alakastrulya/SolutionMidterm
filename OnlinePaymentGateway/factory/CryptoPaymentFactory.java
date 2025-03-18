package OnlinePaymentGateway.factory;

public class CryptoPaymentFactory implements PaymentFactory {
    private String userId;

    public CryptoPaymentFactory(String userId) {
        this.userId = userId;
    }

    @Override
    public PaymentMethod createTransaction() {
        return new CryptoPayment(userId + "_wallet", 100000);
    }
}