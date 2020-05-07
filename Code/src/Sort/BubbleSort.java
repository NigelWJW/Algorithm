package Sort;

/**
 * 冒泡排序的消除重复检验版本，使用标志可以提前推出
 */
public class BubbleSort {
    private static void swap(int[] Arr,int a, int b){
        int temp = Arr[a];
        Arr[a] = Arr[b];
        Arr[b] = temp;
    }
    private static void bubblesort(int[] A, int n){
        boolean sorted = false;//先设置未完全排序
        while(!sorted){
            sorted = true;//暂定已排好序
            for (int i = 1;i<n;i++){
                if(A[i-1]>A[i]){
                    swap(A,i-1,i);
                    sorted = false;//当有交换时做未排好序
                }
            }
            n--;//排序上线减一，每趟最高数就位
        }
    }
    public static void main(String[] args){

        int[] Arr = new int[]{5,4,3,2,1};
        bubblesort(Arr,5);
        for (int value : Arr) {
            System.out.println(value);
        }

    }

}
