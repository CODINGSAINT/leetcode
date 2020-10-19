package greedy;
//1007. Minimum Domino Rotations For Equal Row
public class MinimumDominoRotationsForEqualRow {
    public int minDominoRotations(int[] A, int[] B) {
        //There are only 6 possible values for this rotation , so let us find which numbers to look for in opposite array
        int []allElements= new int [6];
        for(int i=0;i<A.length;i++){
            if(allElements[A[i]-1]==0)
                allElements[A[i]-1]=A[i];
            if(allElements[B[i]-1]==0)
                allElements[B[i]-1]=B[i];
        }
        // By now we will have all of the numbers present in both dices , else the ith value of allElements will be 0

        int minSwap=0;// will store all minimum number of swaps required
        // There are chances that all elements of A and B are same ,if so return 0
        boolean allSame=true;
        for(int i=0;i<6;i++){
            if(allElements[i]!=0){
                //Either we can swap A to B or B to A so creating the swaps for both cases, We will check which is minimum to return minimum , we will store it in minSwap variable
                int minSwap_1=0;
                int minSwap_2=0;
                //Let us assume that any number from dice which we are checking ( whose value is not zero) , it is possible to swap from B to A or A to B
                boolean possibleSwapOne=true;
                boolean possibleSwapTwo=true;
                int currentNum=allElements[i];
                int firstNum=A[0];
                for(int j=0;j<A.length;j++){
                    //Check if any number is not same from the first number in A , if numbers in A or B are  same this condition will neber be true
                    if(allSame &&(firstNum!=A[j] || firstNum!=B[j])){
                        allSame=false;
                    }
                    //swap for this number is only possible if currentNum (0-6) if not present in B should be present in A or if not present in A it must be in B , if possible increment minSwap_1 or minSwap_2

                    if(A[j]!=currentNum && B[j]==currentNum)
                        minSwap_1++;
                    if(B[j]!=currentNum && A[j]==currentNum)
                        minSwap_2++;

                    //if number is not present at jth index in any of the A or B it is not possible to swap in this case , lets break
                    if(currentNum!=A[j] && currentNum!=B[j]){
                        possibleSwapOne=false;
                        possibleSwapTwo=false;
                        break;
                    }
                }
                // Since it was possible to swap lets find the minimum , if minSwap is zero (0) we never have a chance to create an similar dices so check from minSwap_1 and minSwap_2 , else from minSwap determined in prev value i.e. minSwap or smaller in minSwap_1 and minSwap_2
                if(possibleSwapOne && possibleSwapTwo){
                    if(minSwap==0){
                        minSwap= Integer.min(minSwap_1,minSwap_2);
                    }else{
                        minSwap= Integer.min(minSwap,minSwap_1<minSwap_2?minSwap_1:minSwap_2);
                    }
                }
            }

        }
        //if all elements were same return 0 else minSwap , as per question if there was no chance to swap return -1
        return allSame?0: minSwap==0?-1:minSwap;
    }

}