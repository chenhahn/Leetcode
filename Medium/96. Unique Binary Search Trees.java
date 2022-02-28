// G(n) = F(1, n) + F(2, n) + ... + F(n, n).
// F(i, n) = G(i-1) * G(n-i)	1 <= i <= n  -> (i is the root of the tree, G(i-1) is the number of structurally unique BST's of the left subtree, G(n-i) is the right subtree)
// G(n) = G(0) * G(n-1) + G(1) * G(n-2) + … + G(n-1) * G(0) 
class Solution {
    public int numTrees(int n) {
        int[] G = new int[n+1];
        G[0] = G[1] = 1;
        
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j-1] * G[i-j];
            }
        }
        return G[n];
    }
}

// Time complexity: O(n^2)
// Space complexity: O(n)
