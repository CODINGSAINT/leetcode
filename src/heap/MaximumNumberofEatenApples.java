package heap;

import java.util.PriorityQueue;

public class MaximumNumberofEatenApples {
    public int eatenApples(int[] apples, int[] days) {

        int n=days.length;
        PriorityQueue<FreshApples> q= new PriorityQueue<FreshApples>( (a, b) -> a.expiryDate-b.expiryDate);
        int appleEaten=0;
        for(int i=0;i<n;i++){
            q.offer(new FreshApples(i+days[i] , apples[i]));
            // Let us remove Rotten Apples
            while(! q.isEmpty() && q.peek().expiryDate<=i){
                q.poll();
            }
            //OK Let us eat the apple
            if(!q.isEmpty()){
                appleEaten+=1;
                q.peek().apples-=1;
                // what if After eating apple it is empty now
                if(q.peek().apples==0)
                    q.poll();
            }
        }


        // we have reached the nth day
        int i=n;
        // Let us see how many more days we can proceed with apples in q


        while( !q.isEmpty() )
        {
            while(! q.isEmpty() && q.peek().expiryDate<=i){
                q.poll();
            }
            //OK Let us eat the apple
            if(!q.isEmpty()){
                appleEaten+=1;
                q.peek().apples-=1;
                // what if After eating apple it is empty now
                if(q.peek().apples==0)
                    q.poll();
            }
            i+=1;
        }


        return appleEaten;

    }
}
class FreshApples{
    FreshApples(int expiryDate, int apples){
        this.expiryDate=expiryDate;
        this.apples=apples;
    }
    public int expiryDate;
    public int apples;
}