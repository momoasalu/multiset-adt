public class TreeMultiSet implements MultiSet {
    private Tree tree;

    public TreeMultiSet() {
        this.tree = new Tree();
    }

    public boolean add(Object item) {
        this.tree.insert(item);
        return true;
    }

    public void remove(Object item) {
        this.tree.deleteItem(item);
    }

    public boolean contains(Object item) {
        return this.tree.contains(item);
    }

    public boolean isEmpty() {
        return this.tree.isEmpty();
    }

    public int count(Object item) {
        return this.tree.count(item);
    }

    public int size() {
        return this.tree.length();
    }
}
