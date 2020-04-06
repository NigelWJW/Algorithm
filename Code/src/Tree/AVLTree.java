package Tree;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/**
 * AVL树平衡二叉搜索树
 */
public class AVLTree<T extends Comparable<T>> {
    public AVLNode<T> root;
    public int size;

    /**
     * 构造函数
     */
    public AVLTree(){
        root = null;
        size = 0;
    }
    public AVLTree(T[] array){
        creatAVL(array);
        size = 0;
    }
    public void creatAVL(T[] array){
        for (int i = 0;i<array.length;i++){
            System.out.println("no:" + i);
            insert(array[i]);
        }
    }

    /**
     * 插入操作维护AVL树
     */
    public AVLNode<T> insert(AVLNode<T> node,T e){
        if (node == null){
            size++;
            return new AVLNode<T>(e);
        }
        if (e.compareTo(node.data)<0){
            node.lc = insert(node.lc,e);
        }
        else if (e.compareTo(node.data)>0){
            node.rc = insert(node.rc,e);
        }
        else{
            System.out.println("insert error! ");
        }
        updateHeight(node);
        if(!AVLBalanced(node)){
            if (BalFac(node)>=2 && BalFac(node.lc)>=1){//zig
                System.out.println("zig ");
                return rotateRight(node);
            }
            if (BalFac(node)<=-2 && BalFac(node.rc)<=-1){//zag
                System.out.println("zag ");
                return rotateleft(node);
            }
            if (BalFac(node)>=2 && BalFac(node.lc)<=-1){//zigzag
                System.out.println("zagzig ");
                node.lc = rotateleft(node.lc);
                return rotateRight(node);
            }
            if (BalFac(node)<=-2 && BalFac(node.rc)>=1){//zagzig
                System.out.println("zigzag ");
                node.rc = rotateRight(node.rc);
                return rotateleft(node);
            }
        }
        return node;
    }

    public void insert(T data){
        root = insert(root,data);
    }

    /**
     * 删除AVL操作
     */
    public AVLNode<T> remove(AVLNode<T> node,T e){
        AVLNode<T> hot = null;//标记上一层的父节点
        if (node ==null){
            return null;
        }
        if (e.compareTo(node.data)<0){
            node.lc = remove(node.lc,e);
            hot = node;
        }
        else if (e.compareTo(node.data)>0){
            node.rc = remove(node.rc,e);
            hot = node;
        }
        else {//删除当前节点
            if (node.lc == null){
                AVLNode<T> noderc = node.rc;
                node.rc = null;
                size--;
                hot = noderc;
            }
            else if (node.rc == null){
                AVLNode<T> nodelc = node.lc;
                node.lc = null;
                size--;
                hot = nodelc;
            }
            else {//左右子树都不为空
                AVLNode<T> succ = getMin(node.rc);
                node.data = succ.data;
                node.rc = remove(node.rc,node.data);
                hot = node;
            }
        }
        if (hot ==null){
            return null;//删除的是叶节点
        }
        updateHeight(hot);
        if (!AVLBalanced(hot)){
            if (BalFac(hot)>=2 && BalFac(hot.lc)>=1){//zig
                System.out.println("zig ");
                return rotateRight(hot);
            }
            if (BalFac(hot)<=-2 && BalFac(hot.rc)<=-1){//zag
                System.out.println("zag ");
                return rotateleft(hot);
            }
            if (BalFac(hot)>=2 && BalFac(hot.lc)<=-1){//zagzig
                System.out.println("zagzig ");
                hot.lc = rotateleft(hot.lc);
                return rotateRight(hot);
            }
            if (BalFac(hot)<=-2 && BalFac(hot.rc)>=1){//zigzag
                System.out.println("zigzag ");
                hot.rc = rotateRight(hot.rc);
                return rotateleft(hot);
            }
        }
        return hot;
    }
    public void remove(T data){
        root = remove(root,data);
    }


    /**
     * zig右旋转ll
     */
    public AVLNode<T> rotateRight(AVLNode<T> node){
        AVLNode<T> nodelc = node.lc;
        AVLNode<T> nodelcrc = nodelc.rc;

        nodelc.rc = node;
        node.lc = nodelcrc;

        updateHeight(node);
        updateHeight(nodelc);
        return nodelc;
    }

    /**
     * zag左旋转rr
     */
    public AVLNode<T> rotateleft(AVLNode<T> node){
        AVLNode<T> noderc = node.rc;
        AVLNode<T> noderclc = noderc.lc;

        noderc.lc = node;
        node.rc = noderclc;

        updateHeight(node);
        updateHeight(noderc);
        return noderc;
    }

    /**
     * 理想平衡
     */
    public boolean Balanced(AVLNode<T> node){
        return Stature(node.lc) == Stature(node.rc);
    }

    /**
     *平衡因子
     */
    public int BalFac(AVLNode<T> node){
        return Stature(node.lc) - Stature(node.rc);
    }

    /**
     * AVL平衡条件
     */
    public boolean AVLBalanced(AVLNode<T> node){
        return (BalFac(node)<2) && (BalFac(node)>-2);
    }

    /**
     * 更新树高度
     */
    public void updateHeight(AVLNode<T> node){
        node.height = 1 + Math.max(Stature(node.lc), Stature(node.rc));
    }
    public void updateHeightAbove(AVLNode<T> node){
        while (node != null){
            updateHeight(node);
            node = node.parent;
        }
    }
    /**
     *是否为空树
     */
    public boolean isEmpty(){
        return root == null;
    }

    /**
     *获取节点个数
     */
    public int getSize(AVLNode<T> node){
        if (node == null){
            return 0;
        }
        else {
            return getSize(node.lc) + getSize(node.rc) + 1;
        }
    }

    public int getSize(){
        if (root == null){
            return 0;
        }
        return getSize(root);
    }
    /**
     *获取当前高度
     */
    public int Stature(AVLNode<T> node){
        return node == null? -1:node.height;
    }

    public int Stature(){
        if (root == null){
            return -1;
        }
        return Stature(root);
    }

    /**
     *先序遍历递归
     */
    public void preorder(AVLNode<T> node){
        if (node==null){
            return;
        }
        System.out.print(node.data +" ");
        preorder(node.lc);
        preorder(node.rc);
    }

    public void preorder(){
        if (root == null){
            return;
        }
        preorder(root);
    }

    /**
     *中序遍历递归
     */
    public void inorder(AVLNode<T> node){
        if (node==null){
            return;
        }
        preorder(node.lc);
        System.out.println(node.data);
        preorder(node.rc);
    }

    public void inorder(){
        if (root == null){
            return;
        }
        inorder(root);
    }

    /**
     *后序遍历递归
     */
    public void postorder(AVLNode<T> node){
        if (node==null){
            return;
        }
        preorder(node.lc);
        preorder(node.rc);
        System.out.println(node.data);
    }

    public void postorder(){
        if (root == null){
            return;
        }
        postorder(root);
    }

    /**
     *层次遍历迭代
     */
    public void levelorder(AVLNode<T> node){
        Deque<AVLNode<T>> queue = new ArrayDeque<>();
        queue.addLast(node);
        while (!queue.isEmpty()){
            AVLNode<T> temp = queue.removeFirst();
            System.out.println(temp.data);
            if (node.lc != null){
                queue.addLast(node.lc);
            }
            if (node.rc != null){
                queue.addLast(node.rc);
            }
        }
    }
    public void levelorder(){
        if (root == null){
            return;
        }
        levelorder(root);
    }
    /**
     *搜索对应值的节点
     */
    public AVLNode<T> search(AVLNode<T> node, T data){
        if (node == null) throw new NullPointerException();
        if (data.compareTo(node.data)<0){
            return search(node.lc,data);
        }
        else if (data.compareTo(node.data)>0){
            return search(node.rc,data);
        }
        else{
            return node;
        }
    }
    public AVLNode<T> search(T data){
        return search(root,data);
    }
    /**
     *获得树根
     */
    public AVLNode<T> getRoot() {
        return root;
    }
    /**
     *获取最大者
     */
    public T getMax(){
        if (root == null){
            throw new NoSuchElementException();
        }
        return getMax(root).data;
    }
    public AVLNode<T> getMax(AVLNode<T> node){
        if (node.rc == null){
            return node;
        }
        return getMax(node.rc);
    }
    /**
     *获取最小者
     */
    public T getMin(){
        if (root == null){
            throw new NoSuchElementException();
        }
        return (getMin(root)).data;
    }
    public AVLNode<T> getMin(AVLNode<T> node){
        if (node.lc == null){
            return node;
        }
        return getMin(node.lc);
    }
    /**
     *输出AVL二叉树
     */
    public void print(){
        print(root);
    }
    public void print(AVLNode<T> node){
        if (node!=null){
            System.out.print(node.data);
            if (node.lc!=null||node.rc!=null){
                System.out.print("(");
                print(node.lc);
                System.out.print(",");
                print(node.rc);
                System.out.print(")");
            }
        }
    }
}
