/**
 * Created by max on 23/03/17.
 */
public class PrivateTest {
    public static void main(String[]  args) {
        MyIntTree t = new MyIntTree(4);  //root

        MyIntTree t11 = new MyIntTree(2);  //1
        MyIntTree t12 = new MyIntTree(2);
        MyIntTree t13 = new MyIntTree(4);
        MyIntTree t14 = new MyIntTree(6);

        MyIntTree t21 = new MyIntTree(1);  //2
        MyIntTree t22 = new MyIntTree(2);
        MyIntTree t23 = new MyIntTree(6);
        MyIntTree t24 = new MyIntTree(7);
        MyIntTree t25 = new MyIntTree(3);
        MyIntTree t26 = new MyIntTree(2);

        MyIntTree t31 = new MyIntTree(1);  //3
        MyIntTree t32 = new MyIntTree(2);
        MyIntTree t33 = new MyIntTree(3);
        MyIntTree t34 = new MyIntTree(3);
        MyIntTree t35 = new MyIntTree(8);
        MyIntTree t36 = new MyIntTree(2);
        MyIntTree t37 = new MyIntTree(9);

        MyIntTree t41 = new MyIntTree(5);  //4
        MyIntTree t42 = new MyIntTree(2);
        MyIntTree t43 = new MyIntTree(5);
        MyIntTree t44 = new MyIntTree(6);
        MyIntTree t45 = new MyIntTree(7);

        t33.addChild(t43);
        t33.addChild(t44);
        t31.addChild(t41);
        t31.addChild(t42);
        t37.addChild(t45);

        t21.addChild(t31);
        t21.addChild(t32);
        t21.addChild(t33);
        t22.addChild(t34);
        t24.addChild(t35);
        t24.addChild(t36);
        t25.addChild(t37);

        t11.addChild(t21);
        t11.addChild(t22);
        t12.addChild(t23);
        t13.addChild(t24);
        t13.addChild(t25);
        t14.addChild(t26);

        t.addChild(t11);
        t.addChild(t12);
        t.addChild(t13);
        t.addChild(t14);


        MyIntTree at = new MyIntTree(4);  //root

        MyIntTree at11 = new MyIntTree(2);  //1
        MyIntTree at12 = new MyIntTree(2);
        MyIntTree at13 = new MyIntTree(4);
        MyIntTree at14 = new MyIntTree(6);

        MyIntTree at21 = new MyIntTree(1);  //2
        MyIntTree at22 = new MyIntTree(2);
        MyIntTree at23 = new MyIntTree(6);
        MyIntTree at24 = new MyIntTree(7);
        MyIntTree at25 = new MyIntTree(3);
        MyIntTree at26 = new MyIntTree(2);

        MyIntTree at31 = new MyIntTree(1);  //3
        MyIntTree at32 = new MyIntTree(2);
        MyIntTree at33 = new MyIntTree(3);
        MyIntTree at34 = new MyIntTree(3);
        MyIntTree at35 = new MyIntTree(8);
        MyIntTree at36 = new MyIntTree(2);
        MyIntTree at37 = new MyIntTree(9);

        MyIntTree at41 = new MyIntTree(5);  //4
        MyIntTree at42 = new MyIntTree(2);
        MyIntTree at43 = new MyIntTree(5);
        MyIntTree at44 = new MyIntTree(6);
        MyIntTree at45 = new MyIntTree(7);

        at33.addChild(at43);
        at33.addChild(at44);
        at31.addChild(at41);
        at31.addChild(at42);
        at37.addChild(at45);

        at21.addChild(at31);
        at21.addChild(at32);
        at21.addChild(at33);
        at22.addChild(at34);
        at24.addChild(at35);
        at24.addChild(at36);
        at25.addChild(at37);

        at11.addChild(at21);
        at11.addChild(at22);
        at12.addChild(at23);
        at13.addChild(at24);
        at13.addChild(at25);
        at14.addChild(at26);

        at.addChild(at11);
        at.addChild(at12);
        at.addChild(at13);
        at.addChild(at14);

        System.out.println("Numero nodi: "+t.nodes());
        System.out.println("Altezza: "+t.height());
        int[] path = {1,2,1};
        try { System.out.println(t.followPath(path).getValue()); }
        catch (NoSuchTreeException ignored) { System.out.println("NoSuchTreeException"); }
        t.visit();
        System.out.print("\n");
        System.out.println("----------------------");
        System.out.println(t.equals(at));
        System.out.println(t.equals(at));
        t.printIntTree();
    }
}

/*
└── 4
    ├── 2
    │   ├── 1
    │   │   ├── 1
    │   │   │   ├── 5
    │   │   │   └── 2
    │   │   ├── 2
    │   │   └── 3
    │   │       ├── 5
    │   │       └── 6
    │   └── 2
    │       └── 3
    ├── 2
    │   └── 6
    ├── 4
    │   ├── 7
    │   │   ├── 8
    │   │   └── 2
    │   └── 3
    │       └── 9
    │           └── 7
    └── 6
        └── 2
 */