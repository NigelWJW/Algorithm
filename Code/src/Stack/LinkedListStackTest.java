package Stack;

/**
 * 测试链表实现栈
 */
public class LinkedListStackTest {
    public  static void main(String[] args){
        LinkedListStack<Integer> lls = new LinkedListStack<Integer>();
        for (int i =0;i<10;i++){
            lls.push(i);
        }

        System.out.println();
        System.out.println(lls.getSize());

        for (int i =0;i<10;i++){
            System.out.print(lls.pop() +" " );
        }

        System.out.println();
        System.out.println(lls.getSize());
    }
}
