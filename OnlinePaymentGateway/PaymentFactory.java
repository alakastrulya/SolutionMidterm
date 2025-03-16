package OnlinePaymentGateway;

// interface for factory method
public interface PaymentFactory {
    PaymentMethod createTransaction(); // create payment object
}