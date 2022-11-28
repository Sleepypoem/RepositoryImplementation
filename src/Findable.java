public interface Findable<T> {

    /**
     * Returns the element at the specified position in the class that implements this interface.
     * @param index The index of the element we want to get.
     * @return The element with the given index.
     */
    T find(int index);
}
