public class LinkedListMultiSet implements MultiSet{
    private class Node {
        public Object item;
        public Node next;

        public Node(Object item) {
            this.item = item;
            this.next = null;
        }
    }

    private Node front;
    private int size;

    public LinkedListMultiSet() {
        this.front = null;
        this.size = 0;
    }

    public boolean add(Object item) {
        Node newNode = new Node(item);
        newNode.next = this.front;
        this.front = newNode;
        this.size += 1;
        return true;
    }

    public void remove(Object item) {
        Node cur = this.front;
        Node prev = null;

        while (cur != null) {
            if (cur.item.equals(item)) {
                this.size -= 1;
                if (prev != null) {
                    prev.next = cur.next;
                } else {
                    this.front = cur.next;
                }
                return;
            }
            prev = cur;
            cur = cur.next;
        }
    }

    public boolean contains(Object item) {
        Node cur = this.front;
        while (cur != null) {
            if (cur.item.equals(item)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public boolean isEmpty() {
        return this.front == null;
    }

    public int count(Object item) {
        int numSeen = 0;
        Node cur = this.front;

        while (cur != null) {
            if (cur.item.equals(item)) {
                numSeen += 1;
            }
            cur = cur.next;
        }
        return numSeen;
    }

    public int size() {
        return this.size;
    }
}
