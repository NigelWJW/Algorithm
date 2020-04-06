package Tree;

/**
 * AVL树测试类
 */
public class AVLTest {
    public static void main(String[] args){
        Integer[] array = {3,2,1,4,5,6,7,16,15,14,13,12,11,10,8,9};
        AVLTree<Integer> avlTree = new AVLTree<Integer>(array);
        AVLNode<Integer> root = avlTree.getRoot();
        System.out.println();
        System.out.println(root);
        System.out.println(avlTree.getSize());
        System.out.println();
        avlTree.print(root);
        System.out.println();
        avlTree.remove(7);//删除根节点测试
        avlTree.print(root);
    }
}
