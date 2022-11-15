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
    public int countNodes(TreeNode root) {
        return countNodes(root, 0);        
        
    }
    
    public int countNodes(TreeNode root, int sum) {
        if(root == null) return 0;
        
        sum++;        
        sum += countNodes(root.left, 0);
        sum += countNodes(root.right, 0);        
        return sum;
        
        
    }
}