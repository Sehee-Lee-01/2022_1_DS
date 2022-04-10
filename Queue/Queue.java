// FIFO, Buffer 
public interface Queue<E> {
    public void clear();
    
    public void enqueue(E it);
    
    public void dequeue();
    
    public E front();
    
    public E rear();
    
    public int lengrh();    
}