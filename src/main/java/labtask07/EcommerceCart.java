package labtask07;

import java.util.ArrayList;
import java.util.List;

/**
 * Black-box reuse through composition + dependency injection.
 * The cart HAS-A PaymentMethod (given via the constructor). It does not extend
 * any payment class, so it never needs to know which concrete type it is using.
 */
public class EcommerceCart {
    private final PaymentMethod paymentMethod;
    private final List<String> items = new ArrayList<>();
    private double total = 0;

    public EcommerceCart(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void addItem(String name, double price) {
        items.add(name);
        total += price;
    }

    public int getItemCount() {
        return items.size();
    }

    public double getTotal() {
        return total;
    }

    public boolean checkout() {
        if (items.isEmpty()) {
            System.out.println("[Cart] Nothing to check out.");
            return false;
        }
        System.out.println("[Cart] Checking out " + items.size() + " item(s), total Rs. " + total);
        boolean paid = paymentMethod.pay(total);
        if (paid) {
            items.clear();
            total = 0;
        }
        return paid;
    }
}
