package Sort;
/**
 * 归并排序算法
 */
public class mergeSort {
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }
    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;
        int mid = low + ((high - low) >> 1);
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1 ,high);
        merge(arr, low, mid, high);//合并
        print(arr);
    }
    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];//临时数组存放排列好的数组
        int left = low;
        int right = mid + 1;//分割点
        int index = 0;

        while (left <= mid && right <= high) {
            if (arr[left] < arr[right]) {//大的数放入临时数组中
                temp[index++] = arr[left++];
            } else {
                temp[index++] = arr[right++];
            }
        }
        while (left <= mid) {//当右边没有数了
            temp[index++] = arr[left++];
        }
        while (right <= high) {//当左边没有数了
            temp[index++] = arr[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[low + i] = temp[i];
        }
    }
    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 4, 5, 8, 7, 0, 2, 3};
        System.out.print("before:  ");
        print(arr);
        mergeSort(arr);
        System.out.print("after:  ");
        print(arr);
    }
    public static void print(int[] arr) {
        if (arr == null)    return;
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
