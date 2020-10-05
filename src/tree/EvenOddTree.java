package tree;
import java.util.*;
//https://leetcode.com/problems/even-odd-tree/
//1609. Even Odd Tree
public class EvenOddTree {
    public boolean isEvenOddTree(TreeNode root) {

        if(root!=null){
            if(root.val%2==0) return false;
            int level=0;
            Queue<TreeNode> q= new LinkedList<>();
            List<Integer>vals= new ArrayList<>();
            q.offer(root);
            q.offer(null);
            while(!q.isEmpty()){
                TreeNode temp= q.poll();
                if(temp!=null){
                    vals.add(temp.val);
                    if(temp.left!=null){
                        q.offer(temp.left);
                    }
                    if(temp.right!=null){
                        q.offer(temp.right);
                    }

                }else{
                    if(level>0){
                        //Check if the level is odd
                        if(level%2!=0){
                            // check if the all of the values inside is even and it is in strictly decreasing order
                            // For decreasing order current should always be lesser than prev so check if current is higer than prev, so start prev with max
                            int prev=Integer.MAX_VALUE;
                            for(int i= 0;i< vals.size(); i++){
                                int curr = vals.get(i);
                                if(curr%2!=0 || curr>=prev){

                                    return false;
                                }

                                prev=curr;
                            }

                        }else{//even level
                            // check if the all of the values inside is odd and it is in strictly increasing order
                            int prev=Integer.MIN_VALUE;
                            for(int i= 0;i< vals.size(); i++){
                                int curr = vals.get(i);
                                if(curr%2==0 || curr<=prev){

                                    return false;
                                }
                                prev=curr;
                            }
                        }


                    }
                    if(!q.isEmpty()) {
                        q.offer(null);
                    }
                    vals.clear();
                    level++;
                }
            }
            return true;
        }
        return true;

    }
}

