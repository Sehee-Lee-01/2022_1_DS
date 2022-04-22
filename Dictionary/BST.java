public class BST<K, E> implements Dictionary<K, E> {    
    public void clear();
    public E insert(K k, E e);
    public E remove(K k);
    public E removevAny();
    public E find(K k);
    public int size();
}