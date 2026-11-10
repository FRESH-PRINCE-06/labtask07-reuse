package labtask07.fixed;

import java.util.ArrayList;
import java.util.List;

/**
 * After the fix: the client depends on Shape, and every Shape honours it.
 */
public class FixedClientDemo {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(1, 1);
        rect.setDimensions(5, 10); // the exact call that crashed Square before
        System.out.println("Rectangle.setDimensions(5, 10) works -> area = " + rect.area());

        Square square = new Square(1);
        square.setSide(5);
        System.out.println("Square.setSide(5) works            -> area = " + square.area());

        List<Shape> shapes = new ArrayList<>();
        shapes.add(rect);
        shapes.add(square);

        System.out.println();
        System.out.println("Client code using only the Shape interface:");
        for (Shape s : shapes) {
            System.out.println("  " + s.getClass().getSimpleName() + " area = " + s.area());
        }
        System.out.println();
        System.out.println("No crash: the inheritance chain is gone, so no precondition is strengthened.");
    }
}
