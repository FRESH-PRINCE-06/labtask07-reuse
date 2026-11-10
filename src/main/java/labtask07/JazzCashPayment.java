package labtask07;

/**
 * Another implementation of the PaymentMethod contract: a JazzCash mobile wallet.
 */
public class JazzCashPayment implements PaymentMethod {
    private final String mobileNumber;
    private double walletBalance;

    public JazzCashPayment(String mobileNumber, double walletBalance) {
        this.mobileNumber = mobileNumber;
        this.walletBalance = walletBalance;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= 0 || amount > walletBalance) {
            System.out.println("[JazzCash] FAILED: Rs. " + amount
                    + " (wallet balance: Rs. " + walletBalance + ")");
            return false;
        }
        walletBalance -= amount;
        System.out.println("[JazzCash] Wallet " + mobileNumber + " paid Rs. " + amount
                + " (remaining balance: Rs. " + walletBalance + ")");
        return true;
    }
}
