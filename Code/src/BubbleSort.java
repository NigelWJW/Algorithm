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
        boolean sorted = false;
        while(!sorted){
            sorted = true;
            for (int i = 1;i<n;i++){
                if(A[i-1]>A[i]){
                    swap(A,i-1,i);
                    sorted = false;
                }
            }
            n--;
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
