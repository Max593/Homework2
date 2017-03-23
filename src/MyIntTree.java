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
    public List<IntTree> getChildren() { return children; }

    @Override
    public int childrenNumber() { return children.size(); }

    @Override
    public int nodes() {
        int n = 1;  //Almeno il nodo stesso
        if(children.isEmpty()) { return n; }

        tempC = 1;  //Reset per buona misura
        nodeExplorer(this);
        return tempC;
    }
    private int tempC = 1;  //Counter temporaneo per i nodi
    private void nodeExplorer(IntTree t) {  //Metodo ricorsivo per conteggio dei nodi
        tempC += t.childrenNumber();
        for(IntTree i : ((MyIntTree) t).getChildren()) { nodeExplorer(i); }
    }

    @Override
    public int height() {
        return 0;
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
