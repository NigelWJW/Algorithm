package Sort;

public class InsertSort2 {
        public void insertsort(int[] array){
        for (int i = 1;i<array.length;i++){
            int temp = array[i];
            int j;
            for (j = i ; j>0 && array[j-1]>temp ; j--){
                array[j] = array[j-1];
            }
            array[j] = temp;

        }
    }

    public void print(int[] A){
        for (int i = 0;i<A.length;i++){
            System.out.print(" "+ A[i]);
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
