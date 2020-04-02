package Tree;
/**
 * 二叉搜索树测试类
 */
public class BSTTest {
    public static void main(String[] args){
//        Integer[] array = {53,78,65,17,87,9,81,45,23};
        Integer[] array = {36,27,6,58,53,69,40,46,64};
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>(array);
        BinaryTreeNode<Integer> root = bst.getRoot();
        bst.printTree(root);
        System.out.println();
        System.out.println(bst.getMax());
        System.out.println(bst.getMin());
        bst.remove(6);
        bst.printTree(bst.getRoot());
        bst.preorder(root);
        bst.inorder(root);
        bst.postorder(root);
        bst.levelorder();
        bst.preorderstackA();
        bst.preorderstackB();
    }
}
