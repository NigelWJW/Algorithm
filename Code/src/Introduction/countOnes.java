package Introduction;

public class countOnes {
    private int countOnes(int n){
        int ones = 0;
        while(n>0){
            ones += ( 1 & n );
            n >>= 1;
        }
        return ones;
    }
    public static void main(String[] args){
        int n = 441;
        countOnes ao = new countOnes();
        System.out.println(ao.countOnes(n));
    }
}
