package misc;

public class SubtracttheProductandSumofDigitsofanInteger {
    public static void main(String[] args) {
        SubtracttheProductandSumofDigitsofanInteger s=new SubtracttheProductandSumofDigitsofanInteger();
        System.out.println(s.subtractProductAndSum(4421));
    }
    public int subtractProductAndSum(int n) {
        int sum=0;
        int prod= 1;
        while(n>0){
            sum+=n%10;
            prod*=n%10;
            n=n/10;
        }
        return prod-sum;
    }
}
