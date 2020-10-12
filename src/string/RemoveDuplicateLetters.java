package string;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {

    }
    public String removeDuplicateLetters(String s) {

        char []chars= s.toCharArray();
        boolean []used=new boolean[26];
        int []count= new int[26];
        for(int i=0;i<chars.length;i++){
            int curr=chars[i];
            count[curr-'a'] ++;
        }
        //   Input: s = "cbacdcbc"
        //  Output: "acdb"
        StringBuffer sb= new StringBuffer();
        for(int i=0;i<chars.length;i++){
            int curr=chars[i];
            count[curr-'a'] --;
            if(used[curr-'a']) continue;
            while(sb.length()>0
                    && sb.charAt(sb.length()-1)>chars[i]
                    && count[sb.charAt(sb.length()-1)-'a']>0 ){
                used[sb.charAt(sb.length()-1)-'a']=false;
                sb.deleteCharAt(sb.length()-1);
            }
            sb.append(chars[i]);
            used[curr-'a']=true;
            //  System.out.println(sb.toString());

        }
        // System.out.println(sb.toString());
        return sb.toString();
    }
    }
