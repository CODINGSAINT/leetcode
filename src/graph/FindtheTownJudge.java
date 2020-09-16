package graph;
//997. Find the Town Judge
public class FindtheTownJudge {
    public static void main(String[] args) {
        int trust[][]=  { {1,2}};
        FindtheTownJudge f= new FindtheTownJudge();
        System.out.println(f.findJudge(2,trust));
    }
    public int findJudge(int N, int[][] trust) {
        //There are total N person , so number of users possible out EDGE could be N+1

        int personWhoIsBelieved[]= new int[N+1];
        int personWhoBelieves[]= new int [N+1];

        for (int i=0;i< trust.length;i++){
            int []row=trust[i];
            personWhoBelieves[row[0]]++;
            personWhoIsBelieved[row[1]]++;
          /*  System.out.println("-->"+personWhoBelieves[row[0]]);
            System.out.println("-->"+personWhoIsBelieved[row[1]]);
            */

        }

        //Now find if exist any person who has N-1 person beliving in but he doesn't believe on any one
        //since 1 to N person
        for(int i=1;i<=N;i++){
            if(personWhoBelieves[i]==0 & personWhoIsBelieved[i]==N-1){
                return i;
            }
        }
        return -1;
    }
}
