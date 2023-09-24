import java.util.ArrayList;

public class Tree {
    private Object root;
    private ArrayList<Tree> subtrees;

    public Tree() {
        this.root = null;
        this.subtrees = new ArrayList<>();
    }

    public Tree(Object root) {
        this.root = root;
        this.subtrees = new ArrayList<>();
    }

    public Tree(Object root, ArrayList<Tree> subtrees)  {
        this.root = root;
        this.subtrees = subtrees;
    }
    
    public boolean isEmpty() {
        return this.root == null;
    }
    
    public int length() {
        if (this.isEmpty()) {
            return 0;
        } else {
            int size = 1;
            for (Tree subtree: this.subtrees) {
                size += subtree.length();
            }
            return size;
        }
    }

    public int count(Object item) {
        if (this.isEmpty()) {
            return 0;
        } else {
            int num = 0;
            if (this.root.equals(item)) {
                num += 1;
            }
            for (Tree subtree: this.subtrees) {
                num += subtree.count(item);
            }
            return num;
        }
    }

    public String toString() {
        return this.strIndented();
    }

    private String strIndented(int depth) {
        if (this.isEmpty()) {
            return "";
        } else {
            StringBuilder s = new StringBuilder();
            s.append("  ".repeat(depth));
            s.append(this.root.toString());
            s.append('\n');
            for (Tree subtree: this.subtrees) {
                s.append(subtree.strIndented(depth + 1));
            }
            return s.toString();
        }
    }

    private String strIndented() {
        if (this.isEmpty()) {
            return "";
        } else {
            StringBuilder s = new StringBuilder(this.root.toString() + '\n');
            for (Tree subtree: this.subtrees) {
                s.append(subtree.strIndented(1));
            }
            return s.toString();
        }
    }

    public double average() {
        if (this.isEmpty()) {
            return 0.0;
        } else {
            double total = this.averageHelper()[0];
            double count = this.averageHelper()[1];

            return total / count;
        }
    }

    private int[] averageHelper() {
        int[] arr = new int[2];
        if (this.isEmpty()){
            arr[1] = 1;
        } else {
            int total = (int) this.root;
            int size = 1;

            for (Tree subtree: this.subtrees) {
                int subtreeTotal = subtree.averageHelper()[0];
                int subtreeSize = subtree.averageHelper()[1];

                total += subtreeTotal;
                size += subtreeSize;
            }
            arr[0] = total;
            arr[1] = size;
        }
        return arr;
    }

    public boolean equals(Tree other) {
        if (this.isEmpty() && other.isEmpty()) {
            return true;
        } else if (this.isEmpty() || other.isEmpty()) {
            return false;
        } else {
            if (!this.root.equals(other.root)) {
                return false;
            }
            if (this.subtrees.size() != other.subtrees.size()) {
                return false;
            }

            for (int i = 0; i < this.subtrees.size(); i++) {
                if (!this.subtrees.get(i).equals(other.subtrees.get(i))) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean contains(Object item) {
        if (this.isEmpty()) {
            return false;
        }
        if (this.root.equals(item)) {
            return true;
        } else {
            for (Tree subtree: this.subtrees) {
                if (subtree.contains(item)) {
                    return true;
                }
            }
            return false;
        }
    }

    public ArrayList<Object> leaves() {
        ArrayList<Object> leaves = new ArrayList<>();

        if (this.isEmpty()) {
            return leaves;
        } else if (this.subtrees.isEmpty()) {
            leaves.add(this.root);
            return leaves;
        } else {
            for (Tree subtree: this.subtrees) {
                leaves.addAll(subtree.leaves());
            }
            return leaves;
        }
    }

    public boolean deleteItem(Object item) {
        if (this.isEmpty()) {
            return false;
        } else if (this.root.equals(item)) {
            this.deleteRoot();
            return true;
        } else {
            for (Tree subtree: this.subtrees) {
                boolean deleted = subtree.deleteItem(item);
                if (deleted && subtree.isEmpty()) {
                    this.subtrees.remove(subtree);
                    return true;
                } else if (deleted) {
                    return true;
                }
            }
            return false;
        }
    }

    private void deleteRoot() {
        if (this.subtrees.isEmpty()) {
            this.root = null;
        } else {
            Tree chosenSubtree = this.subtrees.get(0);
            this.subtrees.remove(chosenSubtree);

            this.root = chosenSubtree.root;
            this.subtrees.addAll(chosenSubtree.subtrees);
        }
    }

    public void insert(Object item) {
        if (this.isEmpty()) {
            this.root = item;
        } else if (this.subtrees.isEmpty()) {
            this.subtrees.add(new Tree(item));
        } else {
            if ((int) Math.floor(Math.random() * 3) + 1 == 3) {
                this.subtrees.add(new Tree(item));
            } else {
                int subtreeIndex = (int) Math.floor(Math.random() * this.subtrees.size());
                this.subtrees.get(subtreeIndex).insert(item);
            }
        }
    }

    public boolean insertChild(Object item, Object parent) {
        if (this.isEmpty()) {
            return false;
        } else if (this.root.equals(parent)) {
            this.subtrees.add(new Tree(item));
            return true;
        } else {
            for (Tree subtree: this.subtrees) {
                if (subtree.insertChild(item, parent)) {
                    return true;
                }
            }
            return false;
        }
    }
}
