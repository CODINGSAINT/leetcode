package graph;

import java.util.Stack;
//207. Course Schedule https://leetcode.com/problems/course-schedule/
public class CourseSchedule {
    public static void main(String[] args) {
        //
        CourseSchedule c= new CourseSchedule();
        int mat[][]={{1,0},{0,1}};
        c.canFinish(2,mat);
    }
    public boolean canFinish(int numCourses, int[][] p) {
        //first create indegree
        int count=0;
        int [] indegree= new int[numCourses];
        for(int i=0;i<p.length; i++){
            //See the question , its indegree coz 0th elements depends on the first one , so edge is from first to zero
            indegree[p[i][0]]++;
        }

        //Check All those who has no indegree
        Stack<Integer> st= new Stack();
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                st.add(i);
            }
        }
        while(!st.isEmpty()){
            int current = st.pop();
            count++;
            for(int i=0;i< p.length;i++){
                if(p[i][1]==current){
                    indegree[p[i][0]] --;
                    if(indegree[p[i][0]]==0){
                        st.push(p[i][0]);
                    }
                }

            }


        }
        //System.out.println(count);
        return count==numCourses;
    }
}
