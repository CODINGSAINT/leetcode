package graph;
import java.util.*;
//785. Is Graph Bipartite?
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        // 0 = no color = 1 = red 2 =blue
        //The nodes array will keep the value of all the unvisited , visited colors
        int []visited = new int[graph.length];

        for (int i=0;i<graph.length; i++) {
            int []adjacent = graph[i];
            //checking if already visited or not and if it even has adjacent nodes
            if(adjacent.length>0 && visited[i]==0){
                //OK Lets paint it red
                visited[i]=1;
                Queue<Integer> q= new LinkedList<Integer>();
                q.offer(i);
                while(!q.isEmpty()) {
                    int curr= q.poll();
                    for(int c: graph[curr]) {
                        if(visited[c]==0) {
                            // Lets paint it with alternate colors

                            visited[c] = visited[curr] ==1?2:1;
                            q.offer(c);
                        }else{
                            if(visited[c]==visited[curr]){
                                return false;
                            }
                        }
                    }

                }

            }
        }
        return true;
    }
}
