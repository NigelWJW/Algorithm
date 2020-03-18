package SeqList;

/**
 * 单链表测试类
 */
public class ListTest {
    public static void main(String[] args){
        List<Integer> l = new List<Integer>();
        for (int i = 0;i<10;i++){
            l.add(i,i);
        }
        System.out.println();
        System.out.println(l.remove(5));
        l.print();

    }
}
