package graph;

import java.util.*;

//802. Find Eventual Safe States
//Q: https://leetcode.com/problems/find-eventual-safe-states/
public class FindEventualSafeStates {


    public static void main(String[] args) {
    int matrix[][]=//{{1,2,3,4},{1,2,3,4},{3,4},{4},{}};
            //{{0}, {2,3,4},{3,4},{0,4},{}};
            //{{1,2,3,4},{1,2},{3,4},{0,4},{}};
            {{1,2},
                    {2,3},
                    {5},
                    {0},
                    {5},
                    {},
                    {}
                };
    FindEventualSafeStates  f= new FindEventualSafeStates();
        System.out.println(f.eventualSafeNodes(matrix));
    }
    enum STATE{
        NOCYCLE,CYCLE
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int [] visited = new int [graph.length];

        STATE [] states= new STATE[graph.length];

        List<Integer> result = new ArrayList();
        for(int i =0;i< graph.length;i++){
            int current = noCycle(graph, visited, i);
            if(current == 1)
                result.add(i);
        }
        return result;
    }

    private int noCycle(int [][] graph, int [] visited, int i){
        if(visited[i] !=  0)
            return visited[i];
        visited[i] = -1;
        for(int curr : graph[i]){
            int currRes =  noCycle(graph, visited, curr);
            if(currRes == -1)
                return -1;
        }
        visited[i] = 1;
        return 1;
    }

}
