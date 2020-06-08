package Queue;
import java.util.Scanner;
/**
 * 循环分配器
 */
public class LoopAllocation {
    public static void main(String[] args) {
        System.out.println("测试数组模拟环形队列的案例~~~");
        // 创建一个环形队列
        LoopAllocation queue = new LoopAllocation(10); //说明设置4, 其队列的有效数据最大是3
        char key = ' '; // 接收用户输入
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // 输出一个菜单
        while (loop) {
            System.out.println("s(show): 显示队列");
            System.out.println("e(exit): 退出程序");
            System.out.println("a(add): 添加数据到队列");
            System.out.println("g(get): 从队列取出数据");
            System.out.println("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);// 接收一个字符
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("输出一个数");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // 取出数据
                    try {
                        int res = queue.getQueue();
                        System.out.printf("取出的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // 查看队列头的数据
                    try {
                        int res = queue.headQueue();
                        System.out.printf("队列头的数据是%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // 退出
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("程序退出~~");
    }

    //定义队首队尾等
    private int front;
    private int rear;
    private int[] allocation;
    private int maxSize;

    public LoopAllocation(int customSize){
        allocation = new int[maxSize =customSize];
        //一开始都指向队列的前一个元素
        front = 0;
        rear = 0;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    //增加
    public void addQueue(int e){
        if (isFull()){
            throw new RuntimeException(" 分配满了！ ");
        }
        allocation[rear] = e;
        rear = (rear + 1) % maxSize;
    }
    //获取
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException(" 没有使用的了！ ");
        }
        int e = allocation[front];
        front = (front+1)%maxSize;
        return e;
    }

    public int getSize(){
        return (rear + maxSize -front) % maxSize;
    }
    // 显示队列的所有数据
    public void showQueue() {
        // 遍历
        if (isEmpty()) {
            System.out.println("队列空的，没有数据~~");
            return;
        }
        // 思路：从front开始遍历，遍历多少个元素
        for (int i = front; i < front + getSize() ; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, allocation[i % maxSize]);
        }
    }
    // 显示队列的头数据， 注意不是取出数据
    public int headQueue() {
        // 判断
        if (isEmpty()) {
            throw new RuntimeException("队列空的，没有数据~~");
        }
        return allocation[front];
    }

}

