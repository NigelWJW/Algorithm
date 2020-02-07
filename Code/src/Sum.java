/**
 * 数组求和的线性递归版本
 */
public class Sum {
    private static int sum(int[] arr,int n){
        if(n<1){
            return 0;
        }
        else{
            return sum(arr,n-1) + arr[n-1];
        }
    }

    public static void main(String[] args){
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
        int n = 5;
        System.out.println(sum(arr,n));

    }
}
