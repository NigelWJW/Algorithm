package Sort;

/**
 * 二分查找法版本一，即简单的3分法
 */
public class binSearch {
    private int binsearch(int[] A,int e,int lo,int hi){
        while(lo<hi){
            int mi = (lo+hi)/2;
            if (e<A[mi]){
                hi = mi;
            }
            else if (e>A[mi]){
                lo = mi+1;
            }
            else{
                return mi;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        binSearch bs = new binSearch();
        int e = 2;
        System.out.println(bs.binsearch(array,e,0,9));
    }
}
