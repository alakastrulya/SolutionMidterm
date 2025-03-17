package OnlinePaymentGateway.main;

import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {
    private List<String> log = new ArrayList<>(); // list to store logs

    // add transaction to log
    public void logTransaction(String paymentType, int amount, boolean success) {
        String status = success ? "Ended" : "failed"; // transaction status
        log.add("Payment type: " + paymentType + ", amount: " + amount + ", status: " + status);
    }

    // print transaction history
    public void printLog() {
        System.out.println("Transaction story:");
        for (String entry : log) {
            System.out.println(entry);
        }
    }
}