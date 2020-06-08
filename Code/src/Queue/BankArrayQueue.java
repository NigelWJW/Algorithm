package Queue;
import java.util.Scanner;
/**
 * ����ģ�����
 */
public class BankArrayQueue {
    public static void main(String[] args){
        BankArrayQueue bankArrayQueue = new BankArrayQueue(10);
        Scanner scanner = new Scanner(System.in);
        char key = ' ';
        boolean flag = true;
        while (flag){
            System.out.println("s(show): ��ʾ�Ŷ�");
            System.out.println("e(exit): �˳�");
            System.out.println("a(add): �ͻ�����");
            System.out.println("g(get): �ͻ�����");
            System.out.println("h(head): �鿴���ڰ���Ŀͻ�");
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
                    System.out.print("�����");bankArrayQueue.addQueue(scanner.nextInt());break;
                case 'g':
                    try {
                        bankArrayQueue.getQueue();
                    }catch (Exception e){
                        e.printStackTrace(); }
                    break;
                case 'h': //�鿴����ͷ������
                    try {
                        int res = bankArrayQueue.headQueue();
                        System.out.printf("����ͷ��������%d\n", res);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e': //�˳�
                    scanner.close();
                    flag = false;
                    break;
                default:
                    break;
            }
        }
    }

    //������׶�β��
    private int front;
    private int rear;
    private int[] bank;
    private int maxSize;

    public BankArrayQueue(int customSize){
        bank = new int[maxSize =customSize];
        //һ��ʼ��ָ����е�ǰһ��Ԫ��
        front = -1;
        rear = -1;
    }

    public boolean isEmpty(){
        return front == rear;
    }

    public boolean isFull(){
        return rear == maxSize-1;
    }
    //����
    public void addQueue(int e){
        if (isFull()){
            throw new RuntimeException(" �����ˣ� ");
        }
        bank[++rear] = e;
    }
    //��ȡ
    public int getQueue(){
        if(isEmpty()){
            throw new RuntimeException(" û�й˿��ˣ� ");
        }
        return bank[++front];
    }
    //��ӡ����
    public void showQueue() {
        // ����
        if (isEmpty()) {
            System.out.println("���пյģ�û������~~");
            return;
        }
        for (int i = 0; i < bank.length; i++) {
            System.out.printf("arr[%d]=%d\n", i, bank[i]);
        }
    }
    // ��ʾ���е�ͷ���ݣ� ע�ⲻ��ȡ������
    public int headQueue() {
        // �ж�
        if (isEmpty()) {
            throw new RuntimeException("���пյģ�û������~~");
        }
        return bank[front + 1];
    }

}
