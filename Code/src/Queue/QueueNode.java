package Queue;
/**
 * 队列节点类
 * @param <E>
 */
public class QueueNode<E> {
    public E data;
    public QueueNode<E> succ;
    public QueueNode(){
        this.succ = null;
    }
    public QueueNode(E data,QueueNode<E> succ){
        this.succ = succ;
        this.data = data;
    }
}
