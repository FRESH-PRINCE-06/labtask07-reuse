package labtask07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class LiskovTest {

    @Test
    @DisplayName("BROKEN design: a Square used as a Rectangle throws on setDimensions(5, 10)")
    void testBrokenSquareViolatesSubstitution() {
        labtask07.broken.Rectangle r = new labtask07.broken.Square();

        assertThrows(IllegalArgumentException.class, () -> r.setDimensions(5, 10));
    }

    @Test
    @DisplayName("BROKEN design: a plain Rectangle accepts setDimensions(5, 10)")
    void testBrokenRectangleAcceptsAnyDimensions() {
        labtask07.broken.Rectangle r = new labtask07.broken.Rectangle();
        r.setDimensions(5, 10);

        assertEquals(50, r.area());
    }

    @Test
    @DisplayName("FIXED design: Rectangle and Square both honour the Shape contract")
    void testFixedShapesHonourContract() {
        labtask07.fixed.Rectangle rect = new labtask07.fixed.Rectangle(1, 1);
        rect.setDimensions(5, 10);
        labtask07.fixed.Square square = new labtask07.fixed.Square(5);

        labtask07.fixed.Shape a = rect;
        labtask07.fixed.Shape b = square;

        assertEquals(50, a.area());
        assertEquals(25, b.area());
    }
}
