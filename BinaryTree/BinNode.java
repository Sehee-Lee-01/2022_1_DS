//(task 1) BinNode interface를 구현하세요.
public interface BinNode<E> {
    public E element();
    public E setElement(E v);
    public BinNode<E> left();
    public BinNode<E> right();
    public boolean isLeaf();

// traversal
    void preorder(BinNode rt) {
        if (rt == null) return; 
        visit(rt); 
        preorder(rt.left()); 
        preorder(rt.right()); 
    }
    
    void inorder(BinNode rt) {
        if (rt == null) return; 
        preorder(rt.left()); 
        visit(rt); 
        preorder(rt.right()); 
    }
    
    void postorder(BinNode rt) {
        if (rt == null) return; 
        preorder(rt.left()); 
        preorder(rt.right()); 
        visit(rt); 
    }
    
}