package tree;
import java.util.*;
// https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/ H
public class VerticalOrderTraversalofaBinaryTree {

    Map<Integer, List<LevelAndValue>> levelOrder= new HashMap<>();
    Integer min=Integer.MAX_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        dfs(root,0,0);
        for (int i = min; i < levelOrder.size(); i++) {
            List<LevelAndValue> val=levelOrder.get(i);

            if(val!=null){

                //Collections.sort(val, (a,b) -> a.level==b.level?b.level-a.level:a.val-b.val);
                Collections.sort(val, (a,b) -> a.level == b.level ? a.val - b.val : a.level - b.level);

                List<Integer>res= new ArrayList<>();
                for(LevelAndValue l: val){
                    //System.out.print(l.val);
                    res.add(l.val);

                } //System.out.println();

                result.add(res);
            }

        }
        //  System.out.println(levelOrder);

        return result;


    }
    void dfs(TreeNode node, int x, int level){
        if(node!=null){
            min=Math.min(min,x);
            if(levelOrder.get(x)==null){

                List<LevelAndValue> current=new ArrayList<>();
                current.add(new LevelAndValue( level , node.val) );
                levelOrder.put(x,current);
            }else{
                List<LevelAndValue> current= levelOrder.get(x);
                current.add(new LevelAndValue( level , node.val) );
                levelOrder.put(x,current);

            }
            dfs(node.left, x-1,level+1);
            dfs(node.right, x+1,level+1);



        }

    }
    class LevelAndValue{
        public int level;
        public int val;
        public LevelAndValue(int l,int v){
            level=l;
            val=v;
        }
        @Override
        public String toString() {
            return "LevelAndValue{" +
                    "level=" + level +
                    ", val=" + val +
                    '}';
        }
    }
}
