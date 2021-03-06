package SeqList;
/**
 * 双向链表节点类
 * @param <T>
 */
public class ListNode<T> {
    T data;
    ListNode<T> pred;
    ListNode<T> succ;
    ListNode(T data){
        this.data = data;
    }
    ListNode(T data,ListNode<T> pred,ListNode<T> succ){
        this.data = data;
        this.succ = succ;
        this.pred = pred;
    }
    @Override
    public String toString() {
        return data.toString();
    }
}
