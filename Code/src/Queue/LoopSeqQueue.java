package Queue;

/**
 * 向量实现的循环队列
 */
public class LoopSeqQueue<T> {
    public int header,tailer;
    public int DEFAULTSIZE = 20;
    public int size,capacity;
    public Object[] loopqueue;

    /**
     *初始化队列
     */
    public LoopSeqQueue(){
        size = 0;
        header = tailer = 0;
        capacity = DEFAULTSIZE;
        loopqueue = new Object[capacity];
    }

    public LoopSeqQueue(int maxsize){
        size = 0;
        header = tailer = 0;
        capacity = maxsize;
        loopqueue = new Object[capacity];
    }

    /**
     * 扩容
     */
    public void expand(){
        if (size>capacity) return;
        Object[] oldelem = loopqueue;
        loopqueue = new Object[capacity<<1];
        for(int i = 0;i<size;i++){
            loopqueue[i] = oldelem[(i+header)%capacity];
        }
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
        return header == tailer;
    }

    /**
     *是否是满
     */
    public boolean isFull(){
        return (tailer+1)%capacity == header;
    }

    /**
     *获取队首
     */
    public Object front(){
        if (!isEmpty()){
            return loopqueue[header];
        }
        return null;
    }

    /**
     * 入队
     * @param data
     */
    public boolean enqueue(T data){
        if(!isFull()){
            loopqueue[tailer] = data;
            tailer = (tailer+1)%capacity;
            size++;
            return true;
        }
//        expand();
        return false;
    }

    /**
     *出队
     */
    public boolean dequeue(){
        if (!isEmpty()){
            Object x = loopqueue[header];
            loopqueue[header] = null;
            header = (header + 1)%capacity;
            size--;
            return true;
        }
        return false;
    }

    /**
     * 打印队列
     */
    public void print(){
        for (Object i:loopqueue
             ) {
            System.out.print(i +" ");
        }
    }


}
