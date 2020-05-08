package Tree;
/**
 * AVL二叉平衡搜索树节点类
 * @param <E>
 */
public class AVLNode<E extends Comparable<E>> {
    public AVLNode<E> lc,rc,parent;
    public E data;
    public int height;
    /**
     * 构造函数
     */
    public AVLNode(){
        this.lc = null;
        this.rc = null;
        this.parent = null;
        this.data = null;
        this.height = 0;
    }
    public AVLNode(E data){
        this.lc = null;
        this.rc = null;
        this.parent = null;
        this.data = data;
        this.height = 0;
    }
    public AVLNode(AVLNode<E> lc,AVLNode<E> rc,E data){
        this.lc = lc;
        this.rc = rc;
        this.parent = null;
        this.data = data;
        this.height = 0;
    }
    public AVLNode(AVLNode<E> lc,AVLNode<E> rc,E data,int height){
        this.lc = lc;
        this.rc = rc;
        this.parent = null;
        this.data = data;
        this.height = height;
    }
    @Override
    public String toString() {
        return data + " ";
    }
}
