// 테스트 코드
// 과제 1: DList.java

public class TestAll {
    public static void main(String[] args){
        List<Integer> myList = new DList<>();
        
        myList.append(1);
        myList.clear();
        myList.insert(0,2);
        myList.append(3);
        myList.insert(0,4);
        myList.append(5);
        myList.remove(2);
        System.out.println(">> myList is ");
        System.out.println(myList);
        System.out.println(">> length is ");
        System.out.println(myList.length());
        System.out.println(">> myList.getValue(1) is ");
        System.out.println(myList.getValue(1));
            
        System.out.println(">> ListIterator");
        ListIterator<Integer> itr = myList.listIterator();
        while(itr.hasNext()){
            int item = itr.next();
            System.out.println(item);
        }
    }
}