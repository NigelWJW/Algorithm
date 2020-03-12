package Introduction;

/**
 * 动态规划
 */
public class Fibonacci1 {
    private static int fib(int n){
        int f = 1;
        int g = 1;
        while(--n>0){
            g = g + f;
            f = g - f;
        }
        return g;
    }
    public static void main(String[] args){
        int n = 3;
        System.out.println(fib(n));
    }
}

