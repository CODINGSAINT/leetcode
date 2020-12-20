package string;

import utils.LeetCode;
import utils.Level;

@LeetCode(no=1694,title = " Reformat Phone Number", level = Level.EASY, url = "https://leetcode.com/problems/reformat-phone-number/")
public class ReformatPhoneNumber {
    public static void main(String[] args) {
        ReformatPhoneNumber r= new ReformatPhoneNumber();
        System.out.println(r.reformatNumber("1-23-45 6"));
        System.out.println(r.reformatNumber("123 4-567"));
        System.out.println(r.reformatNumber("123 4-5678"));
        System.out.println(r.reformatNumber("12"));

    }
    public String reformatNumber(String number) {
        number= number.replaceAll(" " ,"").replaceAll("-","");

        int len= number.length();
        StringBuffer sb= new StringBuffer();
        char [] numbers=number.toCharArray();
        int pos=0;
        int last=len;
        for(int i=0;i< numbers.length;i++){
            pos++;
            if( last-(last-pos) == 3 && i!=numbers.length-1){
                sb.append(numbers[i]+"");
                sb.append("-");
                last=last-pos;
                pos=0;
            }else if(last-(last-pos)==5){
                sb.append(number.substring(i, (i+3)) );
                sb.append("-");
                sb.append(number.substring(i+4 ));
                break;
            }else if((numbers.length)-i==4){
               // System.out.println("U");
                sb.append(number.substring(i, (i+2)) );
                sb.append("-");
                sb.append(number.substring(i+2));
                break;
            }else{
                sb.append(numbers[i]+"");
            }


        }
        return sb.toString();
    }
}
