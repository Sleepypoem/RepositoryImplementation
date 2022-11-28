import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Repository<T> implements Countable, Savable<T>, Findable<T> , Sortable<T>{

    protected List<T> list;

    public Repository(List<T> list){
        this.list = list;
    }

    @Override
    public abstract void save(T element);

    public int count(){
        return this.list.size();
    };

    public T find(int index){
        return this.list.get(index);
    };

    public abstract List<? extends T> getAllSortedBy(String field);

    protected abstract boolean validate(T element);

    public void printList(){
        for (T t : list) {
            System.out.println(t);
        }
    }

    public List<T> getList(){
        return Collections.unmodifiableList(list);
    }


}