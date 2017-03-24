import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    public boolean equals(IntTree t) { return Objects.equals(this.hashCode(), t.hashCode()); }
    @Override
    public int hashCode() { return Integer.valueOf(sVisit(this)); }

    @Override
    public void addChild(IntTree child) { this.children.add(child); }

    @Override
    public IntTree followPath(int[] path) throws NoSuchTreeException {
        MyIntTree n = this;
        for (int aPath : path) {
            if (n.children.isEmpty()) { throw new NoSuchTreeException(); }
            try{ n = ((MyIntTree) n.children.get(aPath-1)); }
            catch (Exception ignore) { throw new NoSuchTreeException(); }
        }
        return n;
    }

    @Override
    public void visit() {
        System.out.print(sVisit(this));
    }
    private String sVisit(MyIntTree t) {
        if(t.children.isEmpty()) { return String.valueOf(t.getValue()); }
        else {
            String n = "";
            for(IntTree h : t.children) { n = sVisit(((MyIntTree) h)) + n; }
            return t.getValue() + n;
        }
    }

    @Override
    public void printIntTree() { printIntTree("", true); }
    private void printIntTree(String prefix, boolean isTail) {
        System.out.println(prefix + (isTail ? "└── " : "├── ") + this.value);
        for (int i = 0; i < this.children.size() - 1; i++) {
            ((MyIntTree)this.children.get(i)).printIntTree(prefix + (isTail ? "    " : "│   "), false);
        }
        if (this.children.size() > 0) {
            ((MyIntTree)this.children.get(this.children.size() - 1)).printIntTree(prefix + (isTail ?"    " : "│   "), true);
        }
    }

}
