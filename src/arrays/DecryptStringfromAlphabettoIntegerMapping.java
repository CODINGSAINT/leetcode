package arrays;

public class DecryptStringfromAlphabettoIntegerMapping {
    public static void main(String[] args) {
        //
        DecryptStringfromAlphabettoIntegerMapping d= new DecryptStringfromAlphabettoIntegerMapping();

        System.out.println(d.freqAlphabets("10#11#12"));
        System.out.println(d.freqAlphabets("1326#"));
    }

    public String freqAlphabets(String s) {
        char[] chars=s.toCharArray();
        String currentChar="";
        StringBuffer solution=new StringBuffer();
        for(int i=chars.length-1;i>=0;i--){
            if(chars[i] =='#'){
                currentChar = ""+ chars[i-2]+chars[i-1];
                i-=2;
            }else {
                currentChar =""+(chars[i]);
            }
            char c= (char) (Integer.parseInt(currentChar)+96);
            solution.append(c);
        }
        return solution.reverse().toString();

    }
}
