package graph;

/**
 * 1267. Count Servers that Communicate
 * Q : https://leetcode.com/problems/count-servers-that-communicate/
 * As per the Question
 * if we have any server in same row and column consider connected so increment it
 */
public class CountServersthatCommunicate {
    public static void main(String[] args) {
        int mat[][] = {{1,0,0,1,0},{0,0,0,0,0}, {0,0,0,1,0}};
        CountServersthatCommunicate c= new CountServersthatCommunicate();
        System.out.println(c.countServers(mat));

    }

    public int countServers(int[][] grid) {
        int connected=0;
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[i].length; j++){
                // System.out.print(grid[i][j] +" ");
                if(grid[i][j] ==1 && validateConnected(i,j,grid)){

                    connected++;
                }
            }
            //   System.out.println();
        }return connected;
    }
    boolean validateConnected(int row, int column ,int[][] grid ){
        //
        // System.out.println("Current Row "+row+"Current column "+column);
        for(int i=0;i<grid.length; i++){
            if(grid[i][column] ==1 && row!=i){
                return true;
            }
        }
        for(int i=0;i<grid[row].length; i++){
            if(grid[row][i] ==1 && column!=i){
                return true;
            }
        }
        return false;
    }
}
