package Tree;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * �շ�����
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = { 13, 7, 8, 3, 29, 6, 1 };
        Node root = createHuffmanTree(arr);
        preOrder(root);
    }
    //��дһ����ǰ������ķ���
    public static void preOrder(Node node) {
        if (node == null){
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    // �����շ������ķ���
    /**
     *
     * @param arr ��Ҫ�����ɹ�������������
     * @return �����ú�ĺշ�������root���
     */
    public static Node createHuffmanTree(int[] arr) {
        // ��һ��Ϊ�˲�������
        // 1. ���� arr ����
        // 2. ��arr��ÿ��Ԫ�ع��ɳ�һ��Node
        // 3. ��Node ���뵽ArrayList��
        List<Node> nodes = new ArrayList<Node>();
        for (int value : arr) {
            nodes.add(new Node(value));//�½��ڵ����nodes������
        }
        //���Ǵ���Ĺ�����һ��ѭ���Ĺ���
        while(nodes.size() > 1) {
            //��nodes���Ͻ��м��Ϲ������򣬴�С����
            Collections.sort(nodes);
            System.out.println("nodes =" + nodes);
            //ÿ�ζ�ȡ�����ڵ�Ȩֵ��С�����Ŷ�����
            //(1) ȡ��Ȩֵ��С�Ľ�㣨��������
            Node leftNode = nodes.get(0);
            //(2) ȡ��Ȩֵ�ڶ�С�Ľ�㣨��������
            Node rightNode = nodes.get(1);
            //(3)����һ���µĶ�����
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;
            //(4)��ArrayListɾ��������Ķ�����
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5)���½ڵ�parent���뵽nodes
            nodes.add(parent);
        }
        //���ع���������root���
        return nodes.get(0);
    }
}

// ���������
// Ϊ����Node �����������Collections��������
// ��Node ʵ��Comparable�ӿ�
class Node implements Comparable<Node> {
    int value; // ���Ȩֵ
    char c; //�ַ�
    Node left; // ָ�����ӽ��
    Node right; // ָ�����ӽ��
    //дһ����ǰ�����
    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }
    public Node(int value) {
        this.value = value;
    }
    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }
    @Override
    public int compareTo(Node o) {
        // ��ʾ��С��������
        return this.value - o.value;
    }
}
