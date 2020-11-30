package string;

public class CheckIfTwoStringArraysareEquivalent {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuffer sb= new StringBuffer();
        StringBuffer sb2= new StringBuffer();

        for(String s:word1){
            sb.append(s);
        }
        for(String s:word2){
            sb2.append(s);
        }
        return sb.toString().equals(sb2.toString() );
    }
}
