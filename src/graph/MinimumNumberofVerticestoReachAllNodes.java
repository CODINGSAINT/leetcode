package graph;

import java.util.ArrayList;
import java.util.List;
//1557 Minimum Number of Vertices to Reach All Nodes
public class MinimumNumberofVerticestoReachAllNodes {
    public static void main(String[] args) {

    }
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        /*
         1. If we look at this question we can understand any edge which has no incoming path ,  means there is no way to reach it.
        2. To get the minimum we need to start from these node and obviously there will be a way to reach all other nodes from here (Since they have incoming paths)
        */
        List<Integer> res = new ArrayList<>();
        //initialize array to find the indegree
        var indegree = new int[n];
        for (int i = 0; i < edges.size(); i++) {
            List<Integer> edge = edges.get(i);
            indegree[edge.get(1)]++;
        }

        //Traversing through the graph ,  Let us validate the values with 0 (zero) indegree
        for (int i = 0; i < indegree.length; i++) {
            int val = indegree[i];
            if (val == 0) { //No way this ith node so add it to result coz its all others can be traversed from here
                res.add(i);
            }
        }
        return res;
    }
}

