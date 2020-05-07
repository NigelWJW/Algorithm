package Queue;
/**
 * 向量实现队列
 */
public class SeqQueue<T extends Comparable<T>> {
    public Object[] queue;//队列数组
    private final int DEFAULTSIZE = 20;
    public int size;
    /**
     *初始化向量队列
     */
    public SeqQueue(){
        size = 0;
        queue = new Object[DEFAULTSIZE];
    }
    public SeqQueue(int maxsize){
        size = 0;
        queue = new Object[maxsize];
    }
    /**
     * 获取元素个数
     */
    public int getSize() {
        return size;
    }
    /**
     *是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     *是否是满
     */
    public boolean isFull(){
        return size == DEFAULTSIZE;
    }
    /**
     *获取队首
     */
    public Object front(){
        if (!isEmpty()){
            return queue[0];
        }
        return null;
    }
    /**
     *入队操作
     * @param data
     */
    public boolean enqueue(T data){
        if (isFull()){
            return false;
        }
        queue[size++] = data;
        return true;
    }
    /**
     *出队操作
     */
    public boolean dequeue(){
        if (isEmpty()){
            return false;
        }
        Object temp = queue[0];
        System.out.println(temp);
        for (int i = 1;i<size;i++){
            queue[i-1] = queue[i];
        }
        queue[--size] = null;
        return true;
    }
    /**
     *打印队列
     */
    public void print(){
        for (Object i:queue
             ) {
            System.out.print(i + " ");
        }
    }
}
