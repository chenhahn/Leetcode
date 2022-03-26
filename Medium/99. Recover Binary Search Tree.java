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
// Recursion
class Solution {
    TreeNode preEl;
    TreeNode firstEl;
    TreeNode secondEl;
    public void recoverTree(TreeNode root) {
        preEl = null;
        firstEl = null;
        secondEl = null;
        inorder(root);

        int temp = firstEl.val;
        firstEl.val = secondEl.val;
        secondEl.val = temp;
    }
    private void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        if (preEl != null && firstEl == null && preEl.val > root.val) {
            firstEl = preEl;
        }

        if (firstEl != null && preEl.val > root.val) {
            secondEl = root;
        }
        preEl = root;
        inorder(root.right);
    }
}

// Time complexity: O(n)
// Space complexity: O(h)


// Morris Traversal

class Solution {
    public void recoverTree(TreeNode root) {
        if (root == null) 
            return;
        
        TreeNode current = root;
        TreeNode pre;
        TreeNode last = null;
        TreeNode first = null, second = null;
        while (current != null) {
            if (current.left == null) {
                if (last != null && first == null && last.val > current.val) {
                    first = last;
                }
                
                if (first != null && last.val > current.val) {
                    second = current;
                }
                
                last = current;
                current = current.right;
            } else {
                pre = current.left;
                while (pre.right != null && pre.right != current)
                    pre = pre.right;
                
                if (pre.right == null) {
                    pre.right = current;
                    current = current.left;
                } else {
                    if (last != null && first == null && last.val > current.val) {
                        first = last;
                    }
                
                    if (first != null && last.val > current.val) {
                        second = current;
                    }
                    pre.right = null;
                    last = current;
                    current = current.right;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}

// Time complexity: O(n)
// Space complexity: O(1)