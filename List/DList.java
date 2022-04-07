//과제1
//ListIterator를 포함하여 
//Doubly Linked List를 구현하세요.

public class DoublyLinkedList<E> implements LinkedList<E> {
    DLink<E> head, tail;
    int size;
    
    // 생성자
     public DoublyLinkedList() {
        head = tail = new DLink<>(null, null);
        size = 0;
    }
    
    
    public void clear() ;
    public void insert(int pos, E item){
        Link<E> curr = head;
        for (int i=0; i<pos; i++){
            curr = curr.next();
        }
    }
    public void append(E item);
    public void update(int pos, E item);
    public E getValue(int pos);
    public E remove(int pos);
    public int length();
    public ListIterator<E> listIterator();
}