package labtask07;

/**
 * Reusable, type-safe container. T is decided by the client, and the
 * compiler enforces it, so no casts and no ClassCastException at runtime.
 */
public class DataBox<T> {
    private final T value;

    public DataBox(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }
}
