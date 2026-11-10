package labtask07.broken;

/**
 * Client code written against the Rectangle contract.
 * It works for a Rectangle but crashes when handed a Square: an LSP violation.
 */
public class BrokenClientDemo {

    // This method is correct for ANY Rectangle, so it must be correct for a Square too.
    static void resizeTo5By10(Rectangle r) {
        r.setDimensions(5, 10);
        System.out.println("  Dimensions set to 5 x 10, area = " + r.area());
    }

    public static void main(String[] args) {
        System.out.println("Passing a real Rectangle:");
        resizeTo5By10(new Rectangle());

        System.out.println();
        System.out.println("Passing a Square (treated as a Rectangle):");
        Rectangle r = new Square();
        try {
            resizeTo5By10(r);
        } catch (IllegalArgumentException e) {
            // Remove this try/catch to see the real uncaught crash.
            System.out.println("  CRASH: " + e);
        }

        System.out.println();
        System.out.println("A Square is NOT substitutable for a Rectangle: "
                + "the subclass strengthened the precondition.");
    }
}
