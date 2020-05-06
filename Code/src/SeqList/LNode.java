package SeqList;
/**
 * 单链表节点类
 */
public class LNode<E> {
    E data;//节点数据
    LNode<E> succ;//后继节点
    public LNode(){ this.succ = null; }//构造函数
    public LNode(E data){ this.succ = null; this.data = data;}
    public LNode(E data,LNode<E> succ){ this.succ = null;this.succ =succ; }
    public String getData() {
        return data.toString();
    }
    public LNode<E> getSucc(){
        return succ;
    }
}


