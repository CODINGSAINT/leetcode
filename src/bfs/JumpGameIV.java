package bfs;

import utils.LeetCode;
import utils.Level;

import java.util.*;

@LeetCode(no=1345,level = Level.HARD,title = "Jump Game IV", url = "https://leetcode.com/problems/jump-game-iv/")
public class JumpGameIV {
    public int minJumps(int[] arr) {
        int n= arr.length;
        boolean visited[]= new boolean [n];
        Map<Integer, List<Integer>> map= new HashMap<>();

        for(int i=0;i<n;i++) {
            map.computeIfAbsent(arr[i], list->new ArrayList()).add(i);
        }
        Queue<Integer> q= new LinkedList<>();
        q.add(0);
        visited[0] = true;
        int step=0;
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int i=q.poll();
                if(i==n-1) return step;
                List<Integer> adjList= map.get(arr[i]);
                if(i+1<n)
                    adjList.add(i+1);
                if(i-1 >=0)
                    adjList.add(i-1);

                for(int j:adjList){
                    if(!visited[j])
                        q.add(j);
                    visited[j]=true;
                }
                adjList.clear();

            }
            step++;
        }
        return step;
    }
}