public class TreeTest{
    public static void main(String[] args){
        
        //(task 3) 구현한 BinNode와 INode를 이용하여 본인이 좋아하는 10자 이상의 영어 단어 혹은 구의 글자들로 tree를 구성하세요. 
        //tree의 모양은 너무 단조롭지만 않으면 아무렇게나 구성해도 좋습니다. 
        //단, root에서부터 inorder traversal 을 수행하였을 때, 문구가 올바르게 출력되도록 구성하세요.
        BinNode<String> a1 = new INode<>("I", null, null);
        BinNode<String> b1 = new INode<>("d", null, null);
        BinNode<String> c1 = new INode<>(" ", null, null);
        BinNode<String> d1 = new INode<>("o", null, null);
        BinNode<String> e1 = new INode<>("e", null, null);
        BinNode<String> f1 = new INode<>("r", null, null);
        BinNode<String> g1 = new INode<>("!", null, null);
        BinNode<String> h1 = new INode<>(" ", a1, b1);
        BinNode<String> i1 = new INode<>("i", h1, null);
        BinNode<String> j1 = new INode<>("d", i1, c1);
        BinNode<String> o1 = new INode<>("k", f1, g1);
        BinNode<String> m1 = new INode<>("o", null, o1);
        BinNode<String> n1 = new INode<>("w", e1, m1);
        BinNode<String> l1 = new INode<>("m", d1, n1);
        BinNode<String> k1 = new INode<>("H", j1, l1);

        
        System.out.println("***Start Task3***\n");
        inorder(k1);
        
        //(task 4) preorder, inorder, postorder traversal을 수행하는 함수를 구현하고, 함수를 수행한 결과를 확인하세요.        
        System.out.println("\n\n\n***Start Task4***\n");
        System.out.println("*Start preorder*\n");
        preorder(k1);
        System.out.println("\n\n*Start inorder*\n");
        inorder(k1);
        System.out.println("\n\n*Start postorder*\n");
        postorder(k1);
        System.out.println();
        
        //(task 6) task 3에서 구현한 tree에서 leaf node를 기존 INode에서 LNode로 교체하고, task 5를 수행하여 기존 결과와 동일함을 확인하세요.
        BinNode<String> a2 = new LNode<>("I");
        BinNode<String> b2 = new LNode<>("d");
        BinNode<String> c2 = new LNode<>(" ");
        BinNode<String> d2 = new LNode<>("o");
        BinNode<String> e2 = new LNode<>("e");
        BinNode<String> f2 = new LNode<>("r");
        BinNode<String> g2 = new LNode<>("!");
        BinNode<String> h2 = new INode<>(" ", a2, b2);
        BinNode<String> i2 = new INode<>("i", h2, null);
        BinNode<String> j2 = new INode<>("d", i2, c2);
        BinNode<String> o2 = new INode<>("k", f2, g2);
        BinNode<String> m2 = new INode<>("o", null, o2);
        BinNode<String> n2 = new INode<>("w", e2, m2);
        BinNode<String> l2 = new INode<>("m", d2, n2);        
        BinNode<String> k2 = new INode<>("H", j2, l2);

    
        System.out.println("\n\n***Start Task6***\n");
        inorder(k2);

    }
    
    // traversal function
    public static <E> void preorder(BinNode<E> rt) {
        if (rt == null) return; 
        System.out.print(rt.element()); //visit
        preorder(rt.left()); 
        preorder(rt.right()); 
    }
    
    public static <E> void inorder(BinNode<E> rt) {
        if (rt == null) return; 
        inorder(rt.left()); 
        System.out.print(rt.element());
        inorder(rt.right()); 
    }
    
    public static <E> void postorder(BinNode<E> rt) {
        if (rt == null) return; 
        postorder(rt.left()); 
        postorder(rt.right()); 
        System.out.print(rt.element());
    }
}