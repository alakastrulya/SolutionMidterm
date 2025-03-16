package OnlinePaymentGateway;

public class PaymentTest {
    private TransactionLogger logger;

    public PaymentTest() {
        this.logger = new TransactionLogger();
    }

    public void runTests(PaymentMethod payment, int amount) {
        String paymentType = payment.getClass().getSimpleName();
        System.out.println("Payment type: " + paymentType);

        int processedAmount = payment.processPayment(amount);
        processAndLogResult(paymentType, amount, processedAmount > 0,
                "Transaction success: " + processedAmount, "Transaction failed");

        int transferAmount = amount / 2;
        boolean transferSuccess = payment.transferMoneyToAnotherClient("client456@paypal.com", transferAmount);
        processAndLogResult(paymentType + " Transfer", transferAmount, transferSuccess,
                "Transaction success", "Transaction failed");

        int utilityAmount = amount * 3 / 4;
        boolean utilitySuccess = payment.paymentOfApartmentUtilities(utilityAmount, "Water Company");
        processAndLogResult(paymentType + " Utilities", utilityAmount, utilitySuccess,
                "Pay utilities success", "Pay utilities failed");

        logger.printLog();
    }

    private void processAndLogResult(String paymentType, int amount, boolean success,String successMessage, String failureMessage) {
        logger.logTransaction(paymentType, amount, success);
        if (success) {
            System.out.println(successMessage);
        } else {
            System.out.println(failureMessage);
        }
    }
}