package Tree;
/**
 * 顺序存储二叉树测试
 */
public class SeqBinaryTreeTest {
    public static void main(String[] args){
        SeqBinaryTree<Integer> sbt = new SeqBinaryTree<Integer>(4,1);
        boolean flag = true;
        sbt.print();
        for (int i = 1;i<15;i++){
            sbt.insert(sbt.getParentIndex(i),i,flag);
            flag = !flag;
        }
        System.out.println();
        sbt.print();


    }
}
