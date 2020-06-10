package SeqList;
/**
 * ��������-Լɪ������
 */
//����������
class Loop{
    private Node first = null;//ָ���һ���ڵ㲻�ƶ�
    public void addNode(int num){//num������
        if (num<1){
            System.out.println("data error");
            return;
        }
        Node cur = null;//��ǰ�ڵ�
        for (int i = 1;i<num;i++){
            Node newNode = new Node(i);//�½ڵ�
            if (i==1){//ֻ��һ���ڵ�ʱ
                first = newNode;
                first.setSucc(first);
                cur = first;
            }else {
                cur.setSucc(newNode);
                newNode.setSucc(first);
                cur = newNode;
            }

        }
    }
    public void showNode(){
        if (first == null){
            return;
        }
        Node cur = first;
        while (true){
            System.out.println(cur.getNo());
            if (cur.getSucc() == first){
                break;
            }
            cur = cur.getSucc();
        }
    }
    //��Ȧ��startNo�ǿ�ʼ���1��ʼ��Count�������´��Լ���ʼ����num�ǽڵ����,
    public void countNode(int startNo,int count,int num){
        if (first == null || startNo<1||startNo>num){
            System.out.println("error");
            return;
        }
        //��������ָ�������Ȧ,ָ�����һ���ڵ�
        Node helper = first;
        while (true){
            if (helper.getSucc() == first){
                break;
            }
            helper = helper.getSucc();
        }
        //��ʼ����ǰ���ƶ�����ʼ�����ĵط�startNo-1��
        for (int i= 1;i<startNo;i++){
            first = first.getSucc();
            helper = helper.getSucc();
        }
        //����ʱͬʱ�ƶ�Count-1�Σ�Ȼ���Ȧ
        while(true){
            if (helper == first){//Ȧ��ֻ��һ���ڵ�
                break;
            }
            for (int j = 1;j<count;j++){//ͬʱ�ƶ�count��
                first = first.getSucc();
                helper = helper.getSucc();
            }
            //��ʱ��first�Ľڵ��Ȧ,��firstָ����һλ��Ȼ��helperָ��first������ԭfirst�͸��뿪�˱�gc����
            System.out.printf("%d��Ȧ\t",first.getNo());
            first = first.getSucc();
            helper.setSucc(first);
        }
        System.out.printf("���%d��Ȧ\t",first.getNo());
    }
}
public class LoopList {
    public static void main(String[] args){
        Loop loop = new Loop();
        loop.addNode(5);
        loop.showNode();
        loop.countNode(1,2,5);
    }
}

//�ڵ���
class Node{
    private int no;
    private Node succ;
    public Node(){ }
    public Node(int no){
        this.no = no;
    }
    public int getNo() {
        return no;
    }
    public void setNo(int no) {
        this.no = no;
    }

    public Node getSucc() {
        return succ;
    }

    public void setSucc(Node succ) {
        this.succ = succ;
    }
}
