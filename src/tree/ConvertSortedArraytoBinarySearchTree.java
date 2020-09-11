package tree;

public class ConvertSortedArraytoBinarySearchTree {
    public static void main(String[] args) {

    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return balancedBST(nums, 0, nums.length-1);

    }
    TreeNode balancedBST(int nums[], int start, int end){
        if(start>end){
            return null;
        }
        int mid=(start+end)/2;
        TreeNode t= new TreeNode(nums[mid]);

        t.left= balancedBST(nums, start, mid-1);
        t.right= balancedBST(nums, mid+1, end);
        return t;

    }
}
