package dynamicprogramming;

public class ArithmeticSlices {
        public int numberOfArithmeticSlices(int[] A) {
            int n=A.length;
            if(n<3)return 0;
            int dp[]=new int [n];

            int diff=(A[1]-A[0]);
            int result=0;
            for(int i=2;i<A.length;i++){
                if(A[i]-A[i-1]==A[i-1]-A[i-2]){
                    dp[i]=dp[i-1]+1;
                    result+=dp[i];
                }
            }

       /* for(int i:dp)
            System.out.print(i+" ");
        System.out.println();*/
            return result;
        }
    }
