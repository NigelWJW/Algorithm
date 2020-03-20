package Queue;

/**
 *测试向量队列
 */
public class SeqQueueTest {
    public static void main(String[] args){
        SeqQueue<Integer> sq=new SeqQueue<Integer>(20);
        for(int i = 0;i<10;i++){
            sq.enqueue(i);
        }
        sq.print();

        System.out.println();
        sq.dequeue();
        sq.print();

        System.out.println();
        System.out.println(sq.front());
    }
}
