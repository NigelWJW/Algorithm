package Search;

/**
 * Fibonacci查找法,使用fibonacci数列的项来代替简单的中间项，减少失败的查找次数，每次都从左查找可局部建立左长右短的查找结构，类似左式堆
 * 构建Fib数列类，其中初始化
 * f=fib(-1)=1,指向前一项
 * g=fib(0)=0，指向当前项
 * 构造类时反复调用next，prev方向相反
 */
class Fib{
    private int f,g;
    public Fib(int n){
        f=1;g=0;
        while(0<n--){
            next();
        }

    }
    public int next(){
        g = g+f;
        f = g-f;
        return g;
    }
    public int get(){
        return g;
    }
    public int prev(){
        f = g-f;
        g = g-f;
        return g;
    }

}

public class fibSearch {
    private int fibsearch(int[] A,int e,int lo,int hi){
        Fib fib = new Fib(hi-lo);
        while(lo<hi){
            //通过向前查找找到合适的fib(k-1)
            while(hi-lo<fib.get()){
                System.out.println("get"+fib.get());
                fib.prev();
//                System.out.println("prev"+fib.prev());
            }
            int mi = lo + fib.get() -1;
            System.out.println("mi"+mi);
            if (e<A[mi]){
                hi = mi;
            }
            else if (e>A[mi]){
                lo = mi+1;
            }
            else return mi;
        }
        return -1;
    }


    public static void main(String[] args){
//        Fib f = new Fib(5);
        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        fibSearch fs = new fibSearch();
        int e = 9;
        System.out.println(fs.fibsearch(array,e,0,9));
    }
}
