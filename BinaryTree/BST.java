public class BST<K extends Comparable, E> implements Dictionary<K, E> {    
    // Bin node와 연결
    class Entry{
        public K key;
        public E element;
        public Entry(K key, E element){
            this.key = key;
            this.element = element;
        }
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
    }
    
    public void insert(K k, E e){
        root = insert_helper(k, e, root);
        size++;
    }

    
    public BinNode<Entry> insert_helper(K k, E e, BinNode<Entry> rt){
        if (rt == null){
            return new INode<>(new Entry(k, e), null, null);
        }
        // 이미 있는 것을 새롭게 교체
        else if (rt.element().key.compareTo(k) == 0){
            rt.element().element = e;
        }
        else if (rt.element().key.compareTo(k) < 0){
            rt.setRight(insert_helper(k, e, rt.right()));
        }
        else{
            rt.setLeft(insert_helper(k, e, rt.left()));
        }
        return rt;
    }

    public E remove(K k){
        
        E ret = find_helper(k, root);
        
        if(ret != null){
            root = remove_helper(k, root);
            size--;
        }
        return null;
    }
    
    private BinNode<Entry> remove_helper(K k, BinNode<Entry> rt){
        if(rt.element().key.compareTo(k) > 0){
            rt.setLeft(remove_helper(k, rt.left()));
        }
        else if(rt.element().key.compareTo(k) < 0){
            rt.setRight(remove_helper(k, rt.right()));
        }
        else{ // 찾음
            if (rt.left() == null){
                return rt.right();                
            }
            else if (rt.right() == null){
                return rt.left();
            }
            else{
                Entry leftMost = getLeftMost(rt.right());
                rt.setElement(leftMost);
                rt.setRight(removeLeftMost(rt.right()));
                return rt;
            }
        }
        return rt;
    }
    
    private Entry getLeftMost (BinNode<Entry> rt){
        BinNode<Entry> cur = rt;
        while(cur.left() != null){
            cur = cur.left();
        }
        return cur.element();
    }
    
    private BinNode<Entry> removeLeftMost(BinNode<Entry> rt){
        if(rt.left() == null) {
            return rt.right();
        }
        else{
            rt.setLeft(removeLeftMost(rt.left()));
            return rt;
        }
    }
    
    public E removevAny(){
        return null;
    }
    
    public E find(K k){
        return find_helper(k, root);        
    };
    
    public E find_helper (K k, BinNode<Entry> rt){
    if (rt == null){
        return null;
    }
    else if (rt.element().key.compareTo(k) == 0){
        return rt.element().element;
    }
    // root.element().key < k
    else if (rt.element().key.compareTo(k) < 0){
        return find_helper(k, rt.right());
    }
    else {
        return find_helper(k, rt.left());
    }
    }
    
    public int size(){
        return size;
    }
}