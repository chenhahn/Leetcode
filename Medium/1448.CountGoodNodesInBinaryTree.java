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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, root.val);
    }
    
    public int goodNodes(TreeNode node, int max) {
        if(node == null) return 0;
        int result = node.val >= max ? 1 : 0;
        result += goodNodes(node.left, Math.max(max, node.val));
        result += goodNodes(node.right, Math.max(max, node.val));
        return result;
    }
}

// Time O(N)
// Space O(height)