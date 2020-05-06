package SeqVector;
/**
 * 顺序表vector的接口
 */
public interface VectorList {
    public void copyfrom(int[] A,int lo,int hi);//拷贝函数
    public void expand();//扩容函数
    public void shrink();//缩容函数
    public int find(int e,int lo,int hi);//查找函数
    public int insert(int r,int e);//插入函数
    public int remove(int lo,int hi);//删除函数
    public int remove(int r);
    public int deduplicate();//无序数组唯一化函数
    public int uniquify();//有序数组唯一化函数
    public int uniquifyh();//有序数组唯一化函数高效版
}
