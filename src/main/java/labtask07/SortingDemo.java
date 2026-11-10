package labtask07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Lab Task 4 demo: internal (Comparable) vs external (Comparator) ordering.
 */
public class SortingDemo {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student(103, 3.85));
        students.add(new Student(101, 3.20));
        students.add(new Student(102, 3.50));

        System.out.println("Original order:");
        students.forEach(System.out::println);

        Collections.sort(students); // uses Comparable.compareTo -> rollNo ascending
        System.out.println();
        System.out.println("Sorted by rollNo ascending (Comparable, natural order):");
        students.forEach(System.out::println);

        students.sort(new CgpaComparator()); // external rule -> cgpa descending
        System.out.println();
        System.out.println("Sorted by CGPA descending (CgpaComparator, external order):");
        students.forEach(System.out::println);
    }
}
