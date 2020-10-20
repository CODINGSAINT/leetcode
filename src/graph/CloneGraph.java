package graph;

import java.util.*;
//https://leetcode.com/problems/clone-graph/
public class CloneGraph {

    public Node cloneGraph(Node node) {
        if(node == null ) return null;
        Node clone = clone(node);
        return clone;
    }
    public Node clone (Node node){
        Queue <Node> q= new LinkedList<>();
        Set<Integer> vals= new HashSet<>();
        HashMap<Integer , Node> map= new HashMap<>();
        q.offer(node);

        while(!q.isEmpty()){
            Node temp= q.poll() ;
            if(!vals.contains(temp.val)){
                map.put(temp.val, new Node(temp.val));
                vals.add(temp.val);
                for(Node n: temp.neighbors){
                    q.offer(n);
                }
            }

        }
        q.offer(node);
        vals.clear() ;

        while(!q.isEmpty()){
            Node temp= q.poll();
            if(!vals.contains(temp.val) ){
                vals.add(temp.val);
                Node cloned= map.get(temp.val );
                for(Node n: temp.neighbors){
                    cloned.neighbors.add(map.get(n.val) );
                    q.offer(n);
                }
            }

        }
        return map.get(node.val);

    }


}
