package Search;

/**
 * 二分查找法版本二，采用二分法，左闭右开区间
 */
public class binSeach2 {
    public int binseach2(int[] A,int e,int lo, int hi){
        while (hi-lo>1){
            int mi = (hi+lo)/2;
            if (e<A[mi]){
                hi=mi;
            }
            else{
                lo = mi;
            }
        }
        return(e==A[lo]?lo:-1);
    }
    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        binSeach2 bs2 = new binSeach2();
        int e = 2;
        System.out.println(bs2.binseach2(array,e,0,9));
    }
}
