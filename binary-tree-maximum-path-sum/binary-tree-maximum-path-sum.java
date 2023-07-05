/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxPathSum(TreeNode root) {
        int[] ans=new int[1];
        ans[0]=Integer.MIN_VALUE;
        pathSum(root,ans);
        return ans[0];
    }
    public int pathSum(TreeNode root,int[] ans)
    {
        if(root==null)return 0;
        int leftSum=Math.max(0,pathSum(root.left,ans));
        int rightSum=Math.max(0,pathSum(root.right,ans));
        ans[0]=Math.max(ans[0],(leftSum+rightSum+root.val));
        return root.val+Math.max(leftSum,rightSum);
    }
}