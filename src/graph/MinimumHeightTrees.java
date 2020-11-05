package graph;

import utils.LeetCode;
import utils.Level;

import java.util.*;


@LeetCode(no=310,
title = "Minimum Height Trees",
level = Level.MEDIUM,
url = "https://leetcode.com/problems/minimum-height-trees/")
public class MinimumHeightTrees {


        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            List<Integer> mins= new ArrayList<>();
            if(n==1) {
                mins.add(0);
                return mins;
            }
            int out[]= new int[n];
            List<List <Integer>> adj = new ArrayList<>();
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }
            for(int e[]:edges){
                out[e[0]]++;
                out[e[1]]++;
                adj.get(e[0]).add(e[1]);
                adj.get(e[1]).add(e[0]);

            }
            Queue<Integer> q= new LinkedList<>();
            for(int i=0;i<n;i++){
                if(out[i]==1){
                    q.add(i);
                }
            }

            while(n>2){
                int size=q.size();
                n-=size;

                while(size-->0){
                    int vertex= q.poll();
                    for(int i:adj.get(vertex)){
                        out[i]--;
                        if(out[i]==1){
                            q.add(i);
                        }
                    }
                }
            }

            mins.addAll(q);
            return mins;

        }
    }



/*

//NOT OPTIMAL FAILS IN TIME COMPLEXITY AFTER 5000 nodes

   class Solution {
		 int maxPathLength=0;
	    int minHeight=Integer.MAX_VALUE;
	    int maxPathVal[];
	  //  int minPathVal[];
	    Map<Integer,List<Integer>> heights= new HashMap<>();
	    public List<Integer> findMinHeightTrees(int n, int[][] edges) {

            List<Integer> mins= new ArrayList<>();
          if(n==1) {
            mins.add(0);
            return mins;
        }

            if(n==2){
                 mins.add(0);
                    mins.add(1);

                return mins;
            }
	        //List<Integer> mins= new ArrayList<>();
	        Map<Integer,Set<Integer>> aM= new HashMap<>();
	        maxPathVal=new int [n];
           // minPathVal= new int[n];

             for(int i=0;i<n;i++){
                 aM.put(i,new HashSet<>());
             }

	        for(int i=0;i<edges.length;i++){
	            int[]edge= edges[i];
	            Set<Integer> ai=aM.get(edge[0]);

	            ai.add(edge[1]);
	            aM.put(edge[0],ai);
	            Set<Integer> aj=aM.get(edge[1]);

	            aj.add(edge[0]);
	            aM.put(edge[1],aj);

	        }

	       for(int i=0;i<n;i++) {
               if(aM.get(i).size()>1){


	    	    getMaxPath(i, i,i,0, aM);
	    	   // System.out.println(maxPathLength);
	    	    maxPathVal[i]=maxPathLength;
	    	    minHeight= Integer.min(minHeight, maxPathLength);

               List<Integer>vals=heights.get(maxPathLength);
               if(vals==null){
                   vals= new ArrayList<>();
               }
               vals.add(i);
               heights.put(maxPathLength,vals);
	    	   maxPathLength=0;
                    }
	       }




	        return heights.get(minHeight);
	    }

		private int getMaxPath(int i,int prev, int current,int currentLength, Map<Integer, Set<Integer>> aM) {

			Set<Integer>neighbours= aM.get(i);
			Set<Integer>toTraverse= new HashSet<>();
			  Iterator<Integer> value = neighbours.iterator();

			while(value.hasNext()) {
                int n=value.next();
				if(n!=prev && n!=current && n!=i) {
					toTraverse.add(n);
				}
			}
           if(toTraverse.size()==0) return currentLength;
             value = toTraverse.iterator();

			while(value.hasNext()) {
                int n=value.next();

				maxPathLength= Integer.max(maxPathLength,
						getMaxPath (n,i,current,(currentLength+1),aM ));

			}

			return maxPathLength;
		}
    }
}*/
