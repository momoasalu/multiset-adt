public class LinkedListMultiSet implements MultiSet{
    private class Node {
        public Object item;
        public Node next;

        public Node(Object item) {
            this.item = item;
            this.next = null;
        }
    }
    public boolean add(Object item) {
        return false;
    }

    public void remove(Object item) {

    }

    public boolean contains(Object item) {
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public int count(Object item) {
        return 0;
    }

    public int size() {
        return 0;
    }
}
