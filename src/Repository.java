
import java.util.List;

public abstract class Repository<T> implements Countable, Savable<T>, Findable<T>, Sortable<T> {

    @Override
    public abstract void save(T element);

    public abstract int count();

    public abstract T find(int index);

    public abstract List<? extends T> getAllSortedBy(String field);

    protected abstract boolean validate(T element);

    public abstract void printList();

}