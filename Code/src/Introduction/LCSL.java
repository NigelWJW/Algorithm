package Introduction; /**
 * 动态规划最长子序列LCS
 */

import java.util.*;
public class LCSL {
    private static void LCSLength(int m,int n,char[] x,char[] y,int[][] c,int[][] b){
        int i,j;
        for (i = 1;i<=m;i++){
            c[i][0] = 0;
        }
        for (j = 1;j<=n;j++){
            c[0][j] = 0;
        }
        for (i = 1;i<=m;i++){
            for (j = 1; j<n;j++){
                if (x[i] == y[j]){
                    c[i][j] = c[i-1][j-1] + 1;
                    b[i][j] = 1;
                }
                else if (c[i-1][j]>=c[i][j-1]){
                    c[i][j] = c[i-1][j];
                    b[i][j] = 2;
                }
                else{
                    c[i][j] = c[i][j-1];
                    b[i][j] = 3;
                }
            }
        }
    }
    private static void LCS(int i,int j,char[] x,int[][] b){
        if (i == 0||j == 0){
            return;
        }
        if (b[i][j] == 1){
            LCS(i-1,j-1,x,b);
            System.out.println(x[i]);
        }
        else if (b[i][j] == 2){
            LCS(i-1,j,x,b);
        }
        else{
            LCS(i,j-1,x,b);
        }
    }

    private static char[] x = new char[100];
    private static char[] y = new char[100];
    private static int[][] b = new int[100][100];
    private static int[][] c = new int[100][100];
    private int t = 0;

    public static void main(String[] args){
            Scanner sc=new Scanner(System.in);
            System.out.println("输入序列1、2的长度：");
            int m=sc.nextInt();
            int n=sc.nextInt();
            System.out.println("输入俩个序列");
            System.out.println("1：");
            for(int i=1;i<=m;i++) {
                x[i]=sc.next().charAt(0);
            }
            System.out.println("2：");
            for(int i=1;i<=n;i++) {
                y[i]=sc.next().charAt(0);
            }
            LCSLength( m, n, x, y, c, b);
            System.out.println("最长公共子序列为：");
            LCS(m, n, x, b);
    }






}
