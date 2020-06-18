package Sort;
/**
 * ѡ�������㷨-��Сֵ����
 */
import java.text.SimpleDateFormat;
import java.util.Date;
public class SelectSort2 {
    //ѡ������
        public static void main(String[] args) {
            //int [] arr = {101, 34, 119, 1, -1, 90, 123};
            //����Ҫ��80000�������������
            int[] arr = new int[80000];
            for (int i = 0; i < 80000; i++) {
                arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
            }
            System.out.println("����ǰ");
            //System.out.println(Arrays.toString(arr));
            Date data1 = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date1Str = simpleDateFormat.format(data1);
            System.out.println("����ǰ��ʱ����=" + date1Str);
            selectSort(arr);

            Date data2 = new Date();
            String date2Str = simpleDateFormat.format(data2);
            System.out.println("����ǰ��ʱ����=" + date2Str);
            //System.out.println("�����");
            //System.out.println(Arrays.toString(arr));
        }

        //ѡ������
        public static void selectSort(int[] arr) {
            //���Ƶ��Ĺ��̣����Ƿ����˹��ɣ���ˣ�����ʹ��for�����
            //ѡ������ʱ�临�Ӷ��� O(n^2)
            for (int i = 0; i < arr.length - 1; i++) {
                int minIndex = i;//����汾�ǰѵ�ǰ���ͱȽ����ֿ�����һ���汾��ֱ�����������Ҳ��ֿ�
                int min = arr[i];
                for (int j = i + 1; j < arr.length; j++) {
                    if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С����¼
                        min = arr[j]; // ����min
                        minIndex = j; // ����minIndex
                    }
                }
                // ����Сֵ������arr[i], ������
                if (minIndex != i) {
                    arr[minIndex] = arr[i];
                    arr[i] = min;
                }
                //System.out.println("��"+(i+1)+"�ֺ�~~");
                //System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
            }
        }
}

