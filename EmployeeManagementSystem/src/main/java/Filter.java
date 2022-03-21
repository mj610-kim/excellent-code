import java.util.ArrayList;
import java.util.List;

class Filter<T>  {
    public List<T> filter(List<T> items, Comparable<T> comparable) {
        List<T> result = new ArrayList<T>();
        for (T item : items) {
            if (comparable.compareTo(item) == 0) {
                result.add(item);
            }
        }
        return result;
    }
}