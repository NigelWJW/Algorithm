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
            parent =null;
            height=0;
        }

    public BinaryTreeNode(E data){
        lc=null;
        rc=null;
        parent = null;
        height=0;
        this.data = data;
    }

    public BinaryTreeNode(E data,BinaryTreeNode<E> lc,BinaryTreeNode<E> rc){
        this.lc=lc;
        this.rc=rc;
        height=0;
        this.data = data;
    }

    public BinaryTreeNode(E data,BinaryTreeNode<E> lc,BinaryTreeNode<E> rc,BinaryTreeNode<E> parent,int height){
        this.lc=lc;
        this.rc=rc;
        this.parent=parent;
        this.height=height;
        this.data = data;
    }

    /**
     *增加子节点
     */
    public boolean insertAsLc(E data){
        lc = new BinaryTreeNode<E>(data);
        return true;
    }

    public boolean insertAsRc(E data){
        rc = new BinaryTreeNode<E>(data);
        return true;
    }


    @Override
    public String toString() {
        return data+" ";
    }
}
