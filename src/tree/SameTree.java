package tree;

public class SameTree {
    public static void main(String[] args) {

    }
    public boolean isSameTree(TreeNode p, TreeNode q) {

        if(p==null && q!=null || q==null &&p!=null){
            return false;
        }else if (p==null && q==null){
            return true;

        }

        if (p.val !=q.val){
            return false;
        }

        return isSameTree( p.left,  q.left) && isSameTree( p.right,  q.right);


    }
}
