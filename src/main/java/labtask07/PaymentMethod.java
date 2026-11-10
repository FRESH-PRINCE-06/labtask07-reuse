package labtask07;

/**
 * Contract for any way of paying.
 * The cart depends ONLY on this interface, never on a concrete payment class.
 */
public interface PaymentMethod {
    boolean pay(double amount);
}
