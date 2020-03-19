package Stack;

/**
 * 顺序栈测试
 */
public class SeqStackTest {
    public static void main(String[] args){
        SeqStack<Integer> ss = new SeqStack<Integer>(10);
        for (int i = 0;i<10;i++){
            ss.push(i);
        }
        ss.print();
        for (int i = 0;i<10;i++){
            ss.pop();
        }
        System.out.println();
        System.out.println(ss.getSize());
        System.out.println(ss.isEmpty());



    }


}
