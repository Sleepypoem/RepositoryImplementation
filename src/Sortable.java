import java.util.List;

public interface Sortable <T>{
    /**
     * Sorts a list by the specified field.
     * @param field The field on which the order of the list should be based.
     * @return The sorted list if field is valid, returns just the list otherwise.
     */
    public List<? extends T> getAllSortedBy(String field);
}
