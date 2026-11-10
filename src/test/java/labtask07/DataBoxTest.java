package labtask07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

public class DataBoxTest {

    @Test
    @DisplayName("DataBox<String> returns the stored student name")
    void testStringBox() {
        DataBox<String> box = new DataBox<>("Ayesha Khan");

        assertEquals("Ayesha Khan", box.getValue());
    }

    @Test
    @DisplayName("DataBox<Integer> returns the stored student ID without casting")
    void testIntegerBox() {
        DataBox<Integer> box = new DataBox<>(101);

        int id = box.getValue();

        assertEquals(101, id);
    }
}
