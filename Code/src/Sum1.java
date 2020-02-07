/**
 * 数组求和的二分递归法
 */
public class Sum1 {
    private static int sum(int[] Arr,int lo,int hi){
        if (lo == hi){
            return Arr[lo];
        }
        else{
            int mid = (lo+hi)/2;
            return sum(Arr,lo,mid) + sum(Arr,mid+1,hi);
        }
    }
    public static void main(String[] args){
        int[] Arr = new int[]{1,2,3,4,5};
        int lo = 0;
        int hi = Arr.length-1;
        System.out.println(sum(Arr,lo,hi));

    }
}
