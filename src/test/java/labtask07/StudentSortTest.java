package labtask07;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class StudentSortTest {

    private List<Student> sampleStudents() {
        List<Student> list = new ArrayList<>();
        list.add(new Student(103, 3.85));
        list.add(new Student(101, 3.20));
        list.add(new Student(102, 3.50));
        return list;
    }

    @Test
    @DisplayName("Collections.sort uses Comparable: rollNo ascending")
    void testNaturalOrderByRollNo() {
        List<Student> list = sampleStudents();

        Collections.sort(list);

        assertEquals(101, list.get(0).getRollNo());
        assertEquals(102, list.get(1).getRollNo());
        assertEquals(103, list.get(2).getRollNo());
    }

    @Test
    @DisplayName("CgpaComparator sorts by cgpa descending")
    void testExternalOrderByCgpaDescending() {
        List<Student> list = sampleStudents();

        list.sort(new CgpaComparator());

        assertEquals(3.85, list.get(0).getCgpa(), 0.0001);
        assertEquals(3.50, list.get(1).getCgpa(), 0.0001);
        assertEquals(3.20, list.get(2).getCgpa(), 0.0001);
    }

    @Test
    @DisplayName("Sorting with the comparator does not change the natural ordering rule")
    void testNaturalOrderUnaffectedByComparator() {
        List<Student> list = sampleStudents();
        list.sort(new CgpaComparator());

        Collections.sort(list);

        assertEquals(101, list.get(0).getRollNo());
    }
}
