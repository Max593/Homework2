/**
 * Created by max on 23/03/17.
 */
public class PrivateTest {
    public static void main(String[]  args) {
        MyIntTree t = new MyIntTree(5);
        MyIntTree t2 = new MyIntTree(7);
        t2.addChild(new MyIntTree(6));
        t2.addChild(new MyIntTree(10));
        t.addChild(new MyIntTree(4));
        t.addChild(new MyIntTree(9));
        t.addChild(new MyIntTree(5));
        t.addChild(t2);
        System.out.println("Numero di nodi: "+t.nodes());
    }
}
