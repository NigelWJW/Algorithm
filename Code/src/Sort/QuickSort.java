package Sort;
/**
 * ¿ìËÙÅÅĞò
 */
public class QuickSort {
    private static void quicksort(int[] a,int lo,int hi){
        if(lo>hi){
            return;
        }
        int base = a[lo];
        int i = lo,j = hi;
        while(i!=j){
            while(a[j] >=base && i<j){
                j--;
            }
            while(a[i] <= base && i<j){
                i++;
            }
            if(i<j){
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        a[lo] = a[i];
        a[i] = base;
        quicksort(a,lo,i-1);
        quicksort(a,i+1,hi);
    }
    public static void main(String[] args){
        int[] a = new int[]{7,3,9,1,0,3,6,10,2,4};
        quicksort(a,0,a.length-1);
        for(int n : a){
            System.out.print(n + " ");
        }
    }
}
