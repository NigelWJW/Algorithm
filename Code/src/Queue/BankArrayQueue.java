package Queue;
import java.util.Scanner;
/**
 * 银行模拟服务
 */
public class BankArrayQueue {
    public static void main(String[] args){
        BankArrayQueue bankArrayQueue = new BankArrayQueue(10);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean flag = true;
        while (flag){
            System.out.println("s(show): 显示排队");
            System.out.println("e(exit): 退出");
            System.out.println("a(add): 客户进来");
            System.out.println("g(get): 客户办完");
            System.out.println("h(head): 查看正在办理的客户");
            key = scanner.next().charAt(0);
            switch (key){
                case 's':
                    try {
                        bankArrayQueue.showQueue();
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    break;
                case 'a':
                    System.out.print("请进！");bankArrayQueue.addQueue(scanner.nextInt());break;
                case 'g':
                    try {
                        bankArrayQueue.getQueue();
                    }catch (Exception e){
                        e.printStackTrace(); }
                    break;
                case 'h': //查看队列头的数据
                    try {
                        int res = bankArrayQueue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //退出
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    //定义队首队尾等
    private int front;
    private int rear;
    private int[] bank;
    private int maxSize;

    public BankArrayQueue(int customSize){
        bank = new int[maxSize =customSize];
        //一开始都指向队列的前一个元素
        front = -1;
        rear = -1;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }
    //增加
    public void addQueue(int e){
        if (isFull()){
            throw new RuntimeException(" 人满了！ ");
        }
        bank[++rear] = e;
    }
    //获取
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException(" 没有顾客了！ ");
        }
        return bank[++front];
    }
    //打印队列
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, bank[i]);
        }
    }
    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return bank[front + 1];
    }

}
