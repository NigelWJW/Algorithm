package Tree;
import java.util.*;

public class Trie {

    private Node root;

    private int size;

    private static class Node {
        public boolean isWord;
        public Map<Character, Node> next;

        public Node() {
            next = new TreeMap<>();
        }

        public Node(boolean isWord) {
            this();
            this.isWord = isWord;
        }

    }

    public Trie() {
        root = new Node();
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * �������
     *
     * @param word ����
     */
    public void add(String word) {
        Node current = root;
        char[] cs = word.toCharArray();
        for (char c : cs) {
            Node next = current.next.get(c);
            if (next == null) {
                current.next.put(c, new Node());
            }
            current = current.next.get(c);
        }
        //�����ǰ��node�Ѿ���һ��word������Ҫ���
        if (!current.isWord) {
            size++;
            current.isWord = true;
        }
    }


    /**
     * �Ƿ����ĳ������
     *
     * @param word ����
     * @return ���ڷ���true����֮false
     */
    public boolean contains(String word) {
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            Node node = current.next.get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        //���ֻ���� panda����ʣ���ѯ pan����Ȼ����3����ĸ�����ǲ������ڸõ���
        return current.isWord;
    }


    /**
     * Trie�Ƿ����ĳ��ǰ׺
     *
     * @param prefix ǰ׺
     * @return
     */
    public boolean containsPrefix(String prefix) {
        Node current = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            Node node = current.next.get(c);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return true;
    }


    /*
     * 1�������������һ�����ʵ�ǰ׺��ֻ��Ҫ�Ѹ�word�����һ���ڵ��isWord�ĸĳ�false
     * 2��������ʵ�������ĸ�Ķ�û�ж����֧��ɾ����������
     * 3��������ʵĳ������һ����ĸ����������ĸ�ж����֧��
     */

    /**
     * ɾ������
     *
     * @param word
     * @return
     */
    public boolean remove(String word) {
        Node multiChildNode = null;
        int multiChildNodeIndex = -1;
        Node current = root;
        for (int i = 0; i < word.length(); i++) {
            Node child = current.next.get(word.charAt(i));
            //���Trie��û���������
            if (child == null) {
                return false;
            }
            //��ǰ�ڵ���ӽڵ����1��
            if (child.next.size() > 1) {
                multiChildNodeIndex = i;
                multiChildNode = child;
            }
            current = child;
        }
        //������ʺ��滹���ӽڵ�
        if (current.next.size() > 0) {
            if (current.isWord) {
                current.isWord = false;
                size--;
                return true;
            }
            //�����ڸõ��ʣ��õ���ֻ��ǰ׺
            return false;
        }
        //������ʵ�������ĸ�Ķ�û�ж����֧��ɾ����������
        if (multiChildNodeIndex == -1) {
            root.next.remove(word.charAt(0));
            size--;
            return true;
        }
        //������ʵĳ������һ����ĸ����������ĸ�з�֧
        if (multiChildNodeIndex != word.length() - 1) {
            multiChildNode.next.remove(word.charAt(multiChildNodeIndex + 1));
            size--;
            return true;
        }
        return false;
    }
}


