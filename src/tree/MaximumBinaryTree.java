package tree;

public class MaximumBinaryTree {
    public static void main(String[] args) {
        MaximumBinaryTree m= new MaximumBinaryTree();
        int i[]= {3,2,1};
        m.constructMaximumBinaryTree(i);
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if(nums.length==0) return null;
        TreeNode root= constructMaximumBinaryTree(nums,0,nums.length -1 );
        return root;
    }

    /**
     *
     * @param nums
     * @param startIndex The index from where to start finding max
     * @param endIndex The index at where end finding max
     * @return the TreeNode with highest Value after search
     */
    TreeNode constructMaximumBinaryTree(int[] nums, int startIndex, int endIndex){
        if(startIndex==endIndex)
            return new TreeNode(nums[startIndex]);

        if(startIndex<=endIndex){
            // find the highest number from start to end
            int highestIndex= highest(nums, startIndex, endIndex);
            TreeNode root= new TreeNode(nums[highestIndex]) ;
            //repeat from left and right
            root.left= constructMaximumBinaryTree(nums, startIndex, highestIndex-1);
            root.right=constructMaximumBinaryTree(nums, highestIndex+1, endIndex);
            return root;
        }
        return null;

    }

    /**
     *  Find the highest possible value in range from startIndex to endIndex return its index in array
     * @param nums array
     * @param startIndex start index
     * @param endIndex last index
     * @return index of the last val
     */
    private int highest(int[] nums, int startIndex, int endIndex) {
        int highest= Integer.MIN_VALUE;
        int index=-1;
        for(int i=startIndex;i<=endIndex;i++) {
            if (highest< nums[i]){
                highest= nums[i];
                index=i;
            }
        }
        return index;
    }
}
