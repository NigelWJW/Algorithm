package Tree;
import java.util.ArrayDeque;
import java.util.Deque;

/**
 *二叉树链表类
 */
public class LinkedListBinaryTree<T> {
    public BinaryTreeNode<T> root;
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
        if (p == null){
            return -1;
        }
        else {
            return p.height;
        }
    }

    /**
     *更新高度
     */
    public int updataHeight(BinaryTreeNode<T> x){
        return x.height = 1 +  (Math.max(stature(x.lc), stature(x.rc)));
    }

    public void updataHeightAbove(BinaryTreeNode<T> x){
        while (x!=null){
            x.height = updataHeight(x);
            x=x.parent;
        }
    }

    public boolean insertAsRoot(T data){
        size = 1;
        root = new BinaryTreeNode<T>(data);
        return true;
    }

    public boolean insertAsLeft(BinaryTreeNode<T> x,T data){
        size++;
        x.insertAsLc(data);
        updataHeightAbove(x);
        return true;
    }

    public boolean insertAsRight(BinaryTreeNode<T> x,T data){
        size++;
        x.insertAsRc(data);
        updataHeightAbove(x);
        return true;
    }

    /**
     *先序遍历
     */
    public void preorder(BinaryTreeNode<T> node){
        if (node == null){
            System.out.println("节点为空！ ");
        }
        assert node != null;
        System.out.println(node.data);
        preorder(node.lc);
        preorder(node.rc);
    }

    /**
     *中序遍历
     */
    public void inorder(BinaryTreeNode<T> node){
        if (node == null){
            System.out.println("节点为空！ ");
        }
        assert node != null;
        preorder(node.lc);
        System.out.println(node.data);
        preorder(node.rc);
    }

    /**
     *后序遍历
     */
    public void postorder(BinaryTreeNode<T> node){
        if (node == null){
            System.out.println("节点为空！ ");
        }
        assert node != null;
        preorder(node.lc);
        preorder(node.rc);
        System.out.println(node.data);
    }

    /**
     *广度遍历
     */
    public void levelorder(){
        if (root ==null){
            System.out.println("出错啦 ");
        }
        Deque<BinaryTreeNode<T>> Q = new ArrayDeque<>();
        Q.addLast(root);
        while (!Q.isEmpty()){
            BinaryTreeNode<T> node  = Q.removeFirst();
            System.out.println(node.data);
            if (node.lc!=null){
                Q.addLast(node.lc);
            }
            if (node.rc!=null){
                Q.addLast(node.rc);
            }
        }
    }
}
