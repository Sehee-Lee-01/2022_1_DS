// 테스트 코드
// 과제 3: LinkedQueue.java

public class TestAll {
    public static void main(String[] args){
        LinkedQueue<Integer> myQueue = new LinkedQueue<>();
        
        myQueue.enqueue(1);
        System.out.println(myQueue);

        myQueue.clear();
        System.out.println(myQueue.length());
        System.out.println(myQueue.front());
        
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        myQueue.enqueue(4);
        System.out.println(myQueue);
        
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        System.out.println(myQueue);
        System.out.println(myQueue.rear());
        System.out.println(myQueue.front());
        System.out.println(myQueue.length());
    }
}