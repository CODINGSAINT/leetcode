package misc;
// https://leetcode.com/problems/complement-of-base-10-integer/
// 1009. Complement of Base 10 Integer [TODO Solve with bitwise]
public class ComplementofBase10Integer {

    public int bitwiseComplement(int N) {
        if(N==0) return 1;
        StringBuilder binaryRevStr= new StringBuilder();
        while(N > 0){
            // binary.add(0,N%2==0?1:0);
            binaryRevStr.insert(0,N%2==0?"1":"0");
            N = N/2;
        }


        return Integer.parseInt(binaryRevStr.toString(),2);

    }
    }

