package Sort;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ��������-�Ľ���
 */
public class InsertSort3 {
        public static void main(String[] args) {
            //int[] arr = {101, 34, 119, 1, -1, 89};
            // ����Ҫ��80000�������������
            int[] arr = new int[80000];
            for (int i = 0; i < 80000; i++) {
                arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
            }

            System.out.println("��������ǰ");
            Date data1 = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date1Str = simpleDateFormat.format(data1);
            System.out.println("����ǰ��ʱ����=" + date1Str);
            insertSort(arr); //���ò��������㷨

            Date data2 = new Date();
            String date2Str = simpleDateFormat.format(data2);
            System.out.println("����ǰ��ʱ����=" + date2Str);
            //System.out.println(Arrays.toString(arr));
        }
        //��������
        public static void insertSort(int[] arr) {
            int insertVal = 0;
            int insertIndex = 0;
            //ʹ��forѭ�����Ѵ����
            for(int i = 1; i < arr.length; i++) {
                //������������
                insertVal = arr[i];
                insertIndex = i - 1; // ��arr[1]��ǰ����������±ָ꣬���ǰһ��λ�õ�Ԫ��
                // ��insertVal �ҵ������λ��
                // ˵��
                // 1. insertIndex >= 0 ��֤�ڸ�insertVal �Ҳ���λ�ã���Խ��
                // 2. insertVal < arr[insertIndex] �������������û���ҵ�����λ��
                // 3. ����Ҫ�� arr[insertIndex] ����
                while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                    arr[insertIndex + 1] = arr[insertIndex];// arr[insertIndex]
                    insertIndex--;
                }
                // ���˳�whileѭ��ʱ��˵�������λ���ҵ�, insertIndex + 1
                // ��������ⲻ�ˣ�����һ�� debug
                //���������ж��Ƿ���Ҫ��ֵ
                if(insertIndex + 1 != i) {//��Ϊ����whileѭ����ǰ����1������Ҫ�ӻ���
                    arr[insertIndex + 1] = insertVal;
                }
                //System.out.println("��"+i+"�ֲ���");
                //System.out.println(Arrays.toString(arr));
            }
    }

}
