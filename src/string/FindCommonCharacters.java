package string;

import utils.LeetCode;
import utils.Level;

import java.util.ArrayList;
import java.util.List;

@LeetCode(
        no=1002,title = "Find Common Characters" ,level = Level.EASY,url = "https://leetcode.com/problems/find-common-characters/"
)
public class FindCommonCharacters {
    public static void main(String[] args) {
        FindCommonCharacters f= new FindCommonCharacters();
        System.out.println(f.commonChars(new String[]{"bella","label","roller"}));
    }

    public List<String> commonChars(String[] A) {
        List<String> result= new ArrayList<>();

        int prev[]= new int[26];
        for(int i=0;i<A.length;i++){
            String s=A[i];
            int []current=new int[26];

            for(int j=0;j<s.length();j++){
                char c=s.charAt(j);
                if(i==0){
                    prev[c-'a']++ ;
                }
                current[c-'a']++;

            }
            if(i>0){
                for(int j=0;j<current.length;j++){
                    if(prev[i]>current[i]){
                        prev[i]=prev[i]-current[i];
                    }else if(prev[i]!=current[i]){
                        prev[i]=0;
                    }
                }
            }
        }
        for(int j=0;j<prev.length;j++){
            System.out.print(" "+prev[j]);
        }
        System.out.println();
        return new ArrayList<String>();



    }
}
