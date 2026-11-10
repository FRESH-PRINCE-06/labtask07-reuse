package labtask07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class EcommerceCartTest {

    @Test
    @DisplayName("Cart checks out successfully with a CreditCardPayment")
    void testCheckoutWithCreditCard() {
        EcommerceCart cart = new EcommerceCart(new CreditCardPayment("Ayesha Khan", "4111111111111234", 10000));
        cart.addItem("Keyboard", 4500);
        cart.addItem("Mouse", 1500);

        assertTrue(cart.checkout());
        assertEquals(0, cart.getItemCount());
    }

    @Test
    @DisplayName("Cart checks out successfully with a JazzCashPayment")
    void testCheckoutWithJazzCash() {
        EcommerceCart cart = new EcommerceCart(new JazzCashPayment("0300-1234567", 3000));
        cart.addItem("USB Cable", 800);

        assertTrue(cart.checkout());
    }

    @Test
    @DisplayName("Checkout fails and keeps the items when the wallet balance is too low")
    void testCheckoutFailsWhenInsufficientFunds() {
        EcommerceCart cart = new EcommerceCart(new JazzCashPayment("0311-7654321", 500));
        cart.addItem("Headphones", 2500);

        assertFalse(cart.checkout());
        assertEquals(1, cart.getItemCount());
    }

    @Test
    @DisplayName("Checkout of an empty cart returns false")
    void testEmptyCartCheckout() {
        EcommerceCart cart = new EcommerceCart(new JazzCashPayment("0300-1234567", 3000));

        assertFalse(cart.checkout());
    }

    @Test
    @DisplayName("Cart works with ANY PaymentMethod, even a lambda stub it has never seen")
    void testCartWorksWithAnonymousPaymentMethod() {
        PaymentMethod alwaysApproves = amount -> true;
        EcommerceCart cart = new EcommerceCart(alwaysApproves);
        cart.addItem("Book", 999);

        assertTrue(cart.checkout());
    }
}
