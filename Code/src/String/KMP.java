package String;
import java.util.Arrays;
/**
 * KMP�㷨����ַ���
 */
public class KMP {
        public static void main(String[] args) {
            String str1 = "BBC ABCDAB ABCDABCDABDE";
            String str2 = "ABCDABD";
            //String str2 = "BBC";
            int[] next = kmpNext("ABCDABD"); //[0, 1, 2, 0]
            System.out.println("next=" + Arrays.toString(next));
            int index = kmpSearch(str1, str2, next);
            System.out.println("index=" + index); // 15��
        }
        //д�����ǵ�kmp�����㷨
        /**
         * @param str1 Դ�ַ���
         * @param str2 �Ӵ�
         * @param next ����ƥ���, ���Ӵ���Ӧ�Ĳ���ƥ���
         * @return �����-1����û��ƥ�䵽�����򷵻ص�һ��ƥ���λ��
         */
        public static int kmpSearch(String str1, String str2, int[] next) {
            //�������� ,iָ���ַ�1��jָ���ַ�2
            for(int i = 0, j = 0; i < str1.length(); i++) {
                //��Ҫ���� str1.charAt(i) ��= str2.charAt(j), ȥ����j�Ĵ�С
                //KMP�㷨���ĵ�, ������֤...
                while( j > 0 && str1.charAt(i) != str2.charAt(j)) {//��Ȼ���
                    j = next[j-1];//ʹ�����ǵ�next��
                }
                if(str1.charAt(i) == str2.charAt(j)) {
                    j++;
                }
                if(j == str2.length()) {//�ҵ��˷��ص�һ��ƥ���λ��
                    return i - j + 1;
                }
            }
            return  -1;
        }
        //��ȡ��һ���ַ���(�Ӵ�) �Ĳ���ƥ��ֵ���Լ����Լ��Ƚ�
        public static  int[] kmpNext(String dest) {
            //����һ��next ���鱣�沿��ƥ��ֵ
            int[] next = new int[dest.length()];
            next[0] = 0; //����ַ����ǳ���Ϊ1 ����ƥ��ֵ����0
            for(int i = 1, j = 0; i < dest.length(); i++) {
                //��dest.charAt(i) != dest.charAt(j) ��������Ҫ��next[j-1]��ȡ�µ�j�����ݲ���ƥ��ֵ��ǰһ��λ��
                //ֱ�����Ƿ�����dest.charAt(i) == dest.charAt(j)�������˳�
                //��ʱkmp�㷨�ĺ��ĵ㣬����ͬ��ʱ��j�ʹ�next���ǰһ��ƥ��仯λ��ȥ�ң�һֱ�ҵ���j=0�˳�ѭ��Ȼ��nextֵ��j����Ϊ0����ƥ��
                while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
                    j = next[j-1];
                }
                //��dest.charAt(i) == dest.charAt(j) ����ʱ������ƥ��ֵ����+1,��λƥ�䣬i�ӵڶ�λ��ʼ�Ƚϣ������ͬ��i.j�������ߣ�j��¼����ƥ��ֵ��Ȼ�󸳸���ǰnext[i]
                if(dest.charAt(i) == dest.charAt(j)) {
                    j++;
                }
                next[i] = j;
            }
            return next;
        }
    }
