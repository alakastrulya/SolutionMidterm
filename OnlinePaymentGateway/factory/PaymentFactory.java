package OnlinePaymentGateway.factory;

// interface for factory method
public interface PaymentFactory {
    PaymentMethod createTransaction(); // create payment object
}