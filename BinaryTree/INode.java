//(task 2) BinNode를 상속하여 INode를 구현하세요. INode는 값, 왼쪽 자식 포인터, 오른쪽 자식 포인터를 가집니다. 
public class INode<E> implements BinNode<E> {
    
    private E data;
    private BinNode<E> l, r;
    
    public INode(E data, BinNode<E> l, BinNode<E> r){
        this.data = data;
        this.l = l;
        this.r = r;
    }
    
    public E element(){
        return data;
    };
    
    public E setElement(E item){
        return this.data = item;
    };
    
    public BinNode<E> left(){
        return l;
    };
    
    public BinNode<E> right(){
        return r;        
    };
    
    public void setLeft(BinNode<E> n){
        this.l =n;
    }
    
    public void setRight(BinNode<E> n){
        this.r = n;
    }
    
    public boolean isLeaf(){
        return l == null && r == null;
    };
}