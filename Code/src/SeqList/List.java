package SeqList;

/**
 * 单链表操作
 */
public class List<T> {
    public LNode<T> header;
    private final int DEFALUTSIZE = 20;
    public int size;

    /**
     *单链表初始化
     */
    public List(){
        size = 0;
        header= new LNode<T>();
    }

    /**
     *获取结点
     */
    public LNode<T> getHeader(){
        return this.header;
    }

    /**
     *根据位置得到元素
     * @param e
     */
    public T getElem(int e){
        LNode<T> x = header.succ;
        for (int i = 0;i<e;i++){
            x = x.succ;
        }
        return x.data;
    }

    /**
     *在指定位置添加元素
     * @param e
     * @param p
     */
    public int add(T e,int p){
        if (p>size) return -1;
        LNode<T> x = header;
        for (int i = 0;i<p;i++){
            x = x.succ;
        }
        LNode<T> s = new LNode<T>();
        s.data = e;
        s.succ = x.succ;
        x.succ = s;
        System.out.print(s.data+" ");
        size++;
        return p;
    }

    /**
     *删除对应位置元素
     * @param p
     */
    public int remove(int p){
        LNode<T> x = header;
        for (int i = 0;i<p;i++){
            x = x.succ;
        }
        T data = x.succ.data;
        LNode<T> y = x.succ;
        System.out.println(data);
        x.succ = y.succ;
        y.succ = null;
        size--;
        return p;
    }

    /**
     * 打印输出单链表
     */
    public void print() {
        LNode<T> cur = header.succ;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.succ;
        }
        System.out.println();
    }
}
