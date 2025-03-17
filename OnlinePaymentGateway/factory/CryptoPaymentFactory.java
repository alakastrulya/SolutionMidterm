package OnlinePaymentGateway.factory;

public class CryptoPaymentFactory implements PaymentFactory {
    @Override
    // factory method to create CryptoPayment instance
    public PaymentMethod createTransaction() {
        // return new instance with wallet address
        return new CryptoPayment("1111___");
    }
}