package Stack;
/**
 * 栈单链表结点类
 */
public class StackNode<E> {
    E data;
    StackNode<E> succ;//后继节点
    public StackNode(){ this.succ = null;}//构造函数
    public StackNode(E e){
        this.data = e;
        this.succ = null;
    }
    public StackNode(E e,StackNode<E> succ){
        this.succ = succ;
        this.data = e;
    }
    public String getData() {
        return data.toString();
    }
    public StackNode<E> getSucc(){
        return succ;
    }
}
