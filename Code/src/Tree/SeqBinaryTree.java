package Tree;
import java.util.NoSuchElementException;
/**
 * 顺序存储二叉树
 * @param <T>
 */
public class SeqBinaryTree<T> {
    public final int DEFAULTDEEP = 5;
    public int deep;
    public int capacity;
    public Object[] nodes;
    /**
     *构造函数
     */
    public SeqBinaryTree(){
        this.deep = DEFAULTDEEP;
        nodes = new Object[capacity = (int) Math.pow(2, deep) - 1];
    }
    public SeqBinaryTree(int deep){
        this.deep = deep;
        nodes = new Object[capacity = (int) Math.pow(2, deep) - 1];
    }
    public SeqBinaryTree(int deep,int rootData){
        this.deep = deep;
        nodes = new Object[capacity = (int) Math.pow(2, deep) - 1];
        nodes[0] = rootData;
    }
    /**
     *是否为空树
     */
    public boolean isEmpty(){
        return nodes[0] == null;
    }
    /**
     *获取对应父节点的下标
     */
    public int getParentIndex(int sonIndex){
        if (sonIndex == 0){
            System.out.println("this is a rootnode! ");
        }
        return (sonIndex-1)/2;
    }
    /**
     *增加新节点
     */
    public boolean insert(int parentIndex,T data,boolean left){
        if (data == null){
            throw new NullPointerException();
        }
        if (nodes[parentIndex] == null){
            throw new NoSuchElementException();
        }
        if (left){
            if (nodes[parentIndex*2+1]!=null) return false;//左子树不为空，就赋值
            nodes[parentIndex*2+1] = data;
            return true;
        }
        else{
            if (nodes[parentIndex*2+2]!=null) return false;//右子树不为空，就赋值
            nodes[parentIndex*2+2] = data;
            return true;
        }
    }

    /**
     *删除节点
     */
    public boolean delete(int index){
        if (index>=capacity){
            throw new NullPointerException();
        }
        nodes[index] = null;//将节点置空
        if (index == capacity-1){
            capacity--;
        }
        return true;
    }
    /**
     *寻找对应数据的节点
     */
    public int indexOf(T data) {
        for (int i = 0; i < capacity; i++) {
            if (nodes[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }
    /**
     *获取根节点数据
     */
    public Object getRoot() {
        return  nodes[0];
    }
    public void print(){
        for (int i = 0;i<capacity;i++){
            System.out.print(nodes[i]+" ");
        }
    }

}
