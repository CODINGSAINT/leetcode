package graph;
//https://leetcode.com/problems/friend-circles/
public class FriendCircles {

    public int findCircleNum(int[][] M) {

        int parent[] = new int[M.length];
    int []rank= new int[M.length];
        for(int i=0;i<M.length;i++) {
        parent[i]=i;
        rank[i]=1;

    }
        for(int i=0;i<M.length;i++){
        for(int j=0;j<M.length;j++){
            if(M[i][j]==1 && i!=j){
                int u_parent= find(i, parent);
                int v_parent= find(j,parent);
                if(u_parent!=v_parent){
                    union(u_parent,v_parent,parent,rank);
                }
            }
        }

    }
    int total=0;

            for(int i=0;i<parent.length;i++){
        if(i==parent[i]){
            total++;
        }


    }


        return total;
}

    int find(int n, int[]parent){
        while(n!=parent[n])
            n=parent[n];

        return n;


    }

    void union(int u, int v,int[] parent, int []rank){
        if(rank[u]>rank[v]){
            parent[v]=u;
            rank[u]+= parent[v];
        }else {
            parent[u]=v;
            rank[v]+=parent[u];
        }
    }
}