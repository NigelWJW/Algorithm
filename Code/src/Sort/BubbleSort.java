package Sort;
/**
 * 冒泡排序的标识法消除重复检验版本，使用标志可以提前推出
 */
public class BubbleSort {
    //交换函数
    private static void swap(int[] Arr,int a, int b){
        int temp = Arr[a];
        Arr[a] = Arr[b];
        Arr[b] = temp;
    }
    //冒泡算法
    private static void bubbleSort(int[] A, int n){
        boolean sorted = false;//先设置未完全排序
        while(!sorted){//sorted为假时进入
            sorted = true;//暂定已排好序
            for (int i = 1;i<n;i++){//从第二个开始比较上一个数，相邻的比较
                if(A[i-1]>A[i]){
                    swap(A,i-1,i);
                    sorted = false;//当有交换时做未排好序
                }
            }
            n--;//一，每趟最最大者已就位，上线减一
        }
    }
    public static void main(String[] args){
        int[] Arr = new int[]{5,4,3,2,1};
        bubbleSort(Arr,5);
        for (int value : Arr) {
            System.out.println(value);
        }
    }
}
