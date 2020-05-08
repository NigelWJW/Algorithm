package Tree;
import java.util.ArrayDeque;
import java.util.Deque;
/**
 *二叉树链表类
 */
public class LinkedListBinaryTree<T> {
    public BinaryTreeNode<T> root;//根节点
    public int size;
    /**
     * 构造函数
     */
    public LinkedListBinaryTree(){
        this.root = new BinaryTreeNode<T>();
        size = 1;
    }
    public LinkedListBinaryTree(T data){
        this.root = new BinaryTreeNode<T>(data);
        size = 1;
    }
    public LinkedListBinaryTree(T data,BinaryTreeNode<T> lc,BinaryTreeNode<T> rc){
        this.root = new BinaryTreeNode<T>(data,lc,rc);
        size = 1;
    }
    /**
     *判断是否为空
     */
    public boolean isEmpty(){
        return root.data == null;
    }
    public BinaryTreeNode<T> getRoot() {
        return root;
    }
    /**
     *获得左右子节点数据
     */
    public T getLc(BinaryTreeNode<T> parent){
        return parent ==null? null:parent.lc.data;
    }
    public T getRc(BinaryTreeNode<T> parent){
        return parent ==null? null:parent.rc.data;
    }
    /**
     *获得高度
     */
    public int stature(BinaryTreeNode<T> p){
        if (p == null){//空节点高度是-1
            return -1;
        }
        else {
            return p.height;
        }
    }
    /**
     *更新高度
     */
    public int updataHeight(BinaryTreeNode<T> x){//该节点高度是左右子树最大值加一
        return x.height = 1 +  (Math.max(stature(x.lc), stature(x.rc)));
    }
    public void updataHeightAbove(BinaryTreeNode<T> x){
        while (x!=null){
            x.height = updataHeight(x);//依次向上更新
            x=x.parent;
        }
    }
    /**
     *添加节点
     */
    public boolean insertAsRoot(T data){
        size = 1;
        root = new BinaryTreeNode<T>(data);
        return true;
    }
    public BinaryTreeNode<T> addNode( BinaryTreeNode<T> parent, T data, boolean left) {
        if (data == null) {
            throw new NullPointerException();
        }
        if (parent == null) {
            throw new IllegalStateException("节点为null，不能添加子节点");
        }
        if (left && parent.lc != null) {
            throw new IllegalStateException(parent + "节点已经存在左节点");
        }
        if (!left && parent.rc != null) {
            throw new IllegalStateException(parent + "节点已经存在右节点");
        }
        BinaryTreeNode<T> node = new BinaryTreeNode<T>(data);
        if (left) {//直接连接上即可
            parent.lc = node;
            size++;
        } else {
            parent.rc = node;
        }
        return node;
    }
    /**
     *先序遍历递归版
     */
    public void preorder(BinaryTreeNode<T> node){
        if (node == null){
            System.out.println("节点为空！ ");
            return;
        }
        System.out.println(node.data);
        preorder(node.lc);
        preorder(node.rc);
    }
    /**
     *中序遍历递归版
     */
    public void inorder(BinaryTreeNode<T> node){
        if (node == null){
            System.out.println("节点为空！ ");
            return;
        }
        preorder(node.lc);
        System.out.println(node.data);
        preorder(node.rc);
    }
    /**
     *后序遍历递归版
     */
    public void postorder(BinaryTreeNode<T> node){
        if (node == null){
            System.out.println("节点为空！ ");
            return;
        }
        preorder(node.lc);
        preorder(node.rc);
        System.out.println(node.data);
    }
    /**
     *广度遍历队列实现
     */
    public void levelorder(){
        if (root ==null){
            System.out.println("出错啦 ");
            return;
        }
        Deque<BinaryTreeNode<T>> Q = new ArrayDeque<>();
        Q.addLast(root);//根节点先入队
        while (!Q.isEmpty()){//当队列不为空
            BinaryTreeNode<T> node  = Q.removeFirst();
            System.out.println(node.data);
            if (node.lc!=null){//左右子树有就入队
                Q.addLast(node.lc);
            }
            if (node.rc!=null){
                Q.addLast(node.rc);
            }
        }
    }

}
