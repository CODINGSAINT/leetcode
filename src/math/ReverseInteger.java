package math;

//https://leetcode.com/problems/reverse-integer/
//7. Reverse Integer
public class ReverseInteger {
    public int reverse(int x) {
        if (x==0)return x;
        boolean negative=x<0;
        long rev=0;
        x=Math.abs(x);

        while(x>0){
            rev=(10*rev)+x%10;
            x=x/10;
            // System.out.println(rev+"---"+x);
        }
        if(rev>Integer.MAX_VALUE|| rev<Integer.MIN_VALUE) return 0;
        if(negative) rev=rev*-1;
        return (int)rev;

    }
}
