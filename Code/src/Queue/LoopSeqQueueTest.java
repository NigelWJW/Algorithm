package Queue;

/**
 * 循环队列测试
 */
public class LoopSeqQueueTest {
    public static void main(String[] args){
        LoopSeqQueue<Integer> lsq= new LoopSeqQueue<Integer>();
        for (int i = 0;i<10;i++){
            lsq.enqueue(i);
        }
        lsq.print();
        System.out.println();
        lsq.dequeue();
        lsq.print();
    }
}
