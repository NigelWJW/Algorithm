package Sort;

/**
 * 选择排序算法
 */
public class SelectSort {
    public void selectsort(int[] array){
        //i可看做哨兵
        for (int i = array.length;i>0;i--){
            int index = getMax(array,i);//选出最大值
            swap(array,index,i-1);//与未排好序的最后一个元素换位
        }
    }

    public int getMax(int[] array,int hi){
        int temp = array[0];
        int index = 0;
        for (int i = 1;i < hi;i++){
            if (array[i] > temp){
                temp = array[i];
                index = i;
            }
        }
        return index;
    }

    public void swap(int[] array,int lo,int hi){
        int temp = array[lo];
        array[lo] = array[hi];
        array[hi] = temp;
    }

    public void print(int[] array){
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }

    public static void main(String[] args){
        int[] array = {6,5,1,7,8,3,4,2};
        SelectSort ss = new SelectSort();
        ss.print(array);
        ss.selectsort(array);
        ss.print(array);
    }
}
