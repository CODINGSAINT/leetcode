package graph;

import java.util.*;

public class FlowerPlantingWithNoAdjacent {
    public static void main(String[] args) {
        int paths[][]=  { {1,2},
                {2,3},{3,1}
                            };
        FlowerPlantingWithNoAdjacent f= new FlowerPlantingWithNoAdjacent();
        System.out.println(f.gardenNoAdj(3,paths));
    }

    public int[] gardenNoAdj(int N, int[][] paths) {
        List<List<Integer>> nodes= new ArrayList<>() ;
        for(int i=0;i<N+1;i++){
            nodes.add(i, new ArrayList<Integer>());
        }
        for(int i=0; i< paths.length;i++){
            int path[]= paths[i];
            List<Integer> node = nodes.get(path[0]) ;
            node.add(path[1]);
            nodes.set(path[0],node);
            node = nodes.get(path[1]) ;
            node.add(path[0]);
            nodes.set(path[1],node);
        }
        //Now I have adjacency list of all of the values , visit the node and assign the flower number not used
        int visited []= new int[N+1];
        for(int i=1;i<nodes.size();i++){
            List<Integer> currentNode = nodes.get(i);
            if(visited[i]==0){
                //Not visited till now ,Lets find all conneted path ,visit them and assign a flower number if not used till now
                Set<Integer> alreadyAssigned = new HashSet<>();
                for(int j=0;j<currentNode.size();j++){
                    //create already assigned values so that we dont assign the number which is used by adjacent parks
                    alreadyAssigned.add(visited[currentNode.get(j)]);
                }
                visited[i]= assignFlower(alreadyAssigned);
            }
        }
        int sol[]= new int [N];
        for(int i=1; i< visited.length;i++){
            sol[i-1]=visited[i];
        }
        return  sol;


    }

    int assignFlower(Set<Integer> assigned){
        for(int a=1;a<=4;a++){
            if(!assigned.contains(a))
                return a;

        }
        return -1;
    }
}
