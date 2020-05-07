package Sort;
/**
 * 插入排序算法
 */
public class InsertSort {
    public void insertsort(int[] array){
        for (int i = 1;i<array.length;i++){
            int temp =array[i];//记录当前元素值
            int n =0;
            boolean sorted = false;
            for (int j = i;j>0;j--){//遍历i之前的元素
                if (array[j-1]<temp){//找到合适位置
                    n = j;//记录当前索引号
                    sorted = true;
                    break;
                }
            }
            //处理当前元素比数组元素都小
            if (temp<=array[0]){
                sorted = true;
            }
            if (sorted){//插入元素
                for (int m = i;m>n;m--){
                    array[m] = array[m-1];
                }
                array[n] = temp;
            }
        }
    }
    public void print(int[] A){
        for (int i = 0;i<A.length;i++){
            System.out.print(" "+A[i]);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 1, 23, 6, 78, 34};
        InsertSort is =new InsertSort();
        is.print(A);
        is.insertsort(A);
        is.print(A);
    }


}
