package labtask07;

/**
 * Lab Task 2 demo: DataBox<String> and DataBox<Integer>.
 */
public class DataBoxDemo {
    public static void main(String[] args) {
        DataBox<String> nameBox = new DataBox<>("Ayesha Khan");
        DataBox<Integer> idBox = new DataBox<>(101);

        // No casting needed: the compiler already knows the types.
        String name = nameBox.getValue();
        int id = idBox.getValue();

        System.out.println("Student name (DataBox<String>)  : " + name);
        System.out.println("Student ID   (DataBox<Integer>) : " + id);

        // Compile-time safety proof. Uncomment the line below and the project
        // will NOT compile: "incompatible types: String cannot be converted to Integer".
        // DataBox<Integer> badBox = new DataBox<Integer>("Bilal Ahmed");

        System.out.println();
        System.out.println("Storing a String in the Integer DataBox is rejected at COMPILE time.");
    }
}
