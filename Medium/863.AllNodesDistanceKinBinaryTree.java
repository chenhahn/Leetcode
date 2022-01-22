/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<TreeNode, TreeNode> parents;
    List<Integer> ans;
    
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parents = new HashMap<>();
        ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> seens = new HashMap<>();
        saveParent(root, null);
        queue.offer(target);
        seens.put(target, true);
        for (int i = 0; i < k; i++) {
            int size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.poll();
                if (cur.left != null && seens.getOrDefault(cur.left, false) != true) {
                    seens.put(cur.left, true);
                    queue.offer(cur.left);
                }
                if (cur.right != null && seens.getOrDefault(cur.right, false) != true) {
                    seens.put(cur.right, true);
                    queue.offer(cur.right);
                }
                if (parents.get(cur) != null && seens.getOrDefault(parents.get(cur), false) != true){
                    seens.put(parents.get(cur), true);
                    queue.offer(parents.get(cur));
                }
                size--;
            }
        }
        
        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }
        
        return ans;
    }
    
    public void saveParent(TreeNode node, TreeNode parent) {
        if (node != null) {
            parents.put(node, parent);
            saveParent(node.left, node);
            saveParent(node.right, node);
        }
    }
}

// Time complexity: O(n)	n -> number of nodes
// Space complexity: O(n)