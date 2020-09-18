package graph;

import java.util.List;
import java.util.Stack;
// |841|[Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/)| Medium | [KeysandRooms](https://github.com/CODINGSAINT/leetcode/blob/master/src/graph/KeysandRooms.java)|

public class KeysandRooms {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // Step 1: Find the total Number of Rooms
        int totalRooms=rooms.size();
        //   System.out.println("Total Number of rooms found is "+ totalRooms);
        // Add 0 to stack and visit it .
        Stack<Integer> st= new Stack();
        st.push(0);
        boolean visited[]= new boolean[totalRooms];
        // Find all the connected room to top of the stack push them
        while(!st.isEmpty()){
            int i= st.pop();
            //visiting i
            visited[i]= true;
            //check all keys available in ith room
            rooms.get(i);
            for(int j: rooms.get(i)){
                // System.out.println("Room  "+ i +" has key of "+j);
                if(visited[j]==false)
                    st.push(j);
            }

        }
        // if all rooms are not visited there is not way to visit all rooms with these many keys
        for(boolean i: visited){
            if(i==false)
                return i;
        }
        return true;
    }
}
