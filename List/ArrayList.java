public class ArrayList<E> implements List<E> {
    // 자료구조 및 생성자
    private static final int defaultSize = 10;
    private int listSize;
    private E[] data;
    
    public ArrayList() {
    this(defaultSize);
    }
    
    public ArrayList(int size){
    listSize = 0;
    data = (E[]) new Object[size];
    }
    
    // method
    public void clear() {listSize = 0;}
    
    public void uodate(int pos, E item) {data[pos] = item;}
    
    public E getValue (int pos) {return data[pos];}
    
    public int length() {return listSize;}
    
    public void append(E item) {data[listSize++] = item;}
    
    public void insert (int pos, E item) {
        for (int i=listSize; i > pos; i--)
            data[i] = data[i-1];
        
        data[pos] = item;
        listSize++;
    }
    
    public E remove (int pos) {
        E ret = data[pos];
        
        for (int i=pos; i<listSize-1; i++)
            data[i] = data[i+1];
        
        listSize--;
        
        return ret;
    }

}