package adapterPattern;
import java.util.Iterator;

public interface DataCollection<T> {
    boolean put(T t);
    Object elemAt(int index);
    int length();
    Iterator createIterator();
}
