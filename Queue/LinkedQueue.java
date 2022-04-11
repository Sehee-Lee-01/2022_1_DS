//과제3
//Link를 사용하여 Queue를 구현하세요. 
public class LinkedQueue<E> implements Queue<E> {
    // rear는 생성 연산, front는 삭제 연산
    Link<E> rear, front;
    int size;
    
    // 생성자    
    public LinkedQueue() {
        rear = front = new Link<>(null, null);
        size = 0;
    }
    
    public void clear() {
        rear.setNext(null);
        front.setItem(null);
        size = 0;
    }
    
    public void enqueue(E item) {
        Link<E> curr = rear;
        curr.setNext(new Link<>(item, curr.next()));
        if(size == 0) {front = curr.next();}
        size++;
    }
    
    public void dequeue() {   
        Link<E> curr = rear;
        for (int i=0; i<size-1; i++){            
            curr = curr.next;
        }
        front = curr;
        size--;
    }
    
    public E front() {
        return front.item();
    }
    
    public E rear() {
        return rear.next().item();
    }
    
    public int length() {
        return size;
    }
    
    public String toString(){
        String a = "";
        Link<E> curr = rear;
        for (int i=0; i<size; i++){
            a += curr.next.item+", ";
            curr = curr.next;
        }
        
        return a;
    }
    
}