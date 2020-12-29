package heap;

import utils.LeetCode;
import utils.Level;

import java.util.PriorityQueue;

@LeetCode(no=1046,
        title = " Last Stone Weight",
        level = Level.EASY,
        url = "https://leetcode.com/problems/last-stone-weight/")
public class LastStoneWeight {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Stone> q= new PriorityQueue<>((a , b) -> b.weight-a.weight );
        for(int i=0;i< stones.length; i++){
            q.offer(new Stone(stones[i])) ;
            System.out.print(q.peek().weight +" ");
        }
        while(!q.isEmpty()) {
            if(q.size()==1){
                return q.peek().weight;

            }
            Stone mostHeavy= q.poll();
            if(mostHeavy.weight == q.peek().weight){
                q.poll();
            }else if(mostHeavy.weight> q.peek().weight){
                mostHeavy.weight-=q.poll().weight;
                q.offer(mostHeavy);
            }else{
                q.peek().weight-= mostHeavy.weight;
            }
        }
        return 0;
    }
    class Stone{
        int weight;
        Stone(int w){
            weight=w;
        }
    }
}