//과제2
//Array를 사용하여 Stack을 구현하세요.
public class ArrayStack<E> implements Stack<E> {
    // 자료구조 및 생성자
    private static int DefaultSize = 10;
    
    int maxSize; // max size of stack
    int top; // index for top
    E[] listArray;
    
    // 생성자
    public ArrayStack() {
        this(DefaultSize);
    }
    
    public ArrayStack(int size){
        maxSize = 0;
        top = 0;
        listArray = (E[]) new Object[size];
    }
    
    public void clear() {
        top = 0;
        maxSize = 0;
    }
    
    public void push(E item) {
        if (maxSize == 0) {top = 0;} else {top++;}
        listArray[maxSize++] = item;
    }
    
    public E pop() {
        E ret = listArray[top];

        maxSize--;
        
        listArray[top] = null;
        top--;
        
        
        return ret;
    }
    
    public E topValue() {
        return listArray[top];
    }
    
    public int length() {
        return maxSize;
    }
    
}