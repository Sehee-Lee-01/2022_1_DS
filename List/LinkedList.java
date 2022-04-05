class LinkedList<E> implements List<E> {
    private Link<E> head, tail;
    int size;
        
    public LinkedList() {
        head = tail = new Link<>(null, null);
        size = 0;
    }
    
    @Override
    public void clear() {
        head.setNext(null);
        size = 0;
    }
    
    @Override
    public void update(int pos, E item) {
        Link<E> curr = head;
        for(int i=0; i<pos; i++) curr = curr.next();
        curr.next().setItem(item);
    }
    
    @Override
    public E getValue(int pos) {
        Link<E> curr = head;
        for(int i=0; i<pos; i++) curr = curr.next();
        return curr.next().item();
    }
    
    @Override
    public int length() {
        return size;
    }
    
    @Override
    public void append() {
        tail = tail.setNext(new Link<>(item, null));
        size++;
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
    
}