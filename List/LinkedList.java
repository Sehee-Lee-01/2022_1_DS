public class LinkedList<E> implements List<E> {
    Link<E> head, tail;
    int size;
    
    // 생성자    
    public LinkedList() {
        head = tail = new Link<>(null, null);
        size = 0;
    }
    
    public void clear() {
        head.setNext(null);
        size = 0;
    }
    
    public void insert (int pos, E item) {
        Link<E> curr = head;
        for (int i=0; i <pos; i++)
            curr = curr.next();
        curr.setNext(new Link<>(item, curr.next()));
        
        if (curr == tail)
            tail = curr.next();
        
        size++;
    }
    
    public void append(E item) {
        tail = tail.setNext(new Link<>(item, null));
        size++;
    }
    
    public void update(int pos, E item) {
        Link<E> curr = head;
        for(int i=0; i<pos; i++) curr = curr.next();
        curr.next().setItem(item);
    }
    
    public E getValue(int pos) {
        Link<E> curr = head;
        for(int i=0; i<pos; i++) curr = curr.next();
        return curr.next().item();
    }
    
    public E remove (int pos) {
        Link<E> curr = head;
        for (int i=0; i<pos; i++)
            curr = curr.next();
        
        E ret = curr.next().item();
        
        if(curr.next() == tail)
            tail = curr;
        
        curr.setNext(curr.next().next());
        
        size--;
        
        return ret;
    }
       
    public int length() {
        return size;
    }
    
    public String toString(){
        String a = "";
        Link<E> curr = head;
        for (int i=0; i<size; i++){
            a += curr.next.item+", ";
            curr = curr.next;
        }
        
        return a;
    }
    
    public ListIterator<E> listIterator() {
        return new ListIterator<E>() {
            Link<E> curr = head;
            public boolean hasNext() {return curr != tail;}
                        
            public E next() {
                curr = curr.next();
                return curr.item();
            }
            
            public boolean hasPrevious() {return curr != head;}
            
            public E previous() {
                Link<E> prev = head;
                while(prev.next() != curr){
                    prev = prev.next();
                }
                curr = prev;
                return curr.next().item();
            }
        };
    }
    
    // 출력할 때 
    public static void main(String[] args){
        List<Integer> myList = new LinkedList<>();
        
        myList.append(3);
        myList.insert(0,1);
        myList.insert(0,4);
        myList.append(10);
        myList.insert(1,5);
        System.out.println(myList);
        System.out.println(myList.length());

        
    }
    
}