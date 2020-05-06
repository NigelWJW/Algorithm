package SeqList;
/**
 * 单链表操作
 */
public class List<T extends Comparable<T>> {
    public LNode<T> header;//定义头节点
    public int size;//当前元素个数
    /**
     *构造函数
     */
    public List(){
        size = 0;
        header= new LNode<T>();
    }
    /**
     * 头节点建表
     */
    public void creatFirstList(T[] array){
        LNode<T> s = header;
        for (T t:array
             ) {
            LNode<T> x = new LNode<>(t);
            x.succ = s.succ;//反复插入头节点后
            s.succ = x;
            size++;
        }
    }
    /**
     * 尾节点建表
     */
    public void creatEndList(T[] array){
        LNode<T> s = header;
        for (T t:array
        ) {
            LNode<T> x = new LNode<>(t);
            s.succ = x;
            s = x;//插入尾后，再指向表尾
            size++;
        }
    }
    /**
     *获取头结点
     */
    public LNode<T> getHeader(){
        return this.header;
    }
    /**
     *根据位置p获取对应元素的值
     * @param p
     */
    public T getElem(int p){
        LNode<T> x = header.succ;//定义首元素
        for (int i = 0;i<p;i++){
            x = x.succ;//依次后移
        }
        return x.data;
    }
    /**
     *在指定位置p添加元素e，后插法
     * @param e
     * @param p
     */
    public int add(T e,int p){
        if (p>size) return -1;//超过容量返回
        LNode<T> x = header;//定义首元素
        for (int i = 0;i<p;i++){
            x = x.succ;//依次后移
        }
        LNode<T> s = new LNode<T>();//新建节点
        s.data = e;//赋值给新节点
        s.succ = x.succ;//先操作后继节点
        x.succ = s;
        System.out.print(s.data+" ");
        size++;
        return p;
    }
    /**
     *在指定位置p添加元素e，前插法-做法和后插相同，只是将数据域交换即可
     * @param e
     * @param p
     */
    public int insert(T e,int p){
        if (p>size) return -1;//超过容量返回
        LNode<T> x = header;//定义首元素
        for (int i = 0;i<p;i++){
            x = x.succ;//依次后移
        }
        LNode<T> s = new LNode<T>();//新建节点
        s.data = e;//赋值给新节点
        s.succ = x.succ;//先操作后继节点
        x.succ = s;
        T temp = x.data;//交换数据域
        x.data = s.data;
        s.data = temp;
        System.out.print(s.data+" ");
        size++;
        return p;
    }
    /**
     *删除对应位置p的元素
     * @param p
     */
    public int remove(int p){
        LNode<T> x = header;
        for (int i = 0;i<p;i++){
            x = x.succ;
        }
        T data = x.succ.data;
        LNode<T> y = x.succ;//y为x后继节点。删除y节点
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
