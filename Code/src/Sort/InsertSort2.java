package Sort;
public class InsertSort2 {
    public void insertSort(int[] array){
        for (int i = 1;i<array.length;i++){
            int temp = array[i];
            int j;
            for (j = i ; j>0 && array[j-1]>temp ; j--){//前面元素大就将值赋给当前元素
                array[j] = array[j-1];
            }
            array[j] = temp;//将temp赋给合适位置
        }
    }
    public void print(int[] A){
        for (int value : A) {
            System.out.print(" " + value);
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] A = {2, 3, 5, 1, 23, 6, 78, 34};
        InsertSort2 is =new InsertSort2();
        is.print(A);
        is.insertSort(A);
        is.print(A);
    }
}
