package SeqList;

/**
 * 节点类
 * @param <T>
 */
public class ListNode<T> {
    T data;
    ListNode<T> pred;
    ListNode<T> succ;

    ListNode(){}
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
