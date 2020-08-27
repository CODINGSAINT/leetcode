package string;

public class SplitaStringinBalancedStrings {
    public static void main(String[] args) {

    }
    public int balancedStringSplit(String s) {
        char [] chars= s.toCharArray();
        int r=0;
        int l=0;
        int count=0;
        char x;
        for(int i=0;i<chars.length;i++){
            x=chars[i] ;
            if(x=='R'){
                r++;
            }
            if(x=='L'){
                l++;
            }
            if(r==l){
                count++;
                r=0;
                l=0;
            }
        }
        return count;

    }
}
