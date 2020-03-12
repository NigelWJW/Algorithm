package Introduction;

/**
 * 数组倒序的线性递归版本，Java自动收取垃圾所以没有尾递归版本
 */
public class Reverse {
    private static void swap(int[] arr,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
    private static void reverse(int[] arr,int lo,int hi){
        if(hi > lo){
            swap(arr,lo,hi);
            reverse(arr,++lo,--hi);
        }
        else{
            return;
        }
    }
    public static void main(String[] args){
        int[] arr = new int[]{2,5,1,4,9,3,0};
        int lo = 0;
        int hi = arr.length - 1;
        reverse(arr,lo, hi);
        for (int value : arr) {
            System.out.println(value);
        }

    }



}
