package SeqList;

public class LinkListTest {
    public static void main(String[] args){
        LinkedList<Integer> linklist = new LinkedList<Integer>();
        ListNode<Integer> point = new ListNode<Integer>(5);
        int e = 10;
        Integer l =12;
        linklist.print();

//测试前插法
        for(int i =0;i<10;i++){
            linklist.insertAsPrev(i,i);
        }
        linklist.print();
        linklist.insertAsPrev(15,1);
        linklist.print();

//测试后插法
        for(int i =0;i<10;i++){
            linklist.insertAsSucc(i,i);
        }
        linklist.print();
        linklist.insertAsSucc(0,15);
        linklist.print();

//测试删除节点
        linklist.remove(5);
        linklist.print();


//测试寻找链表元素
        System.out.println(linklist.find(5,9,9));


//测试无序唯一化
        for(int i =0;i<5;i++){
            linklist.insertAsPrev(i,i);
        }
        linklist.print();
        for(int i =5;i<10;i++){
            linklist.insertAsPrev(i-5,i);
        }
        linklist.print();
        System.out.println(linklist.deduplicate());
        linklist.print();

//测试有序唯一化
        for (int i = 0;i<10;i++){
            if (i<3){
                linklist.insertAsPrev(1,i);
            }
            else if (i<7){
                linklist.insertAsPrev(2,i);
            }
            else{
                linklist.insertAsPrev(3,i);
            }
        }
        linklist.print();
        System.out.println(linklist.uniquify());
        linklist.print();


    }
}
