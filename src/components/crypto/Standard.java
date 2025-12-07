package components.crypto;

/**
 * Standard interface for mutable types that can be cleared, copied via
 * constructor, and transferred.
 *
 * @param <T>
 *            the type of the implementing class
 */
public interface Standard<T> {

    /**
     * Replaces this with the default value for its type.
     *
     * @updates this
     * @ensures this = default
     */
    void clear();

    /**
     * Creates and returns a new object with the same dynamic type as this,
     * having the default value for its type.
     *
     * @return the new object
     * @ensures newInstance = default
     */
    T newInstance();

    /**
     * Replaces this with the value of {@code source}, and clears
     * {@code source}.
     *
     * @param source
     *            the object to transfer from
     * @updates this, source
     * @requires this != source
     * @ensures this = #source and source = default
     */
    void transferFrom(T source);
}
