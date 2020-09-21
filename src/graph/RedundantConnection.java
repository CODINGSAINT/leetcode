package graph;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/redundant-connection/
 * 684. Redundant Connection
 */
public class RedundantConnection {

    // This problem is of  Union Find
    public int[] findRedundantConnection(int[][] edges) {
        int totalNode =edges.length;

        int[]parent = new int[totalNode+1];
        Arrays.fill(parent,-1);

        for(int []current:edges){

            int u=current[0];
            int v=current[1];
            int parent_u= find(u, parent);
            int parent_v= find(v, parent);

            if(parent_u!=parent_v){
                union(parent_u, parent_v, parent);
            }else{
                return new int[]{u,v};
            }
        }
        return null;
    }

    int find(int vertex, int[] parent) {
        while(parent[vertex]>-1){
            //System.out.println("vertex: "+vertex+"parent[vertex] "+parent[vertex]);
            vertex=parent[vertex];
        }

        return vertex;
    }

    void union(int parent_u, int parent_v ,int parent[]){
        int totalNodes = parent[parent_u] + parent[parent_v];
        if(parent[parent_u] <= parent[parent_v]){
            parent[parent_v] = parent_u;
            parent[parent_u] = totalNodes;
        }else{
            parent[parent_u] = parent_v;
            parent[parent_v] = totalNodes;
        }
    }
}
