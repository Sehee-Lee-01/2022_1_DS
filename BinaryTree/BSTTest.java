// (task 3) 구현한 BST가 올바르게 동작하는지 확인해보세요.(완료)
// (task 4) BST에 10개 이상의 노드를 넣어보고, root에서부터 inorder traversal을 수행한 결과를 출력해보세요.(완료)
public class BSTTest {
    public static void main(String[] args){
        Dictionary<Integer, String> bst = new BST<>();
        
        bst.insert(11, "a");
        bst.insert(3, "b");
        bst.insert(5, "c");
        bst.insert(2, "d");
        bst.insert(1, "f");
        bst.insert(12, "l");
        bst.insert(7, "h");
        bst.insert(8, "i");
        bst.insert(6, "g");
        bst.insert(10, "k");
        bst.insert(9, "j");
        bst.insert(13, "m");
        
        bst.remove(3);
        bst.removeAny();// remove 11
        
        System.out.println("***find***");
        System.out.println(bst.find(2)); // d
        System.out.println(bst.find(5)); // c
        System.out.println(bst.find(3)); //null
        System.out.println(bst.find(11)); //null
        System.out.println(bst.find(30)); //null
        
        System.out.println("***inorder***");        
        bst.inorder_start();
        
        System.out.println("***change value***");
        bst.insert(2, "e");
        System.out.println(bst.find(2)); // e
        
        System.out.println("***clean***");
        bst.clear();
        System.out.println(bst.size());
    }
    
}