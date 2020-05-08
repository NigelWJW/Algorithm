package Tree;
/**
 * 二叉树节点类
 */
public class BinaryTreeNode<E> {
    E data;
    BinaryTreeNode<E> lc,rc,parent;
    int height;
    /**
     * 构造函数
     */
    public BinaryTreeNode(){
            lc=null;
            rc=null;
        }
    public BinaryTreeNode(E data){
        lc=null;
        rc=null;
        this.data = data;
    }
    public BinaryTreeNode(E data,BinaryTreeNode<E> lc,BinaryTreeNode<E> rc){
        this.lc=lc;
        this.rc=rc;
        this.data = data;
    }
    @Override
    public String toString() {
        return data+" ";
    }
}
