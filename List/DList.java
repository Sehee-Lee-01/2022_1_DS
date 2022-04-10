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
    
    
    public void clear() {
        head.setNext(tail);
        tail.setPrev(head);
        size = 0;
    }
    
    // insert
    public void insert(int pos, E item){
        DLink<E> curr = head;
        for (int i=0; i<pos; i++){
            curr = curr.next();
        };
        curr.setNext(new DLink<E>(item, curr, curr.next()));
        curr.next().next().setPrev(curr.next());
        size++;
    }
    
    public void append(E item) {
        tail = tail.setNext(new DLink<>(item, null));
        size++;
    }
    
    public void update(int pos, E item) {
        DLink<E> curr = head;
        for(int i=0; i<pos; i++) curr = curr.next();
        curr.next().setItem(item);
    }
    
    public E getValue(int pos) {
        DLink<E> curr = head;
        for(int i=0; i<pos; i++) curr = curr.next();
        return curr.next().item();
    }
    // remove
    public E remove(int pos) {
        DLink<E> curr = head;
        for(int i=0;i<pos; i++){
            curr = curr.next();
        }
        E ret = curr.next().item();
        curr.next().next().setPrev(curr);
        curr.setNext(curr.next().next());
        size--;
        return ret;
    }
    
    public int length() {
        return size;
    }
    
    // 실행할 때 포함하기
    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {
            DLink<E> curr = head;
            public boolean hasNext() {return curr != tail;}
                        
            public E next() {
                curr = curr.next();
                return curr.item();
            }
            
            public boolean hasPrevious() {return curr != head;}
            
            public E previous() {
                DLink<E> prev = head;
                while(prev.next() != curr){
                    prev = prev.next();
                }
                curr = prev;
                return curr.next().item();
            }
        };
    }
}