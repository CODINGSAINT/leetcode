package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CourseScheduleII {
    public static void main(String[] args) {
        CourseScheduleII c= new CourseScheduleII();
        int mat[][]={{1,0},{2,0},{3,1 },{3,2}};
        c.findOrder(4, mat);
    }

    public int[] findOrder(int numCourses, int[][] p) {

        int[] indegree=new int[numCourses];
        for(int i=0; i<p.length;i++){
            indegree[p[i][0]]++;
        }
        Stack<Integer> st= new Stack();
        List<Integer> res= new ArrayList();
        // Now with known number of course to be compleated let us find those courses who have no dependency
        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0){
                st.push(i);
                res.add(i);
            }

        }

        // Now Let us start with coruse who are independant and find if any couse depends on it
        // To determine the course who depends on it , we can check if this course has any array value of
        // prerequesites with , this course as 1st position, so for all courses which depends on this independent couse lets look at following
        //table
        /*
        | seq| Dependent Course | Depends on|
        | 0  |        1          |  0       |
        | 0  |        2          |  0       |
        | 0  |        3          |  1       |
        | 0  |        3          |  2       |

        So here we will have 1st 0 in stack as 1st element and, while iterating
        indegree =[0,1,1,2]
        */
        while(!st.isEmpty()){
            int currentCourse=st.pop();
            //check how many course depends on it and decrease its occurance in indegree
            for(int i=0; i<p.length;i++){
                int dependantCourse=p[i][0] ;
                int dependsOn =p[i][1];
                if(currentCourse==dependsOn){
                    // this means we have a course for which we have increased a value in indegree
                    indegree[dependantCourse]--;
                    if(indegree[dependantCourse]==0){ //Dependency has been removed so can use this and add to stack as independant course
                        st.add(dependantCourse);
                        res.add(dependantCourse);
                    }
                }
            }
        }
        // If cycle is there the size of courses and the added courses will not match example [[1,0],[1,2],[0,1]]
        if(res.size()!=numCourses) {
            return new int[0];
        }
        //Since we require and array
        int result[]= new int[res.size()];
        for( int i=0;i<res.size();i++) {
            result[i]=res.get(i);
        }
        return result;


    }
}