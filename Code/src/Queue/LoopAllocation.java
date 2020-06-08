package Queue;
import java.util.Scanner;
/**
 * ѭ��������
 */
public class LoopAllocation {
    public static void main(String[] args) {
        System.out.println("��������ģ�⻷�ζ��еİ���~~~");
        // ����һ�����ζ���
        LoopAllocation queue = new LoopAllocation(10); //˵������4, ����е���Ч���������3
        char key = ' '; // �����û�����
        Scanner scanner = new Scanner(System.in);//
        boolean loop = true;
        // ���һ���˵�
        while (loop) {
            System.out.println("s(show): ��ʾ����");
            System.out.println("e(exit): �˳�����");
            System.out.println("a(add): ������ݵ�����");
            System.out.println("g(get): �Ӷ���ȡ������");
            System.out.println("h(head): �鿴����ͷ������");
            key = scanner.next().charAt(0);// ����һ���ַ�
            switch (key) {
                case 's':
                    queue.showQueue();
                    break;
                case 'a':
                    System.out.println("���һ����");
                    int value = scanner.nextInt();
                    queue.addQueue(value);
                    break;
                case 'g': // ȡ������
                    try {
                        int res = queue.getQueue();
                        System.out.printf("ȡ����������%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h': // �鿴����ͷ������
                    try {
                        int res = queue.headQueue();
                        System.out.printf("����ͷ��������%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': // �˳�
                    scanner.close();
                    loop = false;
                    break;
                default:
                    break;
            }
        }
        System.out.println("�����˳�~~");
    }

    //������׶�β��
    private int front;
    private int rear;
    private int[] allocation;
    private int maxSize;

    public LoopAllocation(int customSize){
        allocation = new int[maxSize =customSize];
        //һ��ʼ��ָ����е�ǰһ��Ԫ��
        front = 0;
        rear = 0;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return (rear + 1) % maxSize == front;
    }
    //����
    public void addQueue(int e){
        if (isFull()){
            throw new RuntimeException(" �������ˣ� ");
        }
        allocation[rear] = e;
        rear = (rear + 1) % maxSize;
    }
    //��ȡ
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException(" û��ʹ�õ��ˣ� ");
        }
        int e = allocation[front];
        front = (front+1)%maxSize;
        return e;
    }

    public int getSize(){
        return (rear + maxSize -front) % maxSize;
    }
    // ��ʾ���е���������
    public void showQueue() {
        // ����
        if (isEmpty()) {
            System.out.println("���пյģ�û������~~");
            return;
        }
        // ˼·����front��ʼ�������������ٸ�Ԫ��
        for (int i = front; i < front + getSize() ; i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, allocation[i % maxSize]);
        }
    }
    // ��ʾ���е�ͷ���ݣ� ע�ⲻ��ȡ������
    public int headQueue() {
        // �ж�
        if (isEmpty()) {
            throw new RuntimeException("���пյģ�û������~~");
        }
        return allocation[front];
    }

}

