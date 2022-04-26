public class BST<K extends Comparable, E> implements Dictionary<K, E> {    
    // Bin node와 연결
    class Entry{
        public K key;
        public E element;
    }
    
    private BinNode<Entry> root;
    private int size;
    
    // 생성자
    public BST(){
        root = null;
        size = 0;
    }
    
    
    public void clear(){
        root = null;
        size =0;
    };
    
    public E insert(K k, E e){
            
    };

    public E remove(K k){
        
    };
    
    public E removevAny(){
        
    };
    
    public E find(K k){
    if (root == null) return null;
    else {
        return find_helper(k, root);
    }            
    };
    
    public E find_helper (K k, BinNode<Entry> rt){
        
    if (root.element().compareTo(k) == 0){
        return root.element().element;
    }
    // root.element().key < k
    else if (root.element().key.compareTo(k) < 0){
        return find_helper(k, rt.right());
    }
    else {
        return find_helper((k, rt.left()));
    }
        return null;
    };
    
    public int size(){
        return size;
    };
}