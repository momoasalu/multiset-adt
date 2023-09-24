import java.util.ArrayList;

public class Tree {
    private Object root;
    private ArrayList<Object> subtrees;

    public Tree() {
        this.root = null;
        this.subtrees = new ArrayList<>();
    }

    public Tree(Object root) {
        this.root = root;
        this.subtrees = new ArrayList<>();
    }

    public Tree(Object root, ArrayList<Object> subtrees)  {
        this.root = root;
        this.subtrees = subtrees;
    }
}
