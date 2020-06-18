package Array;
/**
 *  ϡ�����ʹ��
 */
public class SparseArray {
    public static void main(String[] args){
        //����һ��ԭʼ��ά����
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][4] = 3;
        //���ԭʼ����
        for (int[] row: chessArr
             ) {
            for (int data:row
                 ) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //ת����ϡ������,�ȱ����ж��ٸ�����,�ٱ������ݴ洢
        int sum = 0;
        for (int i = 0;i<11;i++){
            for (int j = 0;j<11;j++){
                if (chessArr[i][j] != 0){
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum+1][3];
        //����ϡ����������м�����
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][3] = sum;
        //������ֵ
        int count = 0;
        for (int i = 0;i<11;i++){
            for (int j = 0;j<11;j++){
                if (chessArr[i][j] != 0){
                    sparseArray[count][0] = i;
                    sparseArray[count][1] = j;
                    sparseArray[count][2] = chessArr[i][j];
                }
            }
        }
        //��ӡϡ�����
        System.out.println();
        for (int i = 0;i<sparseArray.length;i++){
            System.out.printf("%d\t%d\t",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();
        //��ϡ��תԭʼ
        int[][] chessArr1 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1;i<sparseArray.length;i++){
            chessArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //���ԭʼ����
        for (int[] row: chessArr
                ) {
            for (int data:row
                    ) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
