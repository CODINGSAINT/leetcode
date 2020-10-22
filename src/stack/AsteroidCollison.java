package stack;

import java.util.*;
//https://leetcode.com/problems/asteroid-collision/
//735. Asteroid Collision
public class AsteroidCollison {
    public static void main(String[] args) {
        AsteroidCollison a= new AsteroidCollison();
        int as[]= {-2,-1,1,2};
        a.asteroidCollision(as);
    }

    /**
     *
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        if(asteroids.length==0) return asteroids;
        Stack<Integer> st= new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            if(asteroids[i]>0){
                st.push(asteroids[i]);
            }else{
                int curr=asteroids[i];
                while(!st.isEmpty() &&
                        st.peek() <  Math.abs(asteroids[i]) // last asteroids is smaller
                        && st.peek() > 0 )// last value is positive
                {
                    st.pop();
                }

                if(st.isEmpty() //Its already empty add current
                        || st.peek()<0)// both current and last are -ve so cant collide
                {
                    st.add(asteroids[i] );
                }
                else if(st.peek()==Math.abs(asteroids[i])
                ){
                    st.pop();
                }

            }

        }
        int res[]=new int[st.size()];
        int i=st.size()-1;
        while(!st.isEmpty()){
            res[i]=st.pop();
            i--;
        }
        return res;


    }


    /**
     * Below solution is without stack  and using a list
     * @param asteroids
     * @return
     */
        public int[] asteroidCollisionWithoutStack(int[] asteroids) {
            if(asteroids.length==0) return asteroids;
            List<Integer> results= new ArrayList<>();
            for(int i=0; i<asteroids.length;i++){
                results.add(asteroids[i]);
                if(i>0 && results.size()>1){
                    int last=results.get(results.size()-2);
                    int current= results.get(results.size()-1);
                    while(last>0 && current<0){
                        if(Math.abs(last) > Math.abs(current) ){
                            results.remove(results.size()-1);
                        } else if(Math.abs(last) < Math.abs(current) ){
                            results.remove(results.size()-2);
                        } else {
                            results.remove(results.size()-1);
                            results.remove(results.size()-1);
                        }
                        if(results.size()>1) {
                             last=results.get(results.size()-2);
                             current= results.get(results.size()-1);
                        }else{
                            break;
                        }
                    }
                }
            }
            //System.out.println(results);
            return  results.stream().mapToInt(i->i).toArray();

    }

}


