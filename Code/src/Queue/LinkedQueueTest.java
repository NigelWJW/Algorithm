package Queue;

/**
 * 链表队列测试类
 */
public class LinkedQueueTest {
    public static void main(String[] args){
        LinkedQueue<Integer> lq = new LinkedQueue<Integer>();
        for (int i = 0;i<10;i++){
            lq.enqueue(i);
        }
        lq.print();
        System.out.println();
        System.out.println(lq.dequeue());
        lq.print();
    }
}
