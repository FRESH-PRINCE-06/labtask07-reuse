# Lab Task 07 – Construction for Reuse: Interfaces, Generics, and Contracts

**Course:** Software Construction & Development (SE-206), 5th Semester Software Engineering
**Institute:** University of Engineering and Technology, Abbottabad Campus
**Instructor:** Engr. Rizwan Shah
**Student:** M. Mubashir Hassan (24ABSWE0009)

## Objective
Design components for black-box reuse, generic type safety, and contract integrity.

## Tasks

| Task | Topic | Files (`src/main/java/labtask07/`) | Run |
|---|---|---|---|
| 1 | Black-box reuse: composition + dependency injection | `PaymentMethod`, `CreditCardPayment`, `JazzCashPayment`, `EcommerceCart`, `PaymentDemo` | `PaymentDemo` |
| 2 | Type-safe generic container | `DataBox<T>`, `DataBoxDemo` | `DataBoxDemo` |
| 3 | Liskov Substitution Principle | `broken/` (`Rectangle`, `Square`, `BrokenClientDemo`) and `fixed/` (`Shape`, `Rectangle`, `Square`, `FixedClientDemo`) | `broken.BrokenClientDemo`, `fixed.FixedClientDemo` |
| 4 (Homework) | `Comparable` vs `Comparator` | `Student`, `CgpaComparator`, `SortingDemo` | `SortingDemo` |

### Task descriptions
1. **Black-box reuse** – `EcommerceCart` receives a `PaymentMethod` through its constructor (composition), so it can process payments with a credit card or a JazzCash wallet without knowing which one it has.
2. **Generics** – `DataBox<T>` holds a value of type `T`. `DataBox<String>` stores a student name and `DataBox<Integer>` a student ID. Putting a `String` into a `DataBox<Integer>` fails at compile time (see the commented line in `DataBoxDemo`).
3. **LSP** – In `broken/`, `Square extends Rectangle` and throws when `w != h`, so `setDimensions(5, 10)` crashes. In `fixed/`, the inheritance is removed and both classes implement the `Shape` interface.
4. **Ordering** – `Student` implements `Comparable<Student>` (rollNo ascending); `CgpaComparator` sorts by CGPA descending.

## How to run
Requires JDK 17 or newer.

**NetBeans (Maven project):** create a Maven project named `LabTask07` (package `labtask07`), copy `src/` into it, add the same JUnit 5 dependency used in Lab 06, then right-click a `*Demo` class → *Run File*. Run all tests with *Test Project* (Alt+F6).

**Command line (without Maven):**
```bash
mkdir out
javac -d out $(find src/main -name "*.java")
java -cp out labtask07.PaymentDemo
java -cp out labtask07.DataBoxDemo
java -cp out labtask07.broken.BrokenClientDemo
java -cp out labtask07.fixed.FixedClientDemo
java -cp out labtask07.SortingDemo
```

## Tests
JUnit 5 tests are in `src/test/java/labtask07/`: `EcommerceCartTest` (5), `DataBoxTest` (2), `LiskovTest` (3), `StudentSortTest` (3), 13 in total.
