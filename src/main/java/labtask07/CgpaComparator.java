package labtask07;

import java.util.Comparator;

/**
 * External comparison rule: CGPA in DESCENDING order (highest first).
 * Student itself does not change; a new ordering is plugged in from outside.
 */
public class CgpaComparator implements Comparator<Student> {
    @Override
    public int compare(Student a, Student b) {
        return Double.compare(b.getCgpa(), a.getCgpa());
    }
}
