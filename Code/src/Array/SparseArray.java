package Array;
/**
 *  稀疏矩阵使用
 */
public class SparseArray {
    public static void main(String[] args){
        //定义一个原始二维数组
        int[][] chessArr = new int[11][11];
        chessArr[1][2] = 1;
        chessArr[2][3] = 2;
        chessArr[3][4] = 3;
        //输出原始数组
        for (int[] row: chessArr
             ) {
            for (int data:row
                 ) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //转换成稀疏数组,先遍历有多少个数据,再遍历数据存储
        int sum = 0;
        for (int i = 0;i<11;i++){
            for (int j = 0;j<11;j++){
                if (chessArr[i][j] != 0){
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum+1][3];
        //定义稀疏数组的行列及个数
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][3] = sum;
        //遍历赋值
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
        //打印稀疏矩阵
        System.out.println();
        for (int i = 0;i<sparseArray.length;i++){
            System.out.printf("%d\t%d\t",sparseArray[i][0],sparseArray[i][1],sparseArray[i][2]);
        }
        System.out.println();
        //将稀疏转原始
        int[][] chessArr1 = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1;i<sparseArray.length;i++){
            chessArr[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        //输出原始数组
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
