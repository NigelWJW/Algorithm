package SeqVector;

public class Vector implements VectorList{
    final int DEFAULTSIZE = 20;
    int rank;
    int capacity;
    int size;
    int[] elem;


    /**
     * 初始化数组
     */
    public Vector(){
        capacity = DEFAULTSIZE;
        elem = new int[capacity];
        size = 0;
    }

    public Vector(int[] A,int n){
        copyfrom(A,0,n);
    }

    public Vector(int[] A,int lo,int hi){
        copyfrom(A,lo,hi);
    }


    /**
     * 复制构造函数
     */
    @Override
    public void copyfrom(int[] A, int lo, int hi) {
        elem = new int[ capacity= 2*(lo+hi)];
        size = 0;
        while(lo<hi){
            elem[lo++] = A[lo++];
        }
    }


    /**
     * 扩容操作
     */
    @Override
    public void expand() {
        if (size>capacity) return;
        if (capacity<DEFAULTSIZE) capacity = DEFAULTSIZE;
        int[] oldelem = elem;
        elem = new int[capacity<<1];
        for (int i=0;i<size;i++){
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
        elem = new int[capacity>>1];
        for (int i=0;i<size;i++){
            elem[i] = oldelem[i];
        }
    }

    /**
     * 数组无序顺序查找
     */

    @Override
    public int find(int e, int lo, int hi) {
        for (int i = lo;i<=hi;i++){
            if (e == elem[i]){
                return i;
            }
        }
        return -1;
    }

    /**
     * 数组插入
     */
    @Override
    public int insert(int r, int e) {
        for (int i=size;i>r;i--){
            elem[i] = elem[i-1];
        }
        elem[r] = e;
        return r;
    }

    /**
     * 数组删除
     */
    @Override
    public int remove(int lo, int hi) {
        if (lo == hi){
            return 0;
        }
        while (hi < size){
            elem[lo++] = elem[hi++];
            for (int i:elem
            ) {
                System.out.print(i+" ");
            }
            System.out.println();
        }
        for (int in = lo+1;in<=hi;in++){
            elem[in] = 0;
        }
        size = lo;

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
     * 无序唯一化
     */
    @Override
    public int deduplicate() {
        int oldsize = size;
        int i = 1;
        while(i<size){
            if ((find(elem[i], 0, i) < 0)) {
                i++;
            } else {
                remove(i);
            }
        }
        return oldsize-size;
    }

    /**
     * 有序唯一化低效版
     */

    @Override
    public int uniquify() {
        int oldelem = size;
        int i=1;
        while(i<size){
            if (elem[i - 1] == elem[i]) {
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
        while(++j<size){
            if (elem[i]!=elem[j]){
                elem[i++] = elem[j];
            }
      }
        size = ++i;
        shrink();
        return j-i;
    }


    public void print(int[] A){
        for (int i:A
             ) {
            System.out.print(i+" ");
        }
        System.out.println();
    }


}
