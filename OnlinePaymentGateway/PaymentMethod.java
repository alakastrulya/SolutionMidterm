package OnlinePaymentGateway;

public interface PaymentMethod {
    int processPayment(int amount);
    boolean transferMoneyToAnotherClient(String toAccountId, int amount);
    boolean paymentOfApartmentUtilities(int amount, String utilityProvider);
}
