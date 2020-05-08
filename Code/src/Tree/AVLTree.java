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
            node.lc = insert(node.lc,e);//递归进入左子树
        }
        else if (e.compareTo(node.data)>0){
            node.rc = insert(node.rc,e);//递归进入左子树
        }
        else{
            System.out.println("insert error! ");
        }
        updateHeight(node);//因为要使用到高度，先更新
        if(!AVLBalanced(node)){//当出现失衡情况，可以画图查看情况。
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
            node.lc = remove(node.lc,e);//递归进入左子树
            hot = node;
        }
        else if (e.compareTo(node.data)>0){
            node.rc = remove(node.rc,e);//递归进入左子树
            hot = node;
        }
        else {//删除当前节点
            if (node.lc == null){//左子树空，右子树替代上来
                AVLNode<T> noderc = node.rc;
                node.rc = null;
                size--;
                hot = noderc;
            }
            else if (node.rc == null){//右子树空，左子树替代上来
                AVLNode<T> nodelc = node.lc;
                node.lc = null;
                size--;
                hot = nodelc;
            }
            else {//左右子树都不为空，获得右子树中最小者替代数据域，然后删除元最小者的节点
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
        AVLNode<T> nodelc = node.lc;//左孩子
        AVLNode<T> nodelcrc = nodelc.rc;//左孩子的右孩子

        nodelc.rc = node;//重新连接，可以想成夺孙变子
        node.lc = nodelcrc;

        updateHeight(node);
        updateHeight(nodelc);
        return nodelc;
    }
    /**
     * zag左旋转rr
     */
    public AVLNode<T> rotateleft(AVLNode<T> node){
        AVLNode<T> noderc = node.rc;//右孩子
        AVLNode<T> noderclc = noderc.lc;//右孩子的左孩子

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
    }//左右子树高度之差即平衡因子
    /**
     * AVL平衡条件
     */
    public boolean AVLBalanced(AVLNode<T> node){
        return (BalFac(node)<2) && (BalFac(node)>-2);
    }//平衡因子绝对值小于2
    /**
     * 更新树高度
     */
    public void updateHeight(AVLNode<T> node){
        node.height = 1 + Math.max(Stature(node.lc), Stature(node.rc));
    }//当前节点高度为左右子树大者加一
    public void updateHeightAbove(AVLNode<T> node){
        while (node != null){
            updateHeight(node);//迭代更新祖先
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
            return getSize(node.lc) + getSize(node.rc) + 1;//左右节点数加一
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
    public int Stature(AVLNode<T> node){//在每次获取高度之前应该先更新高度，再获取高度
        return node == null? -1:node.height;
    }
    public int Stature(){
        if (root == null){
            return -1;//空子树高度为-1
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
        queue.addLast(node);//根节点先入栈
        while (!queue.isEmpty()){
            AVLNode<T> temp = queue.removeFirst();
            System.out.println(temp.data);
            if (node.lc != null){//左右子树压栈
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
            return search(node.lc,data);//递归进入更左子树
        }
        else if (data.compareTo(node.data)>0){
            return search(node.rc,data);//递归进入更右子树
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
