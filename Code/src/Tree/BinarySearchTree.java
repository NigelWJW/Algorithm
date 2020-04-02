package Tree;
import java.util.*;
/**
 * 二分搜索树BST实现
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private BinaryTreeNode<T> hot;
    private BinaryTreeNode<T> root;
    private int size;
    /**
     * 构造函数
     */
    public BinarySearchTree(){}
    public BinarySearchTree(T[] array){
        creatBST((array));
    }
    public void creatBST(T[] array){
        for (int i = 0;i<array.length;i++){
            insert(array[i]);
        }
    }
    /**
     *树是否为空
     */
    public boolean isEmpty(){
        return size == 0;
    }
    /**
     *获得树根
     */
    public BinaryTreeNode<T> getRoot() {
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
    public BinaryTreeNode<T> getMax(BinaryTreeNode<T> node){
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
    public BinaryTreeNode<T> getMin(BinaryTreeNode<T> node){
        if (node.lc == null){
            return node;
        }
        return getMin(node.lc);
    }
    /**
     *查找元素
     */
    public BinaryTreeNode<T> find(BinaryTreeNode<T> node,T e){
        BinaryTreeNode<T> temp;
        if (node == null){
            System.out.println("find error! ");
        }
        assert node != null;
        if (e.compareTo(node.data)<0){
            return find(node.lc,e);
        }
        else if (e.compareTo(node.data)>0){
            return find(node.rc,e);
        }
        else {
           temp = node;
           return temp;
        }
    }
    /**
     *插入元素
     */
    public void insert(T e){
        root = insert(root,e);
    }
    public BinaryTreeNode<T> insert(BinaryTreeNode<T> node,T e){
        if (node ==null){
            size++;
            return new BinaryTreeNode<T>(e);
        }
        if (e.compareTo(node.data)<0){
            node.lc = insert(node.lc,e);
        }
        else if (e.compareTo(node.data)>0){
            node.rc = insert(node.rc,e);
        }
        else {
            System.out.println("insert error! ");
        }
        return node;
    }
    /**
     *删除元素
     */
    public void remove(T e){
        root = remove(root,e);
    }
    public BinaryTreeNode<T> remove(BinaryTreeNode<T> node,T e){
        BinaryTreeNode<T> temp;
        if (node == null){
            return null;
        }
        if (e.compareTo(node.data)<0){
            node.lc = remove(node.lc,e);
        }
        else if (e.compareTo(node.data)>0){
            node.rc = remove(node.rc,e);
        }
        else {
            if (node.lc == null){
                temp = node.rc;
                node.rc = null;
                node = temp;
                size--;
            }
            else if (node.rc ==null){
                temp =node.lc;
                node.lc = null;
                node = temp;
                size--;
            }
            else{
               temp = getMin(node.rc);
               node.data = temp.data;
               node.rc = remove(node.rc,node.data);
            }
        }
        return node;
    }
    /**
     *先序遍历递归版
     */
    public void preorder(BinaryTreeNode<T> node){
        if (node == null){
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
            return;
        }
        inorder(node.lc);
        System.out.println(node.data);
        inorder(node.rc);
    }

    /**
     *后序遍历递归版
     */
    public void postorder(BinaryTreeNode<T> node){
        if (node == null){
            return;
        }
        preorder(node.lc);
        preorder(node.rc);
        System.out.println(node.data);
    }

    /**
     * 层次遍历迭代版
     */
    public void levelorder(){
        if (root == null){
            return;
        }
        Deque<BinaryTreeNode<T>> queue = new ArrayDeque<>();
        queue.addLast(root);
        while (!queue.isEmpty()){
            BinaryTreeNode<T> node = queue.removeFirst();
            System.out.println(node.data);
            if (node.lc != null){
                queue.addLast(node.lc);
            }
            if (node.rc != null){
                queue.addLast(node.rc);
            }
        }
    }
    /**
     * 先序遍历迭代A版
     */
    public void preorderstackA(){
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.add(root);
        BinaryTreeNode<T> temp = stack.pop();
        while(true){
            while (temp != null){
                System.out.println(temp.data);
                stack.push(temp.rc);
                temp = temp.lc;
            }
            if (stack.empty()) break;
            temp = stack.pop();
        }
    }

    /**
     * 先序遍历迭代B版
     */
    public void preorderstackB(){
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode<T>> stack = new Stack<>();
        stack.add(root);
        while(!stack.isEmpty()){
            BinaryTreeNode<T> temp = stack.pop();
            System.out.println(temp.data);
            if (temp.rc != null){
                stack.push(temp.rc);
            }
            if (temp.lc != null){
                stack.push(temp.lc);
            }
        }
    }

    /**
     *输出二叉树
     */
    public void printTree(BinaryTreeNode<T> node) {
        if (node != null) {
            System.out.print(node.data);
            if (node.lc != null || node.rc != null) {
                System.out.print("(");
                printTree(node.lc);
                System.out.print(",");
                printTree(node.rc);
                System.out.print(")");
            }
        }
    }



}
