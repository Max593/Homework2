import java.util.ArrayList;
import java.util.List;

/**
 * Created by max on 22/03/17.
 */
public class MyIntTree implements IntTree {
    private int value;
    private List<IntTree> children = new ArrayList<>();  //Figli del nodo

    public MyIntTree(int n) { this.value = n; }

    @Override
    public int getValue() { return value; }
    private List<IntTree> getChildren() { return children; }  //Ottiene la lista children (i figli)

    @Override
    public int childrenNumber() { return children.size(); }

    @Override
    public int nodes() {
        if(this.children.isEmpty()) { return 1; }  //Ritorna almeno il nodo stesso
        else {
            int n = 0;
            for(IntTree h : this.getChildren()) { n += h.nodes(); }
            return n+1;
        }
    }

    @Override
    public int height() {
        if(this.children.isEmpty()) { return 0; }  //Se si tratta di una foglia ritorna 0
        else {
            int maxDepth = 0;
            for(IntTree h : this.getChildren()) { maxDepth = Math.max(maxDepth, h.height()); }
            return maxDepth + 1;
        }
    }

    @Override
    public boolean equals(IntTree t) {
        return false;
    }

    @Override
    public void addChild(IntTree child) { this.children.add(child); }

    @Override
    public IntTree followPath(int[] path) throws NoSuchTreeException {
        return null;
    }

    @Override
    public void visit() {

    }

    @Override
    public void printIntTree() {

    }
}
