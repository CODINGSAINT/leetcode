package string;

public class MergeStringsAlternately {
    public String mergeAlternately(String word1, String word2) {
        int len =Integer.max(word1.length() , word2.length());
        StringBuffer sb= new StringBuffer();
        for (int i = 0; i < len; i++) {
            if(i>word1.length()-1){
                sb.append(word2.substring(i));
                break;
            }if(i>word2.length()-1){
                sb.append(word1.substring(i));
                break;
            }
            sb.append(word1.charAt(i));
            sb.append(word2.charAt(i));

        }
        return sb.toString();
    }
}
