package Sort;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ϣ������-ֱ�Ӳ��뷨�ĸĽ�
 */
public class ShellSort {
        public static void main(String[] args) {
            //int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };
            // ����Ҫ��80000�������������
            int[] arr = new int[8000000];
            for (int i = 0; i < 8000000; i++) {
                arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
            }

            System.out.println("����ǰ");
            Date data1 = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date1Str = simpleDateFormat.format(data1);
            System.out.println("����ǰ��ʱ����=" + date1Str);

            //shellSort(arr); //����ʽ
            shellSort2(arr);//��λ��ʽ

            Date data2 = new Date();
            String date2Str = simpleDateFormat.format(data2);
            System.out.println("����ǰ��ʱ����=" + date2Str);

            //System.out.println(Arrays.toString(arr));
        }
        // ϣ������ʱ�� �����������ڲ���ʱ���ý�����,Ч�ʵ�
        public static void shellSort(int[] arr) {
            int temp = 0;
            int count = 0;
            // ����ǰ����𲽷�����ʹ��ѭ������gap������
            for (int gap = arr.length / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < arr.length; i++) {
                    // �������������е�Ԫ��(��gap�飬ÿ���и�Ԫ��), ����gap
                    for (int j = i - gap; j >= 0; j -= gap) {
                        // �����ǰԪ�ش��ڼ��ϲ�������Ǹ�Ԫ�أ�˵������
                        if (arr[j] > arr[j + gap]) {
                            temp = arr[j];
                            arr[j] = arr[j + gap];
                            arr[j + gap] = temp;
                        }
                    }
                }
                //System.out.println("ϣ�������" + (++count) + "�� =" + Arrays.toString(arr));
            }
        }
        //�Խ���ʽ��ϣ����������Ż�->��λ����Ч�ʸ�
        public static void shellSort2(int[] arr) {
            // ����gap, ���𲽵���С����
            for (int gap = arr.length / 2; gap > 0; gap /= 2) {
                // �ӵ�gap��Ԫ�أ�����������ڵ������ֱ�Ӳ�������
                for (int i = gap; i < arr.length; i++) {
                    int j = i;
                    int temp = arr[j];
                    if (arr[j] < arr[j - gap]) {//ֱ�Ӳ��뷨��˼·
                        while (j - gap >= 0 && temp < arr[j - gap]) {
                            //�ƶ�
                            arr[j] = arr[j-gap];
                            j -= gap;
                        }
                        //���˳�while�󣬾͸�temp�ҵ������λ��
                        arr[j] = temp;
                    }
                }
            }
        }

    }
