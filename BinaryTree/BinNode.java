//(task 1) BinNode interface를 구현하세요.
public interface BinNode<E> {
    public E element();
    public E setElement(E item);
    public BinNode<E> left();
    public BinNode<E> right();
    public boolean isLeaf();    
}