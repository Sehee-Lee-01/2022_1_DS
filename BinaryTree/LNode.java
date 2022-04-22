//(task 5) BinNode를 상속하여 LNode를 구현하세요. LNode는 양쪽 자식이 모두 없는 Leaf node만을 위한 구현입니다.
public class LNode<E> implements BinNode<E> {
    
    private E data;
    
    public LNode(E data){
        this.data = data;
    }
    
    public E element(){
        return data;
    };
    
    public E setElement(E item){
        return this.data = item;
    };
    
    public BinNode<E> left(){
        return null;
    };
    
    public BinNode<E> right(){
        return null;        
    };
    
    public boolean isLeaf(){
        return true;
    };
}