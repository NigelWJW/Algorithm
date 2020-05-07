package Queue;
/**
 * 链表实现队列
 * @param <T>
 */
public class LinkedQueue<T> {
    public QueueNode<T> header,tailer;//定义队首队尾
    public int size;//队中元素
    /**
     *初始化队列
     */
    public LinkedQueue(){
        tailer = header = new QueueNode<T>();
        header = null;
        size = 0;
    }
    public LinkedQueue(T data){
        tailer = header = new QueueNode<T>(data,null);
        header = null;
        size = 0;
    }
    /**
     *判断是否是空链
     */
    public boolean isEmpty(){
        return header == tailer;
    }
    /**
     * 入队
     * @param data
     */
    public void enqueue(T data){
        if (data == null) {System.out.println(" 请输入有效数据： ");}
        if (header == null){
            tailer = header = new QueueNode<T>(data,null);
        }
        else{
            QueueNode<T> x = new QueueNode<T>(data,null);
            tailer.succ = x;
            tailer = x;
        }
        size++;
    }
    /**
     * 出队
     */
    public boolean dequeue(){
        if (!isEmpty()){
            QueueNode<T> oldnode = header;
            T data = oldnode.data;
            System.out.println(data);
            header = header.succ;
            oldnode.succ = null;
            size--;
            return true;
        }
        return false;
    }
    /**
     *获取首节点数据
     */
    public T getHeader(){
        return header.data;
    }
    /**
     * 清空队列
     */
    public void clear() {
        while(header != tailer){
            header = null;
            header = header.succ;
        }
        tailer = null;
        size = 0;
    }
    /**
     * 打印队列
     */
    public void print(){
        QueueNode<T> node = header;
        for (int i=0;i<size;i++){
            System.out.print(node.data + " ");
            node = node.succ;
        }
    }
}
