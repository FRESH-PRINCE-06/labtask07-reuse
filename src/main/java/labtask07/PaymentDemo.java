package labtask07;

/**
 * Lab Task 1 demo: the SAME EcommerceCart class is reused with different
 * payment methods, chosen at runtime, without any change to the cart.
 */
public class PaymentDemo {
    public static void main(String[] args) {
        System.out.println("=== Cart #1: injected with CreditCardPayment ===");
        EcommerceCart cart1 = new EcommerceCart(
                new CreditCardPayment("Ayesha Khan", "4111111111111234", 50000));
        cart1.addItem("Keyboard", 4500);
        cart1.addItem("Mouse", 1500);
        System.out.println("Checkout successful? " + cart1.checkout());

        System.out.println();
        System.out.println("=== Cart #2: injected with JazzCashPayment ===");
        EcommerceCart cart2 = new EcommerceCart(new JazzCashPayment("0300-1234567", 3000));
        cart2.addItem("USB Cable", 800);
        cart2.addItem("Phone Case", 1200);
        System.out.println("Checkout successful? " + cart2.checkout());

        System.out.println();
        System.out.println("=== Cart #3: JazzCash with too little balance ===");
        EcommerceCart cart3 = new EcommerceCart(new JazzCashPayment("0311-7654321", 500));
        cart3.addItem("Headphones", 2500);
        System.out.println("Checkout successful? " + cart3.checkout());

        System.out.println();
        System.out.println("EcommerceCart never mentioned CreditCardPayment or JazzCashPayment; "
                + "it only knew the PaymentMethod interface.");
    }
}
