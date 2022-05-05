// (task 1) dictionary interface를 BST로 구현하세요.(완료)
// (task 2) BST를 구현할 때 leaf 노드는 null 포인터가 없는 LNode를 사용하도록 실습 코드를 수정해보세요.
public class BST<K extends Comparable, E> implements Dictionary<K, E> {    
    // Bin node와 연결
    public class Entry{
        public K key;
        public E element;
        public Entry(K key, E element){
            this.key = key;
            this.element = element;
        }
        public String toString() {
            return "Entry (key: " +key+", element: "+element+")\n";
        }
    }
    
    public BinNode<Entry> root;
    private int size;
    
    // 생성자
    public BST(){
        root = null;
        size = 0;
    }
    
    // 모두 지우기
    public void clear(){
        root = null;
        size =0;
    }
    
    // 새 노드 삽입
    public void insert(K k, E e){
        root = insert_helper(k, e, root);
        size++;
    }

    public BinNode<Entry> insert_helper(K k, E e, BinNode<Entry> rt){
        // 루트가 없을 때 새로 노드 생성
        if (rt == null){
            return new LNode<>(new Entry(k, e));
        }
        // 이미 있는 것을 새롭게 교체
        // 루트 키 == insert 키 
        else if (rt.element().key.compareTo(k) == 0){
            // e 만 갱신
            rt.element().element = e;
        }
        // 루트 키 < insert 키, 끝까지 맞는 곳을 찾아간다.
        
        else if (rt.element().key.compareTo(k) < 0){
            if(rt instanceof LNode){
                rt = new INode<>(rt.element(), null,new LNode<>(new Entry(k, e)));
            }
            else {rt.setRight(insert_helper(k, e, rt.right()));}
        }
        // 루트 키 > insert 키, 끝까지 맞는 곳을 찾아간다.
        else{
            if(rt instanceof LNode){
                rt = new INode<>(rt.element(), new LNode<>(new Entry(k, e)),null);
            } 
            else {rt.setLeft(insert_helper(k, e, rt.left()));}
        }
        return rt;
    }

    public E remove(K k){
        // k 값을 찾으러!
        E ret = find_helper(k, root);
        
        if(ret != null){
            root = remove_helper(k, root);
            size--;
        }
        return null;
    }
    
    private BinNode<Entry> remove_helper(K k, BinNode<Entry> rt){
        // 루트 키 > 지우려는 키(루트의 왼쪽으로)
        if(rt.element().key.compareTo(k) > 0){
            rt.setLeft(remove_helper(k, rt.left()));
        }
        // 루트 키 < 지우려는 키(루트의 오른쪽으로)
        else if(rt.element().key.compareTo(k) < 0){
            rt.setRight(remove_helper(k, rt.right()));
        }
        else{ 
            // 지우려는 키 찾았을 때
            // 해당 키 값 왼쪽이 null 일 경우(양 쪽 빈 경우 null 리턴)
            if (rt.left() == null){
                // 해당 키 값 오른쪽도 null 일 경우
                if (rt.right() == null){
                    return rt = new LNode<Entry>(rt.element());
                } else {
                    return rt.right();    
                }                            
            }
            // 해당 키 값 오른쪽만 null 일 경우
            else if (rt.right() == null){
                return rt.left();       
            }
            
            // 양쪽이 차 있는 경우 실행(오른쪽 자식트리에서 가장 작은 것 가져오는 로직으로)
            else{
                Entry leftMost = getLeftMost(rt.right());
                rt.setElement(leftMost);
                rt.setRight(removeLeftMost(rt.right()));
            }
        }
        return rt;
    }
    
    //트리의 왼쪽에서 가장 작은 값 찾아오기
    private Entry getLeftMost (BinNode<Entry> rt){
        BinNode<Entry> cur = rt;
        while(cur.left() != null){
            cur = cur.left();
        }
        return cur.element();
    }
    
    // 위 찾아온 값을 가진 노드 지우기
    private BinNode<Entry> removeLeftMost(BinNode<Entry> rt){
        // 지워야 할 값이 root인경우 right 리턴(right도 없으면 null) 
        if(rt.left() == null) {
            return rt.right();
        }
        // 트리에서 가장 작은 값 지우기 
        else{
            rt.setLeft(removeLeftMost(rt.left()));
            return rt;
        }
    }
    
    // 랜덤 지우기(임의로 루트 지우기)
    public E removeAny(){
        remove(root.element().key);
        return null;
    }
    
    // 키 값 찾기
    public E find(K k){
        return find_helper(k, root);        
    };
    
    // 키 값이 있으면 그 엘리먼트 리턴, 없으면 null 리턴
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
    
    // 사이즈 출력
    public int size(){
        return size;
    }
    
    // traversal function
    public void inorder_start(){
        inorder(root);
    }
    
    private <Entry> void inorder(BinNode<Entry> rt) {
        if (rt == null) return;
        inorder(rt.left());
        System.out.print(rt);
        inorder(rt.right()); 
    }
}