import java.util.ArrayList;

public class ArrayListMultiSet implements MultiSet {
    private ArrayList<Object> list;

    public ArrayListMultiSet() {
        this.list = new ArrayList<>();
    }
    public boolean add(Object item) {
        this.list.add(item);
        return true;
    }

    public void remove(Object item) {
        this.list.remove(item);
    }

    public boolean contains(Object item) {
        return this.list.contains(item);
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public int count(Object item) {
        int count = 0;
        for (Object i: this.list) {
            if (i.equals(item)) {
                count++;
            }
        }
        return count;
    }

    public int size() {
        return this.list.size();
    }
}
