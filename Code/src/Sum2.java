public class Sum2 {
    private static int sum(int n){
        int total = 1;
        for (int i = 2;i<=n;i++){
            total*= i;
        }
        System.out.println(total);
        return total;
    }
    public static void main(String[] args){
        int n =5;
        sum(n);
    }
}
