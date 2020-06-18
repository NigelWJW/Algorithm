package Sort;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
/**
 * ��������
 */
public class RadixSort {
        public static void main(String[] args) {
            int arr[] = { 53, 3, 542, 748, 14, 214};
            System.out.println("����ǰ");
            Date data1 = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String date1Str = simpleDateFormat.format(data1);
            System.out.println("����ǰ��ʱ����=" + date1Str);

            radixSort(arr);

            Date data2 = new Date();
            String date2Str = simpleDateFormat.format(data2);
            System.out.println("����ǰ��ʱ����=" + date2Str);
            System.out.println("��������� " + Arrays.toString(arr));
        }
        //�������򷽷�
        public static void radixSort(int[] arr) {
            //����ǰ����Ƶ����̣����ǿ��Եõ����յĻ����������
            //1. �õ���������������λ��
            int max = arr[0]; //�����һ�����������
            for(int i = 1; i < arr.length; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                }
            }
            //�õ�������Ǽ�λ��
            int maxLength = (max + "").length();
            //����һ����ά���飬��ʾ10��Ͱ, ÿ��Ͱ����һ��һά����
            //˵��
            //1. ��ά�������10��һά����
            //2. Ϊ�˷�ֹ�ڷ�������ʱ�������������ÿ��һά����(Ͱ)����С��Ϊarr.length
            //3. ����������ʹ�ÿռ任ʱ��ľ����㷨
            int[][] bucket = new int[10][arr.length];
            //Ϊ�˼�¼ÿ��Ͱ�У�ʵ�ʴ���˶��ٸ�����,���Ƕ���һ��һά��������¼����Ͱ��ÿ�η�������ݸ���
            //�����������
            //���磺bucketElementCounts[0],��¼�ľ���bucket[0]Ͱ�ķ������ݸ�����Ҳ���ǳ��ִ�����
            int[] bucketElementCounts = new int[10];
            //��������ʹ��ѭ�������봦�����λ�����λ����λ��ѭ�����ٴ�
            for(int i = 0 , n = 1; i < maxLength; i++, n *= 10) {
                //���ÿ��Ԫ�صĶ�Ӧλ������������һ���Ǹ�λ���ڶ�����ʮλ���������ǰ�λ..������
                for(int j = 0; j < arr.length; j++) {
                    //ȡ��ÿ��Ԫ�صĶ�Ӧλ��ֵ��������
                    int digitOfElement = arr[j] / n % 10;
                    //���뵽��Ӧ�ڼ���Ͱ�ĵڼ�����λ��
                    bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[j];
                    bucketElementCounts[digitOfElement]++;//���ݸ�����һ��ָ����һ����λ
                }

                //�������Ͱ��˳��(һά������±�����ȡ�����ݣ�����ԭ������)
                int index = 0;
                //����ÿһͰ������Ͱ�������ݣ����뵽ԭ���飬��������
                for(int k = 0; k < bucketElementCounts.length; k++) {
                    //���Ͱ�У������ݣ����ǲŷ��뵽ԭ����
                    if(bucketElementCounts[k] != 0) {
                        //ѭ����Ͱ����k��Ͱ(����k��һά����)�ļ���Ԫ��, �Ż�arr����
                        for(int l = 0; l < bucketElementCounts[k]; l++) {
                            //ȡ��Ԫ�ط��뵽arr
                            arr[index++] = bucket[k][l];
                        }
                    }
                    //ÿһ���ִ���󣬽�ÿ��k��bucketElementCounts[k]��0 ��������
                    bucketElementCounts[k] = 0;
                }
                //System.out.println("��"+(i+1)+"�֣��Ը�λ�������� arr =" + Arrays.toString(arr));
            }
        }
    }

