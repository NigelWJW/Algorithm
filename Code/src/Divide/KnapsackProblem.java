package Divide;
/**
 * 01�������⶯̬�滮����
 */
public class KnapsackProblem {
        public static void main(String[] args) {
            int[] w = {1, 4, 3};//��Ʒ��������0��ʼ�������
            int[] val = {1500, 3000, 2000}; //��Ʒ�ļ�ֵ ����val[i] ����ǰ�潲��v[i]
            int m = 4; //����������
            int n = val.length; //��Ʒ�ĸ���
            //������ά����v
            //v[i][j] ��ʾ��ǰi����Ʒ���ܹ�װ������Ϊj�ı����е�����ֵ��ǰ��Ʒ���ֵ
            int[][] v = new int[n+1][m+1];
            //Ϊ�˼�¼������Ʒ����������Ƕ�һ����ά����path
            int[][] path = new int[n+1][m+1];

            //��ʼ����һ�к͵�һ��, Ҳ���Բ�ȥ������ΪĬ�Ͼ���0
            for(int i = 0; i < v.length; i++) {
                v[i][0] = 0; //����һ������Ϊ0
            }
            for(int i=0; i < v[0].length; i++) {
                v[0][i] = 0; //����һ������0
            }

            //����ǰ��õ���ʽ����̬�滮����
            for(int i = 1; i < v.length; i++) { //�������һ�� i�Ǵ�1��ʼ��
                for(int j=1; j < v[0].length; j++) {//�������һ��, j�Ǵ�1��ʼ��
                    //���ù�ʽ
                    if(w[i-1]> j) { // ��Ϊ���ǳ���i�Ǵ�1��ʼ�ģ���w��val�Ǵ�0��ʼ��ģ����ԭ����ʽ�е�w[i]�޸ĳ�w[i-1]
                        v[i][j]=v[i-1][j];
                    } else {
                        //˵��:
                        //��Ϊ���ǵ�i��1��ʼ�ģ���˹�ʽ��Ҫ������
                        //v[i][j]=Math.max(v[i-1][j], val[i-1]+v[i-1][j-w[i-1]]);
                        //v[i][j] = Math.max(v[i - 1][j], val[i - 1] + v[i - 1][j - w[i - 1]]);
                        //Ϊ�˼�¼��Ʒ��ŵ���������������ǲ���ֱ�ӵ�ʹ������Ĺ�ʽ����Ҫʹ��if-else�����ֹ�ʽ
                        if((v[i-1][j]) < (val[i-1] + v[i-1][j-w[i-1]])){//�����ǰ��Ʒ�ļ�ֵ����i-1����Ʒ��ʣ������������ֵ֮�ʹ���i-1����Ʒ����ֵ֮��
                            v[i][j] = val[i - 1] + v[i - 1][j - w[i - 1]];
                            //�ѵ�ǰ�������¼��path
                            path[i][j] = 1;
                        } else {
                            v[i][j] = v[i - 1][j];
                        }

                    }
                }
            }

            //���һ��v����ֵ����Ŀǰ�����
            for(int i =0; i < v.length;i++) {
                for(int j = 0; j < v[i].length;j++) {
                    System.out.print(v[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println("============================");
            //�����������Ƿ������Щ��Ʒ
            //����path, �������������еķ���������õ�, ��ʵ����ֻ��Ҫ���ķ���
//		for(int i = 0; i < path.length; i++) {
//			for(int j=0; j < path[i].length; j++) {
//				if(path[i][j] == 1) {
//					System.out.printf("��%d����Ʒ���뵽����\n", i);
//				}
//			}
//		}
            int i = path.length - 1; //�е�����±�
            int j = path[0].length - 1;  //�е�����±�
            while(i > 0 && j > 0 ) { //��path�����ʼ�ң��������
                if(path[i][j] == 1) {
                    System.out.printf("��%d����Ʒ���뵽����\n", i);
                    j -= w[i-1]; //w[i-1]
                }
                i--;
            }
        }
    }

