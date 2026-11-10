package labtask07;

/**
 * One implementation of the PaymentMethod contract: a credit card with a limit.
 */
public class CreditCardPayment implements PaymentMethod {
    private final String cardHolder;
    private final String cardNumber;
    private double availableCredit;

    public CreditCardPayment(String cardHolder, String cardNumber, double creditLimit) {
        this.cardHolder = cardHolder;
        this.cardNumber = cardNumber;
        this.availableCredit = creditLimit;
    }

    @Override
    public boolean pay(double amount) {
        if (amount <= 0 || amount > availableCredit) {
            System.out.println("[CreditCard] DECLINED: Rs. " + amount
                    + " (available credit: Rs. " + availableCredit + ")");
            return false;
        }
        availableCredit -= amount;
        System.out.println("[CreditCard] " + cardHolder + " paid Rs. " + amount
                + " using card ending " + last4() + " (remaining credit: Rs. " + availableCredit + ")");
        return true;
    }

    private String last4() {
        return cardNumber.substring(cardNumber.length() - 4);
    }
}
