package arrays;
//389. Find the Difference
public class FindtheDifference {
    public static void main(String[] args) {

    }

    /**
     *
     * @param s
     * @param t
     * @return
     */
    public char findTheDifference(String s, String t) {
        int[] letter= new int[26];
        int x=0;
        for(int i=0;i<s.length();i++){
            x= s.charAt(i)-97;
            letter[x]++;
        }
        for(int i=0;i<t.length();i++){
            x= t.charAt(i)-97;
            if(letter[x]<=0){
                return  t.charAt(i);
            }
            letter[x]--;
        }

        return 0;
    }
}
