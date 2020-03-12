package SeqVector;

/**
 * 线性表vector的模板接口
 */
public interface VectorList {

    public void copyfrom(int[] A,int lo,int hi);
    public void expand();
    public void shrink();
    public int find(int e,int lo,int hi);
    public int insert(int r,int e);
    public int remove(int lo,int hi);
    public int remove(int r);
    public int deduplicate();
    public int uniquify();
    public int uniquifyh();



}
