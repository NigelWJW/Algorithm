package Search;

/**
 * 二分查找法版本三，这里似乎会遗漏mi但是不会，因为数学中的不变性
 */
public class binSearch3 {
    public int binsearch3(int[] A,int e,int lo, int hi) {
        while (hi > lo) {
            int mi = (hi + lo) / 2;
            if (e < A[mi]) {
                hi = mi;
            } else {
                lo = mi + 1;
            }
        }
        return --lo;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        binSearch3 bs3 = new binSearch3();
        int e = 2;
        System.out.println(bs3.binsearch3(array,e,0,9));
    }
}
