import java.util.ArrayList;
import java.util.List;
//import java.util.Objects;

/**
 * Created by max on 22/03/17.
 */
public class MyIntTree implements IntTree {
    private int value;
    private List<IntTree> children = new ArrayList<>();  //Figli del nodo

    public MyIntTree(int n) { this.value = n; }

    @Override
    public int getValue() { return value; }

    @Override
    public int childrenNumber() { return children.size(); }

    @Override
    public int nodes() {
        if(this.children.isEmpty()) { return 1; }  //Ritorna almeno il nodo stesso
        else {
            int n = 0;
            for(IntTree h : this.children) { n += h.nodes(); }
            return n+1;
        }
    }

    @Override
    public int height() {
        if(this.children.isEmpty()) { return 0; }  //Se si tratta di una foglia ritorna 0
        else {
            int maxDepth = 0;
            for(IntTree h : this.children) { maxDepth = Math.max(maxDepth, h.height()); }
            return maxDepth + 1;
        }
    }

    @Override
    public boolean equals(IntTree t) {
        if(this.getValue() != t.getValue() || this.childrenNumber() != t.childrenNumber()) { return false; }
        else if(this.childrenNumber() == 0) { return true; }
        else {
            boolean res = true;
            for(int i = 0; i < this.childrenNumber(); i++) {
                int arr[] = {i};
                try {
                    res = this.followPath(arr).getValue() == t.followPath(arr).getValue() && this.followPath(arr).equals(t.followPath(arr));
                } catch (NoSuchTreeException ignore) {}
            }
            return res;
        }
    }

/*  //Possibilità di errore, da ricontrollare.
    @Override
    public boolean equals(IntTree t) { return Objects.equals(this.hashCode(), t.hashCode()); }  //Controllo basato su hashCode
    @Override
    public int hashCode() { return Integer.valueOf(sVisit(this)); }  //HashCode generato con sVisit()

 */

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
        System.out.println(sVisit(this));
    }
    private String sVisit(MyIntTree t) {  //Riempie ricorsivamente una stringa dal fondo verso l'inizio con i valori dell'albero
        if(t.children.isEmpty()) { return String.valueOf(t.getValue()); }
        else {
            String n = "";
            for(IntTree h : t.children) { n = sVisit(((MyIntTree) h)) + n; }
            return t.getValue() + n;
        }
    }

    @Override
    public void printIntTree() { printIntTree("", true); }
    private void printIntTree(String prefix, boolean isTail) {  //Utilizzato operatore condizionale ternario per leggibilità generale
        System.out.println(prefix + (isTail ? "└── " : "├── ") + this.value);
        for (int i = 0; i < this.children.size() - 1; i++) {
            ((MyIntTree)this.children.get(i)).printIntTree(prefix + (isTail ? "    " : "│   "), false);
        }
        if (this.children.size() > 0) {
            ((MyIntTree)this.children.get(this.children.size() - 1)).printIntTree(prefix + (isTail ?"    " : "│   "), true);
        }
    }

}
