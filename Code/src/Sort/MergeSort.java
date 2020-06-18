package Sort;
/**
 * 归并排序算法
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 4, 5, 8, 7, 0, 2, 3};
        System.out.print("before:  ");
        print(arr);

        mergeSort(arr);

        System.out.print("after:  ");
        print(arr);
    }
    //归并算法
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length <= 1) return;
        mergeSort(arr, 0, arr.length - 1);
    }
    //归并分解算法，递归
    private static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) return;//递归基，结束条件
        int mid = low + ((high - low) >> 1);//中点
        mergeSort(arr, low, mid);//low到mid
        mergeSort(arr, mid+1 ,high);//mid+1到high
        merge(arr, low, mid, high);//合并
        print(arr);
    }
    //合并算法
    private static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[arr.length];//临时数组存放排列好的数组
        int left = low;
        int right = mid + 1;//左右元素组的初始化起点都向右走，右子数列从mid+1开始
        int index = 0;//临时数组的索引
        //(一)
        //先把左右两边(有序)的数据按照规则填充到temp数组
        //直到左右两边的有序序列，有一边处理完毕为止
        while (left <= mid && right <= high) {//当左右子数列都没有超过限制进入
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
            arr[low + i] = temp[i];//将数组传回原数组从low起始开始
        }
    }

    public static void print(int[] arr) {
        if (arr == null)    return;
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
