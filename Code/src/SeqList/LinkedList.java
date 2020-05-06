package SeqList;
/**
 * 双向链表类的具体实现
 * @param <E>
 */
public class LinkedList<E extends Comparable<E>> {
    private ListNode<E>  header;//头节点
    private ListNode<E>  trailer;//尾结点
    private int size;//元素个数
    /**
     * 列表类初始化
     */
    public LinkedList(){
        init();
    }
    public void init(){
        header = new ListNode<E>(null);
        trailer = new ListNode<E>(null);
        header.succ = trailer;
        header.pred = null;
        trailer.pred = header;
        trailer.succ = null;
        size = 0;
    }
    /**
     * 获取头尾节点和当前节点个数
     */
    public ListNode<E> getHeader(){
        return header;
    }
    public ListNode<E> getTrailer(){
        return trailer;
    }
    public int getSize(){
        return size;
    }
    /**
     * 前插法
     */
    public ListNode<E> insertAsPrev(E data ,int index){
        if (index>size){
            System.out.println(" 下标越界！ ");
        }
        ListNode<E> x = header.succ;
        for (int i = 0;i<index;i++){
            x = x.succ;
        }
        ListNode<E> p =  new ListNode<E>(data,x.pred,x);//p节点在x和x的前继节点之间，构造器省略了p.pred = x.pred;p.succ = x;
        x.pred.succ= p;
        x.pred = p;
        size++;
        return p;
    }
    /**
     * 后插法
     */
    public ListNode<E> insertAsSucc(int index, E data){
        if (index>size){
            System.out.println(" 下标越界！ ");
        }
        ListNode<E> x = header;
        for (int i = 0;i<index;i++){
            x = x.succ;
        }
        ListNode<E> p =  new ListNode<E>(data,x,x.succ);//p节点在x和x的后继节点之间，构造器省略了p.succ = x.succ;p.pred = x;
        x.succ.pred = p;
        x.succ = p;
        size++;
        return p;
    }
    /**
     * 删除链表节点
     */
    public void remove(int index){
        ListNode<E> x = header.succ;
        for (int i = 0;i<index;i++){
            x=x.succ;
        }
        E e = x.data;
        x.pred.succ = x.succ;
        x.succ.pred = x.pred;
        x.pred = null;
        x.succ = null;
        size--;
    }
    /**
     * 无序链表查找节点
     */
    public int find(E e,int n,int index){
        ListNode<E> x = header.succ;
        for (int i=0;i<index;i++){
            x = x.succ;
        }
        while(n-->0){
            if (e==(x.data)){
                return index;
            }
            x = x.pred;
            index--;
        }
        return -1;
    }
    /**
     * 无序链表唯一化
     */
    public int deduplicate(){
        if (size<2) return 0;
        int oldsize = size;
        System.out.println("old size: "+size);
        ListNode<E> x = header.succ;
        int i = 0;
        int num = 0;
        while((x=x.succ)!=trailer){
            int flag = find(x.data,num,i);
            System.out.println("this flag: "+flag);
            if (flag > 0) {
                remove(flag);
                System.out.println("size change: " + size);
            } else {
                i++;
                num++;
            }
        }
        System.out.println("now size: "+size);
        return oldsize - size;
    }
    /**
     * 有序链表唯一化
     */
    public int uniquify(){
        if (size < 2) return 0;
        int oldsize = size;
        ListNode<E> p = header;
        ListNode<E> q;
        int index = 0;
        while ((q=p.succ)!=trailer){
            if (q.data == p.data){
                remove(index);
            }
            else {
                p = q;
                index++;
            }
        }
        return oldsize-size;
    }
    /**
     * 有序链表的查找
     */
    public int search(E e,int n,int index){
        ListNode<E> x = header.succ;
        int flag = 0;
        for (int i = 0;i<index;i++){
            x= x.succ;
        }
        while(n-->=0){
            if ((x = x.pred).data == e){
                break;
            }
            flag++;
        }
        return flag;

    }
    /**
     * 链表打印元素
     */
    public void print() {
        ListNode<E> cur = header.succ;
        while (cur != trailer) {
            System.out.print(cur.data + " ");
            cur = cur.succ;
        }
        System.out.println();
    }
}
