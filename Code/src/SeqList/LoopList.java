package SeqList;
/**
 * 环形链表-约瑟夫问题
 */
//环形链表创建
class Loop{
    private Node first = null;//指向第一个节点不移动
    public void addNode(int num){//num是总数
        if (num<1){
            System.out.println("data error");
            return;
        }
        Node cur = null;//当前节点
        for (int i = 1;i<num;i++){
            Node newNode = new Node(i);//新节点
            if (i==1){//只有一个节点时
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
    //出圈，startNo是开始编号1开始，Count是数几下从自己开始数，num是节点个数,
    public void countNode(int startNo,int count,int num){
        if (first == null || startNo<1||startNo>num){
            System.out.println("error");
            return;
        }
        //创建辅助指针帮助出圈,指向最后一个节点
        Node helper = first;
        while (true){
            if (helper.getSucc() == first){
                break;
            }
            helper = helper.getSucc();
        }
        //开始报数前先移动到开始报数的地方startNo-1次
        for (int i= 1;i<startNo;i++){
            first = first.getSucc();
            helper = helper.getSucc();
        }
        //报数时同时移动Count-1次，然后出圈
        while(true){
            if (helper == first){//圈中只有一个节点
                break;
            }
            for (int j = 1;j<count;j++){//同时移动count次
                first = first.getSucc();
                helper = helper.getSucc();
            }
            //此时的first的节点出圈,将first指向下一位，然后helper指向first，这样原first就隔离开了被gc回收
            System.out.printf("%d出圈\t",first.getNo());
            first = first.getSucc();
            helper.setSucc(first);
        }
        System.out.printf("最后%d出圈\t",first.getNo());
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

//节点类
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
