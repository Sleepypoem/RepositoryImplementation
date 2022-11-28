public interface Savable <E>{

    /**
     * Adds an element to the list in the class that implements this interface.
     * @param element The element to add to the list.
     */
    void save(E element);
}
