package OnlinePaymentGateway;

public class CreditCardPaymentFactory implements PaymentFactory {
    @Override
    // factory method to create CreditCardPayment instance
    public PaymentMethod createTransaction() {
        // return new instance with card number and initial balance
        return new CreditCardPayment("1111-1111-1111-1111", 10000000);
    }
}