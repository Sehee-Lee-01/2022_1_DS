// 테스트 코드
// 과제 2: ArrayStack.java
import java.util.Arrays;

public class TestAll {
    public static void main(String[] args){
        ArrayStack<Integer> myStack = new ArrayStack<>();
        
        myStack.push(1);
        System.out.println(Arrays.toString(myStack.listArray));
        
        myStack.clear();
        
        myStack.push(2);
        myStack.push(3);
        System.out.println(Arrays.toString(myStack.listArray));
        
        myStack.pop();
        myStack.push(4);
        myStack.push(5);        
        myStack.push(6);  
        myStack.pop();
        System.out.println(">> myStack is ");
        System.out.println(Arrays.toString(myStack.listArray));
        System.out.println(">> length is ");
        System.out.println(myStack.length());
        System.out.println(">> myStack.topValue() is ");
        System.out.println(myStack.topValue());
    }
}