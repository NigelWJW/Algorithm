package String;
/**
 * ����ƥ���ַ���
 */
public class ViolenceMatch {
        public static void main(String[] args) {
            //���Ա���ƥ���㷨
            String str1 = "�����ƽ������ƽⱩ���ַ����鱩������";
            String str2 = "��������";
            int index = violenceMatch(str1, str2);
            System.out.println("index=" + index);
        }
        // ����ƥ���㷨ʵ��
        public static int violenceMatch(String str1, String str2) {
            char[] s1 = str1.toCharArray();//�ַ�ת����
            char[] s2 = str2.toCharArray();
            int s1Len = s1.length;//��ó���
            int s2Len = s2.length;
            int i = 0; // i����ָ��s1
            int j = 0; // j����ָ��s2
            while (i < s1Len && j < s2Len) {// ��֤ƥ��ʱ����Խ��
                if(s1[i] == s2[j]) {//ƥ��ok
                    i++;
                    j++;
                } else { //û��ƥ��ɹ�
                    //���ʧ�䣨��str1[i]! = str2[j]������i = i - (j - 1)��j = 0���ص�ƥ��֮ǰ����һλ����
                    i = i - (j - 1);
                    j = 0;
                }
            }
            //�ж��Ƿ�ƥ��ɹ�������ƥ���ַ����ĵ�һλ����
            if(j == s2Len) {//j�����յ�
                return i - j;
            } else {
                return -1;
            }
        }
    }

