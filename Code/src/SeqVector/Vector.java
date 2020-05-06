package SeqVector;
/**
 * 顺序表vector简单操作
 */
public class Vector implements VectorList{//可加上Comparable接口
    final int DEFAULTSIZE = 20;//默认数组大小
    int capacity;//数组容量
    int size;//当前元素个数
    int[] elem;//元素数组
    /**
     * 初始化数组
     */
    public Vector(){
        capacity = DEFAULTSIZE;
        elem = new int[capacity];
        size = 0; }
    public Vector(int[] A,int n){
        copyfrom(A,0,n); }
    public Vector(int[] A,int lo,int hi){
        copyfrom(A,lo,hi); }
    /**
     * 复制构造函数
     */
    @Override
    public void copyfrom(int[] A, int lo, int hi) {
        elem = new int[ capacity= 2*(lo+hi)];//创建两倍大小的容量
        size = 0;
        while(lo<hi){
            elem[lo++] = A[lo++];//复制原数组内容
        }
    }
    /**
     * 扩容操作
     */
    @Override
    public void expand() {
        if (size>capacity) return;//个数超过容量出错
        if (capacity<DEFAULTSIZE) capacity = DEFAULTSIZE;//小于最小容量
        int[] oldelem = elem;
        elem = new int[capacity<<1];//两倍容量
        for (int i=0;i<size;i++){//复制数组元素
            elem[i] = oldelem[i];
        }
    }
    /**
     * 缩容操作
     */
    @Override
    public void shrink() {
        if (capacity<DEFAULTSIZE<<1) return;
        if (size<<2>capacity) return;
        int[] oldelem = elem;
        elem = new int[capacity>>1];//缩小为原来的一半容量
        for (int i=0;i<size;i++){
            elem[i] = oldelem[i];
        }
    }
    /**
     * 无序数组顺序查找
     */
    @Override
    public int find(int e, int lo, int hi) {//在[lo,hi]中查找e
        for (int i = lo;i<=hi;i++){
            if (e == elem[i]){
                return i;
            }
            else {
                System.out.println(" error! ");
            }
        }
        return -1;
    }
    /**
     * 无序数组插入
     */
    @Override
    public int insert(int r, int e) {//在r位置中查找e
        for (int i=size;i>r;i--){//在r位置之后的元素依次向后移动一位，后面元素的复制前一位元素
            elem[i] = elem[i-1];
        }
        elem[r] = e;//在r位置插入e元素的值
        return r;
    }
    /**
     * 无序数组删除
     */
    @Override
    public int remove(int lo, int hi) {//在[lo,hi]中删除e
        if (lo == hi){//元素为空
            return 0;
        }
        while (hi < size){//在r位置之后的元素依次向前移动一位，前面元素的复制后一位元素
            elem[lo++] = elem[hi++];
            for (int i:elem
            ) {
                System.out.print(i+" ");//打印每次迭代过程，可注释
            }
            System.out.println();
        }
        for (int in = lo;in <= hi+1;in++){
            elem[in] = 0;//将后面提前位置的位置置为0
        }
        size = lo;//刚好为数组尾元素位置
        System.out.println(size);
        return hi - lo;
    }
    @Override
    public int remove(int r) {
        int e = elem[r];
        remove(r,r+1);
        return e;
    }
    /**
     * 无序数组唯一化
     */
    @Override
    public int deduplicate() {
        int oldsize = size;
        int i = 1;
        while(i<size){
            if ((find(elem[i], 0, i) < 0)) {//每次都从0位置开始查找，查找元素为空则后移
                i++;
            } else {
                remove(i);//发现相同元素删除
            }
        }
        return oldsize-size;
    }
    /**
     * 有序数组唯一化低效版
     */
    @Override
    public int uniquify() {
        int oldelem = size;
        int i=1;
        while(i<size){
            if (elem[i - 1] == elem[i]) {//当前元素和前一位元素相同删除当前元素
                remove(i);
            } else {
                i++;
            }
        }
        return oldelem-size;
    }
    /**
     * 有序唯一化高效版
     */
    @Override
    public int uniquifyh() {
        int i=0,j=0;
        while(++j<size){//找寻下一个不同的元素复制在当前元素后面，最后直接删除后面重复元素空间
            if (elem[i]!=elem[j]){
                elem[i++] = elem[j];
            }
      }
        size = ++i;
        shrink();
        return j-i;
    }
    /**
     * 打印函数
     */
    public void print(){
        for (int i:elem
             ) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
