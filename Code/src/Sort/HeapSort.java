package Sort;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * ������
 */
public class HeapSort {
        public static void main(String[] args) {
            //Ҫ�����������������
            //int arr[] = {4, 6, 8, 5, 9};
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
            heapSort(arr);
            Date data2 = new Date();
            String date2Str = simpleDateFormat.format(data2);
            System.out.println("����ǰ��ʱ����=" + date2Str);
            //System.out.println("�����=" + Arrays.toString(arr));
        }

        //������
        public static void heapSort(int arr[]) {
            int temp = 0;
            System.out.println("������!!");
            //1�����������й�����һ���ѣ���������������ѡ��󶥶ѻ�С����
            //arr.length / 2 -1�ó���ֵ�ǵ�һ����Ҷ�ӽڵ�
            for(int i = arr.length / 2 -1; i >=0; i--) {
                adjustHeap(arr, i, arr.length);
            }

		/*
		 * 2).���Ѷ�Ԫ����ĩβԪ�ؽ����������Ԫ��"��"������ĩ��;
����			3).���µ����ṹ��ʹ������Ѷ��壬Ȼ����������Ѷ�Ԫ���뵱ǰĩβԪ�أ�����ִ�е���+�������裬ֱ��������������
		 */
            for(int j = arr.length-1;j >0; j--) {
                //���Ͻ����ֵ����������ų���
                temp = arr[j];
                arr[j] = arr[0];
                arr[0] = temp;
                adjustHeap(arr, 0, j);//0��ʼ�Ӷ��Ͽ�ʼ������j���ϼ���
            }
            //System.out.println("����=" + Arrays.toString(arr));
        }
        //��һ������(������), ������һ���󶥶�
        /**
         * ���ܣ���ɽ���i��Ӧ�ķ�Ҷ�ӽ����������ɴ󶥶�
         * ����  int arr[] = {4, 6, 8, 5, 9}; => i = 1 => adjustHeap => �õ� {4, 9, 8, 5, 6}
         * ��������ٴε���  adjustHeap ������� i = 0 => �õ� {4, 9, 8, 5, 6} => {9,6,8,5, 4}
         * @param arr ������������
         * @param i ��ʾ��Ҷ�ӽ��������������
         * @param length ��ʾ�Զ��ٸ�Ԫ����Ҫ����������length�����𽥵ļ���
         */
        public  static void adjustHeap(int arr[], int i, int length) {
            int temp = arr[i];//��ȡ����ǰԪ�ص�ֵ����������ʱ����
            //1. k = i * 2 + 1 (k �� i�������ӽ��)
            for(int k = i * 2 + 1; k < length; k = k * 2 + 1) {//length�ǽڵ�������k�����ҵ�ǰ�ڵ����Ҷ�ӽڵ�
                if(k+1 < length && arr[k] < arr[k+1]) { //˵���������������ӽ���ֵС�����ӽ���ֵ���ȱȽ������ֵ�
                    k++; // k ָ�����ӽ��
                }
                if(arr[k] > temp) { //�ٱȽϸ�������ӽ����ڸ����
                    arr[i] = arr[k]; //�ѽϴ��ֵ������ǰ���
                    i = k; //!!! i ָ�� k,����ѭ���Ƚ�
                } else {
                    break;
                }
            }
            //��for ѭ�������������Ѿ�����iΪ�������������ֵ���������(�ֲ�)
            arr[i] = temp;//��tempֵ�ŵ��������λ��
        }
    }

