package Tree;

public class BinListTest {
    public static void main(String[] args){
        LinkedListBinaryTree<Integer> llbs = new LinkedListBinaryTree<Integer>(0);
        BinaryTreeNode<Integer> node1l = llbs.addNode(llbs.root,1,true);
        BinaryTreeNode<Integer> node1r = llbs.addNode(llbs.root,2,false);
        BinaryTreeNode<Integer> node2ll = llbs.addNode(node1l,3,true);
        BinaryTreeNode<Integer> node2lr = llbs.addNode(node1l,4,false);
        BinaryTreeNode<Integer> node2rl = llbs.addNode(node1r,5,true);
        BinaryTreeNode<Integer> node2rr = llbs.addNode(node1r,6,false);

        llbs.preorder(llbs.root);


    }
}
