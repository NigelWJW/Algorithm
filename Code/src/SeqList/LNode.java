package SeqList;
/**
 * 单链表节点类
 */
public class LNode<E> {
    E data;
    LNode<E> succ;

    public LNode(){ this.succ = null; }
    public LNode(E data){ this.succ = null; this.data = data;}
    public LNode(E data,LNode<E> succ){ this.succ = null;this.succ =succ; }
    public String getData() {
        return data.toString();
    }

    public LNode<E> getSucc(){
        return succ;
    }
}


